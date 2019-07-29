/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms.webservices;

/**
 *
 * @author kim
 */
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import javax.xml.ws.handler.MessageContext; 
//import org.kephis.cms.entities.controllers.ECertificateListJpaController;
import javax.xml.ws.WebServiceContext;
import org.bouncycastle.util.encoders.Base64;
import org.kephis.cms.entities.ECertUsers;
import org.kephis.cms.entities.controllers.ECertUsersJpaController;
import org.kephis.cms.entities.controllers.ECertificateDetailsJpaController;
import org.kephis.cms.utilities.UtilityClass;
import static org.kephis.cms.webservices.CMSBasicAuthenticator.getHash;

@WebService(name = "CMS_WEBSERVICES", serviceName = "KEPHIS_CMS_WS")
public class KEPHIS_CMS_WS_SEC_Impl {

    @Resource
    WebServiceContext webServiceContext;
    UtilityClass util = new UtilityClass();
    @PersistenceUnit
    private EntityManagerFactory emf;
    private static final int STATUS_ACCEPTED = 1;
    private static final int STATUS_REQUEST_REPLACEMENT = 2;
    private static final int STATUS_REJECTED = 3;
    private static final int STATUS_ACKNOWLEDGED = 4;

    UserTransaction utx;

    @WebMethod(operationName = "ping")
    public String ping() {
        MessageContext messageContext = webServiceContext.getMessageContext();

        Map<?, ?> requestHeaders = (Map<?, ?>) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        String base64Credentials = requestHeaders.get("Authorization").toString().substring("Basic ".length()).trim();
        String credentials = null;
        try {
            credentials = new String(decoder.decodeBuffer(base64Credentials));
        } catch (IOException ex) {
            Logger.getLogger(KEPHIS_CMS_WS_SEC_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        final String[] values = credentials.split(":", 2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertUsersJpaController ecertUsersCon = new ECertUsersJpaController(emf);
        List<ECertUsers> UserList = ecertUsersCon.findECertUsersEntities();
        String returnvalue="Provide valid  User details";
        for (Iterator<ECertUsers> iterator = UserList.iterator(); iterator.hasNext();) {
            ECertUsers user = iterator.next(); 
           if (values[0].equals(user.getUsername()) && user.getPassword().equals(getHash(values[1],"MD5"))) {
               returnvalue= "This User name " + values[0] + " is valid"; 
            }  
           else{
           returnvalue= "Provide valid  User details"; 
           }
        }
        return returnvalue;
    }

    private String getUserCountry() {
        MessageContext messageContext = webServiceContext.getMessageContext();

        Map<?, ?> requestHeaders = (Map<?, ?>) messageContext.get(MessageContext.HTTP_REQUEST_HEADERS);
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        String base64Credentials = requestHeaders.get("Authorization").toString().substring("Basic ".length()).trim();
        String credentials = null;
        try {
            credentials = new String(decoder.decodeBuffer(base64Credentials));
        } catch (IOException ex) {
            Logger.getLogger(KEPHIS_CMS_WS_SEC_Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        final String[] values = credentials.split(":", 2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertUsersJpaController ecertUsersCon = new ECertUsersJpaController(emf);
        List<ECertUsers> UserList = ecertUsersCon.findECertUsersEntities();
        for (Iterator<ECertUsers> iterator = UserList.iterator(); iterator.hasNext();) {
            ECertUsers user = iterator.next();
            System.out.println(values[0]+" "+values[1]+" "+user.getPassword());
        
             if (values[0].equals(user.getUsername()) && user.getPassword().equals(getHash(values[1],"MD5"))) {
                
                return user.getCountrycode();

            }

        }
        return "";
    }

    @WebMethod(operationName = "find_certificates_by_update_date")
    public String[] find_certificates_by_update_date(@WebParam(name = "page") int page, @WebParam(name = "utc_from") String utc_from, @WebParam(name = "utc_to") String utc_to
    ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf);
        if ((cert.findECertificateEntitiesByDate(page, utc_from, utc_to, this.getUserCountry()).length <= 0)) {
            String[] result = new String[]{"Query has no results"}; 
            return result;
        } 
        System.out.println("Country"+this.getUserCountry());
        return cert.findECertificateEntitiesByDate(page, utc_from, utc_to, this.getUserCountry());
    }

    @WebMethod(operationName = "find_export_certificates_details_by_update_date")
    public List find_export_certificates_details_by_update_date(@WebParam(name = "page") int page, @WebParam(name = "utc_from") String utc_from, @WebParam(name = "utc_to") String utc_to
    ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf);
        String arr[] = cert.findECertificateEntitiesByDate(page, utc_from, utc_to, this.getUserCountry());
        String string = "";
        if (arr[arr.length - 1].startsWith("END")) {
            arr[arr.length - 1] = null;
            for (int i = 0; i < arr.length - 1; i++) {
                string = (new StringBuilder()).append(string).append(arr[i]).append(",").toString();
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                string = (new StringBuilder()).append(string).append(arr[i]).append(",").toString();
            }
        }

        return cert.getMultECertificateXml(string);
    }

    @WebMethod(operationName = "find_export_certificates_details_by_update_date_status")
    public List find_export_certificates_details_by_update_date_status(@WebParam(name = "page") int page, @WebParam(name = "utc_from") String utc_from, @WebParam(name = "utc_to") String utc_to, @WebParam(name = "status") String status) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf);
        //String arr[] = cert.findECertificateEntitiesByDate(page, utc_from, utc_to, this.getUserCountry());

        String arr[] = cert.findECertificateEntitiesByDateAndStatus(page, utc_from, utc_to, status, this.getUserCountry());
        String string = "";
        if (arr[arr.length - 1].startsWith("END")) {
            arr[arr.length - 1] = null;
            for (int i = 0; i < arr.length - 1; i++) {
                string = (new StringBuilder()).append(string).append(arr[i]).append(",").toString();
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                string = (new StringBuilder()).append(string).append(arr[i]).append(",").toString();
            }
        }

        return cert.getMultECertificateXml(string);
    }

    @WebMethod(operationName = "find_certificates_by_update_date_and_status")
    public String[] find_certificates_by_update_date_and_status(@WebParam(name = "page") int page, @WebParam(name = "utc_from") String utc_from, @WebParam(name = "utc_to") String utc_to, @WebParam(name = "status") String status
    ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf);

        if ((cert.findECertificateEntitiesByDate(page, utc_from, utc_to, this.getUserCountry()).length <= 0)) {
            String[] result = new String[]{"Query has no results"};
            return result;
        }
        return cert.findECertificateEntitiesByDateAndStatus(page, utc_from, utc_to, status, this.getUserCountry());
    }

    @WebMethod(operationName = "get_official_certificate_xml")
    public byte[] get_official_certificate_xml(@WebParam(name = "certNo") String certNo
    ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf);
        return cert.getECertificateXml(certNo);
    }

    @WebMethod(operationName = "get_signed_official_certificate_xml")
    public byte[] get_signed_official_certificate_xml(@WebParam(name = "certNo") String certNo
    ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf);
        return cert.getSignedECertificateXml(certNo);
    }

    @WebMethod(operationName = "get_multiple_official_certificate_xml")
    public List get_multiple_official_certificate_xml(@WebParam(name = "CertNo") String CertNo
    ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf);
        return cert.getMultECertificateXml(CertNo);
    }

    @WebMethod(operationName = "accept_certificate")
    public String accept_certificate(@WebParam(name = "certNo") String certNo, @WebParam(name = "reason") String reason
    ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf);
       // ECertificateDetailsJpaController certList = new ECertificateDetailsJpaController(emf);
        if (cert.UpdateECertificatesStatus(certNo, reason, 1)) {
            return "STATUS SET ACCEPTED";
        } else {
            return "STATUS NOT SET";
        }
    }

    @WebMethod(operationName = "reject_certificate")
    public String reject_certificate(@WebParam(name = "certNo") String certNo, @WebParam(name = "reason") String reason
    ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf);
        ECertificateDetailsJpaController certList = new ECertificateDetailsJpaController(emf);
        boolean result2 = certList.UpdateECertificatesStatus(certNo, reason, 3);
        boolean result = cert.UpdateECertificatesStatus(certNo, reason, 3);
        if (result && result2) {
            return "STATUS SET REJECTED";
        } else {
            return "STATUS NOT SET";
        }
    }

    @WebMethod(operationName = "request_replacement_certificate")
    public String request_replacement_certificate(@WebParam(name = "certNo") String certNo, @WebParam(name = "reason") String reason
    ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf); 
        if (cert.UpdateECertificatesStatus(certNo, reason, 2) ) {

            return "STATUS SET REQUEST_REPLACEMENT";
        } else {
            return "STATUS NOT SET";
        }
    }

    @WebMethod(operationName = "acknowledge_certificate")
    public String acknowledge_certificate(@WebParam(name = "certNo") String certNo, @WebParam(name = "reason") String reason
    ) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController cert = new ECertificateDetailsJpaController(emf);
        ECertificateDetailsJpaController certList = new ECertificateDetailsJpaController(emf);
        if (cert.UpdateECertificatesStatus(certNo, reason, STATUS_ACKNOWLEDGED) && certList.UpdateECertificatesStatus(certNo, reason, STATUS_ACKNOWLEDGED)) {

            return "STATUS SET ACKNOWLEDGED";
        } else {
            return "STATUS NOT SET";
        }
    }
}
