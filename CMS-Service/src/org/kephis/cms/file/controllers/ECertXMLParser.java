package org.kephis.cms.file.controllers;

import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory; 
import org.kephis.cms.entities.ECertificateDetails;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ECertXMLParser extends DefaultHandler {

    private String tempVal;
    List tempCertIDField;
    List tempCertNameField;
    List tempContryDestField;
    List tempIssuerField;
    List tempPlaceOfIssueField;
    List tempDateOfIssueField;
    private ECertificateDetails tempECert;

    public ECertXMLParser() {
        this.tempCertIDField = new ArrayList();
        this.tempContryDestField = new ArrayList();
        this.tempDateOfIssueField = new ArrayList();
        this.tempIssuerField = new ArrayList();
        this.tempCertNameField = new ArrayList();
        this.tempPlaceOfIssueField = new ArrayList();
    }

    public void parseDocument(String Doc) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser sp = spf.newSAXParser();

            sp.parse(Doc, this);
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public ECertificateDetails getECertData()
            throws ParseException {

        String certNoParts = this.tempCertIDField.get(0).toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date tempDateOfIssue = dateFormat.parse(this.tempDateOfIssueField.get(0).toString());
        java.sql.Date sqlDate = new java.sql.Date(tempDateOfIssue.getTime());
        this.tempECert.setCertNo(certNoParts);
        this.tempECert.setCertType(this.tempCertNameField.get(0).toString());
        this.tempECert.setDestinationCountry(this.tempContryDestField.get(1).toString());
        this.tempECert.setPlaceOfIssue(this.tempPlaceOfIssueField.get(4).toString());
        this.tempECert.setIssuer(this.tempIssuerField.get(1).toString());
        this.tempECert.setDateOfIssue(sqlDate);
        return this.tempECert;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        this.tempVal = "";

        if (qName.startsWith("ram:SPSCertificate")) {
            this.tempECert = new ECertificateDetails();
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        this.tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (qName.equalsIgnoreCase("rsm:ID")) {
            this.tempCertIDField.add(this.tempVal);
            this.tempIssuerField.add(this.tempVal);
        } else if (qName.equalsIgnoreCase("rsm:Name")) {
            this.tempCertNameField.add(this.tempVal);
            this.tempPlaceOfIssueField.add(this.tempVal);
        } else if (qName.equalsIgnoreCase("rsm:CountryID")) {
            this.tempContryDestField.add(this.tempVal);
        } else if (qName.equalsIgnoreCase("rsm:IssueDateTime")) {
            this.tempDateOfIssueField.add(this.tempVal);
        }
    }
}
