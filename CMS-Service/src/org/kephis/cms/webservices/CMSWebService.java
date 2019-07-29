/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms.webservices;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;

import org.kephis.cms.entities.ECertUsers;
import org.kephis.cms.entities.controllers.ECertUsersJpaController;
import org.kephis.cms.file.controllers.ConfigMapper;
import org.kephis.cms.utilities.UtilityClass;

/**
 *
 * @author kim
 */
public class CMSWebService {

    private Endpoint endpoint = null;
    private Endpoint endpoint2 = null;
    private TimingThreadPool executor = new TimingThreadPool();

    private HttpsServer httpsserver = null;
    private HttpServer httpserver = null;
    private HttpContext context = null;
    private HttpContext context2 = null;
    CMSBasicAuthenticator authenticator = new CMSBasicAuthenticator("test");

    static String userCountry;
    private final ConfigMapper configMapper = new ConfigMapper();

    public CMSWebService() {

    }

    public String getUserCountry(String userName) {
        //System.err.println("User login in " + userName);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertUsersJpaController ecertUsersCon = new ECertUsersJpaController(emf);
        List<ECertUsers> UserList = ecertUsersCon.findECertUsersEntities();
        for (Iterator<ECertUsers> iterator = UserList.iterator(); iterator.hasNext();) {
            ECertUsers user = iterator.next();
            UtilityClass util = new UtilityClass();
            System.err.println("User login in " + user.getUsername() + "" + util.getCurrentTime());
            if (userName.equals(user.getUsername())) {
                return user.getCountrycode();

            }

        }

        return "";
    }

    public void server() throws IOException {

        try {
            //HttpServer.

            httpserver = HttpServer.create(new InetSocketAddress(new Integer(configMapper.getWebserviceHTTPPort())), 5);
            httpserver.setExecutor(executor);
            httpserver.start();
            context = httpserver.createContext("/KEPHIS-ECS-CMS-WS-SEC/KEPHIS_CMS_WS_SEC");
            context.setAuthenticator(authenticator);
            endpoint = Endpoint.create(new KEPHIS_CMS_WS_SEC_Impl());
            endpoint.publish(context);

            SSLContext ssl;

            KeyStore store;
            ssl = SSLContext.getInstance("SSLv3");
            endpoint2 = Endpoint.create(new KEPHIS_CMS_WS_SEC_Impl());
            store = KeyStore.getInstance(KeyStore.getDefaultType());
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            //Load the JKS file (located, in this case, at/cms/keystore.jks, with password 'k@phi$'
            //To use config file
            store.load(new FileInputStream("/cms/keystore.jks"), "password".toCharArray());
            //init the key store, along with the password 'test'
            kmf.init(store, "password".toCharArray());
            KeyManager[] keyManagers = new KeyManager[1];
            keyManagers = kmf.getKeyManagers();
            //Init the trust manager factory
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            //It will reference the same key store as the key managers
            tmf.init(store);
            TrustManager[] trustManagers = tmf.getTrustManagers();
            ssl.init(keyManagers, trustManagers, new SecureRandom());
            //Init a configuration with our SSL context
            HttpsConfigurator configurator = new HttpsConfigurator(ssl);
            //Create a httpsserver on localhost, port 443 (https port)
            httpsserver = HttpsServer.create(new InetSocketAddress(new Integer(configMapper.getWebserviceHTTPsPort())), new Integer(configMapper.getWebserviceHTTPPort()));
            httpsserver.setHttpsConfigurator(configurator);
            httpsserver.start();
            //Create a context so our service will be available under this context
            context2 = httpsserver.createContext("/KEPHIS-ECS-CMS-WS-SEC/KEPHIS_CMS_WS_SEC");

            //Finally, use the created context to publish the service
            context2.setAuthenticator(authenticator);

            endpoint2 = Endpoint.create(new KEPHIS_CMS_WS_SEC_Impl());
            endpoint2.publish(context2);

        } catch (NoSuchAlgorithmException ex) {
            System.err.println(ex);
        } catch (KeyStoreException ex) {
            System.err.println(ex);
        } catch (CertificateException ex) {
            System.err.println(ex);
        } catch (UnrecoverableKeyException ex) {
            System.err.println(ex);
        } catch (KeyManagementException ex) {
            System.err.println(ex);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public void publish() {
        //endpoint.setExecutor(executor);
        try {
            EnvelopeLoggingSOAPHandler handle = new EnvelopeLoggingSOAPHandler();
            Binding binding = endpoint.getBinding();
            List<Handler> handlerChain = new LinkedList<Handler>();
            handlerChain.add(handle);
            binding.setHandlerChain(handlerChain);
            endpoint.publish("https://localhost:" + new Integer(configMapper.getWebserviceHTTPPort()) + "/KEPHIS-ECS-CMS-WS-SEC/KEPHIS_CMS_WS_SEC");
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    private void stop() {
        endpoint.stop();
    }

    public void shutdown() {
        this.stop();
        httpsserver.stop(1);
    }
}
