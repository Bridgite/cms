package org.kephis.cms.file.controllers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

final public class ConfigMapper {

    private static String CMSRootFolder;
    private static String ePhytoTempFolder;
    private static String SigningClientOrgId;
    private static String ProfileId;
    private static boolean deleteFilesInTempFolder;
    private static String SigningServerUrl;
    private static String CertificateAlias;
    private static String StartProcessingDate;
    private static String webserviceHTTPPort;
    private static String webserviceHTTPsPort;
    private static String ecsPdfCertificateBaseUrl;

    public static String getWebserviceHTTPPort() {
        return webserviceHTTPPort;
    }

    public static void setWebserviceHTTPPort(String webserviceHTTPPort) {
        ConfigMapper.webserviceHTTPPort = webserviceHTTPPort;
    }

    public static String getWebserviceHTTPsPort() {
        return webserviceHTTPsPort;
    }

    public static void setWebserviceHTTPsPort(String webserviceHTTPsPort) {
        ConfigMapper.webserviceHTTPsPort = webserviceHTTPsPort;
    }

    public static String getEcsPdfCertificateBaseUrl() {
        return ecsPdfCertificateBaseUrl;
    }

    public static void setEcsPdfCertificateBaseUrl(String ecsPdfCertificateBaseUrl) {
        ConfigMapper.ecsPdfCertificateBaseUrl = ecsPdfCertificateBaseUrl;
    }

    public static boolean isDeleteFilesInTempFolder() {
        return deleteFilesInTempFolder;
    }

    public static void setDeleteFilesInTempFolder(boolean deleteFilesInTempFolder) {
        ConfigMapper.deleteFilesInTempFolder = deleteFilesInTempFolder;
    }

    public static String getSigningServerUrl() {
        return SigningServerUrl;
    }

    public static void setSigningServerUrl(String SigningServerUrl) {
        ConfigMapper.SigningServerUrl = SigningServerUrl;
    }

    public static String getStartProcessingDate() {
        return StartProcessingDate;
    }

    public static void setStartProcessingDate(String StartProcessingDate) {
        ConfigMapper.StartProcessingDate = StartProcessingDate;
    }

    public static String getCMSRootFolder() {
        return CMSRootFolder;
    }

    public static void setCMSRootFolder(String CMSRootFolder) {
        ConfigMapper.CMSRootFolder = CMSRootFolder;
    }

    public static String getePhytoTempFolder() {
        return ePhytoTempFolder;
    }

    public static void setePhytoTempFolder(String ePhytoTempFolder) {
        ConfigMapper.ePhytoTempFolder = ePhytoTempFolder;
    }

    public static String getSigningClientOrgId() {
        return SigningClientOrgId;
    }

    public static void setSigningClientOrgId(String SigningClientOrgId) {
        ConfigMapper.SigningClientOrgId = SigningClientOrgId;
    }

    public static String getProfileId() {
        return ProfileId;
    }

    public static void setProfileId(String ProfileId) {
        ConfigMapper.ProfileId = ProfileId;
    }

    public static String getCertificateAlias() {
        return CertificateAlias;
    }

    public static void setCertificateAlias(String CertificateAlias) {
        ConfigMapper.CertificateAlias = CertificateAlias;
    }

    public ConfigMapper() {
        try {
            File fXmlFile = new File("/cms/app_config.xml");
            //System.out.println("Config file path "+fXmlFile.getAbsolutePath()); 
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("CMS_Config");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    setCMSRootFolder(eElement.getElementsByTagName("CMSRootFolder").item(0).getTextContent());
                    setePhytoTempFolder(eElement.getElementsByTagName("ePhytoTempFolder").item(0).getTextContent());
                    setSigningClientOrgId(eElement.getElementsByTagName("SigningClientOrgId").item(0).getTextContent());
                    setProfileId(eElement.getElementsByTagName("ProfileId").item(0).getTextContent());
                    setCertificateAlias(eElement.getElementsByTagName("CertificateAlias").item(0).getTextContent());
                    setStartProcessingDate(eElement.getElementsByTagName("StartProcessingDate").item(0).getTextContent());
                    setSigningServerUrl(eElement.getElementsByTagName("SigningServerUrl").item(0).getTextContent());
                    setDeleteFilesInTempFolder(eElement.getElementsByTagName("deleteFilesInTempFolder").item(0).getTextContent().contentEquals("true"));
                    setEcsPdfCertificateBaseUrl(eElement.getElementsByTagName("ecsPdfCertificateBaseUrl").item(0).getTextContent());
                    setWebserviceHTTPPort(eElement.getElementsByTagName("webserviceHTTPPort").item(0).getTextContent());
                    setWebserviceHTTPsPort(eElement.getElementsByTagName("webserviceHTTPsPort").item(0).getTextContent());
                }
            }
        } catch (ParserConfigurationException ex) {
            System.err.println(ex);
        } catch (SAXException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
          System.err.println(ex);
        }
        catch (Exception ex) {
          System.err.println(ex);
        }
    }

}
