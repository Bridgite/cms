package org.kephis.cms.file.controllers;

import org.kephis.cms.entities.controllers.EPhytoDetailsFileMapperController;
import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import org.kephis.cms.entities.ECertificateDetails;
import org.kephis.cms.entities.ECertificateHistory;
import org.kephis.cms.entities.EPhytoDetails;
import org.kephis.cms.entities.controllers.ECertificateDetailsJpaController;
import org.kephis.cms.entities.controllers.ECertificateHistoryJpaController;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.AdditionalInformationSPSNote;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.ApplicableSPSClassification;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.GrossWeightMeasure;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.IncludedSPSConsignmentItem;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.IncludedSPSTradeLineItem;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.ItemQuantity;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.NetWeightMeasure;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.NominalGrossWeightMeasure;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.OriginSPSCountry;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.PhysicalSPSPackage;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.PhysicalSPSShippingMarks;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.SPSCertificate;
import org.kephis.cms.xmlschema.SPSCertificate_8p0.SPSConsignment;
import org.kephis.cms.utilities.UtilityClass;
import org.xml.sax.InputSource;

public class FileXML2DBConverter {

    private static boolean stop = false;
    public static int count[] = new int[]{0, 0, 0}; 
    private static ConfigMapper configMapper= new ConfigMapper();

    /**
     *
     * @param date
     * @param Country
     * @return
     */
    public static NamespacePrefixMapper val = new NamespacePrefixMapper() {

        private static final String XSI_URI = "http://www.w3.org/2001/XMLSchema-instance";

        @Override
        public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
            if (XSI_URI.equals(namespaceUri)) {
                return "xsi";
            }
            return suggestion;
        }

        @Override
        public String[] getPreDeclaredNamespaceUris() {
            return new String[]{XSI_URI};
        }
    };

    public static String createPhytoCert(String currentCertFile) throws JAXBException, FileNotFoundException, UnsupportedEncodingException {
        JAXBContext context = null;
        context = JAXBContext.newInstance(SPSCertificate.class);
        Unmarshaller um = null;
        um = context.createUnmarshaller();

        ECertFileReader xmlFile = new ECertFileReader(currentCertFile);

        Reader reader = new InputStreamReader(new ByteArrayInputStream(xmlFile.getFileContents(currentCertFile).trim().getBytes()));
        InputSource is = new InputSource(reader);
        is.setEncoding("UTF-8");
        SPSCertificate ephytoSPSCertificate = (SPSCertificate) um.unmarshal(is);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        EPhytoDetailsFileMapperController EPhytoDetailsController = new EPhytoDetailsFileMapperController();
        List<EPhytoDetails> EphytoList = EPhytoDetailsController.getEPhytoDetails(ephytoSPSCertificate.getSPSExchangedDocument().getID());
        

        String LineItemsId = "";
        int i = 0;
        //List of trade line items
        List<IncludedSPSTradeLineItem> includedSPSTradeLineItems = new CopyOnWriteArrayList<>();
        List<IncludedSPSConsignmentItem> includedSPSConsignmentItemList = new CopyOnWriteArrayList<>();

        for (Iterator<EPhytoDetails> iterator = EphytoList.iterator(); iterator.hasNext();) {

            EPhytoDetails ephytodetails = iterator.next();
            //System.err.println("DOC NO" + ephytodetails.getDocumentNr());
            if (LineItemsId != ephytodetails.getId()) {
                LineItemsId = ephytodetails.getId();
                if (i == 0) {

                    if ("N/A".equals(ephytodetails.getReceipientSpsPartyCode().trim())) {
                        ephytoSPSCertificate.getSPSExchangedDocument().getRecipientSPSParty().setID("");
                        ephytoSPSCertificate.getSPSExchangedDocument().getRecipientSPSParty().setName("");
                    } else {
                        ephytoSPSCertificate.getSPSExchangedDocument().getRecipientSPSParty().setID(ephytodetails.getReceipientSpsPartyCode());
                        ephytoSPSCertificate.getSPSExchangedDocument().getRecipientSPSParty().setName(ephytodetails.getReceipientSpsPartyName());
                    }
                    ephytoSPSCertificate.getSPSExchangedDocument().getSignatorySPSAuthentication().getIssueSPSLocation().setID(ephytodetails.getInspectionCityCode());
                    ephytoSPSCertificate.getSPSExchangedDocument().getSignatorySPSAuthentication().getIssueSPSLocation().setName(ephytodetails.getInspectionCity());
                    // mapping for kephis offices
                    ephytoSPSCertificate.getSPSExchangedDocument().getSignatorySPSAuthentication().getProviderSPSParty().setID(ephytodetails.getProviderSpsPartyLocationId());
                    ephytoSPSCertificate.getSPSExchangedDocument().getSignatorySPSAuthentication().getProviderSPSParty().setName(ephytodetails.getProviderSpsPartyLocationName());
                    // mapping for kephis client
                    String ConsignorAddressLine1 = ephytoSPSCertificate.getSPSConsignment().getConsignorSPSParty().getSpecifiedSPSAddress().getLineOne() + "";//ephytodetails.getConsigneePostalCode();
                    ConsignorAddressLine1 = ConsignorAddressLine1.replaceAll("P.0 Box ", "P.0 Box " + ephytodetails.getClientPostNo() + ",");
                    ephytoSPSCertificate.getSPSConsignment().getConsignorSPSParty().getSpecifiedSPSAddress().setLineOne(ConsignorAddressLine1);
                    ephytoSPSCertificate.getSPSConsignment().getConsignorSPSParty().getSpecifiedSPSAddress().setLineTwo(ephytodetails.getClientCountry());
                    ephytoSPSCertificate.getSPSConsignment().getConsignorSPSParty().getSpecifiedSPSAddress().setCountryName(ephytodetails.getClientCountry());
                    ephytoSPSCertificate.getSPSConsignment().getConsignorSPSParty().getSpecifiedSPSAddress().setCityID(ephytodetails.getClientCntCode());
                    //
                    ephytoSPSCertificate.getSPSConsignment().getConsigneeSPSParty().getSpecifiedSPSAddress().setPostcodeCode(ephytodetails.getConsigneePostalCode());
                    String ConsigneeAddressLine1 = ephytoSPSCertificate.getSPSConsignment().getConsigneeSPSParty().getSpecifiedSPSAddress().getLineTwo() + "";//ephytodetails.getConsigneePostalCode();
                    String ConsigneeAddressLine2 = ephytoSPSCertificate.getSPSConsignment().getConsigneeSPSParty().getSpecifiedSPSAddress().getLineTwo() + "," + ephytodetails.getConsigneePostalCode();//ephytodetails.getConsigneePostalCode();

                    ephytoSPSCertificate.getSPSConsignment().getConsigneeSPSParty().getSpecifiedSPSAddress().setLineOne(ConsigneeAddressLine1);
                    ephytoSPSCertificate.getSPSConsignment().getConsigneeSPSParty().getSpecifiedSPSAddress().setLineTwo(ConsigneeAddressLine2);
                    ephytoSPSCertificate.getSPSConsignment().getConsigneeSPSParty().getSpecifiedSPSAddress().setCityID(ephytodetails.getConsigneeTown());
                    ephytoSPSCertificate.getSPSConsignment().getConsigneeSPSParty().getSpecifiedSPSAddress().setCountryID(ephytodetails.getConsigneeCountryIso().trim().toUpperCase());
                    ephytoSPSCertificate.getSPSConsignment().getConsigneeSPSParty().getSpecifiedSPSAddress().setCountryName(ephytodetails.getConsigneeCountry());

                    ephytoSPSCertificate.getSPSConsignment().getUnloadingBaseportSPSLocation().setID(ephytodetails.getPoe());

                    ephytoSPSCertificate.getSPSConsignment().getMainCarriageSPSTransportMovement().setModeCode(BigInteger.valueOf(ephytodetails.getTransCode()));
                    ephytoSPSCertificate.getSPSConsignment().getMainCarriageSPSTransportMovement().getUsedSPSTransportMeans().setName(ephytodetails.getTransMode());
                }
                // 
                //if variaty quantity is the same  use simple product  one tradeline item

                //if two vq  check includedspsconsignment item and add and if product 
                // the same use tradelineitem
                //if product diffrent use Consignment item
                //System.err.println(ephytodetails.getCommonName()+" LineItemsId " + LineItemsId + " i " + i);
                IncludedSPSTradeLineItem includedSPSTradeLineItem = new IncludedSPSTradeLineItem();
                includedSPSTradeLineItem.setSequenceNumeric(BigInteger.ONE);
                includedSPSTradeLineItem.setDescription(ephytodetails.getCommonName());
                includedSPSTradeLineItem.setCommonName(ephytodetails.getCommonName());
                includedSPSTradeLineItem.setScientificName(ephytodetails.getBotanicalName());
                if (ephytodetails.getConsignmentUnitId() == 3) {
                     NetWeightMeasure nw = new NetWeightMeasure();
                    nw.setUnitCode("KGM");
                    nw.setValue(BigInteger.valueOf(0));
                    includedSPSTradeLineItem.setNetWeightMeasure(nw);
                    GrossWeightMeasure grossweightmeasure = new GrossWeightMeasure();
                    grossweightmeasure.setUnitCode(ephytodetails.getConsignmentUnitCode());
                    grossweightmeasure.setValue(BigInteger.valueOf(ephytodetails.getQuantityPassed()));
                    includedSPSTradeLineItem.setGrossWeightMeasure(grossweightmeasure);
                   
                } else {
                    NetWeightMeasure nw = new NetWeightMeasure();
                    nw.setUnitCode(ephytodetails.getConsignmentUnitCode());
                    nw.setValue(BigInteger.valueOf(ephytodetails.getQuantityPassed()));
                    includedSPSTradeLineItem.setNetWeightMeasure(nw);
                    GrossWeightMeasure grossweightmeasure = new GrossWeightMeasure();
                    grossweightmeasure.setUnitCode(ephytodetails.getConsignmentUnitCode());
                    grossweightmeasure.setValue(BigInteger.valueOf(ephytodetails.getQuantityPassed()));
                    includedSPSTradeLineItem.setGrossWeightMeasure(grossweightmeasure);

                }
                AdditionalInformationSPSNote additionalInformationSPSNote = new AdditionalInformationSPSNote();

                if (ephytodetails.getAdditionalinfo() != null) {
                    additionalInformationSPSNote.setSubject("Additional Declaration");
                    additionalInformationSPSNote.setSubjectCode("");
                    additionalInformationSPSNote.setContent(ephytodetails.getAdditionalinfo());

                } else {
                    additionalInformationSPSNote.setSubject("");
                    additionalInformationSPSNote.setSubjectCode("");
                    additionalInformationSPSNote.setContent("");

                }
                includedSPSTradeLineItem.setAdditionalInformationSPSNote(additionalInformationSPSNote);
                //unique conditions apply for netherlands 
                //show only if rosa spps and for netherlands else hide 
                ApplicableSPSClassification applicableSPSClassification1 = new ApplicableSPSClassification();
                ApplicableSPSClassification applicableSPSClassification2 = new ApplicableSPSClassification();
                //*** show always **/
                ApplicableSPSClassification applicableSPSClassification3 = new ApplicableSPSClassification();
                //HSCODE Classification added
                ApplicableSPSClassification applicableSPSClassification4 = new ApplicableSPSClassification();
                //for all consignees in netherlands

//HSCODE CLASSIFICATION ADD ONLY TO ROSES  FOR NL
                // ADD TO ALL CLSSSIFICATION FOR OTHER COUNTRIES
                if (ephytodetails.getConsigneeCountryIso() == "NL") {
                    if (ephytodetails.getCommonName().matches("Rose")) {
                        if (ephytodetails.getEpptClassCode() != null && ephytodetails.getEpptClassName() != null) {
                            applicableSPSClassification1.setSystemID("EPPT");
                            applicableSPSClassification1.setSystemName("EPPO Plant Protection Thesaurus");
                            applicableSPSClassification1.setClassCode(ephytodetails.getEpptClassCode());
                            applicableSPSClassification1.setClassName(ephytodetails.getEpptClassName());
                            includedSPSTradeLineItem.getApplicableSPSClassification().add(applicableSPSClassification1);
                        }
                        if (ephytodetails.getClassCode() != null && ephytodetails.getClassName() != null) {
                            applicableSPSClassification2.setSystemID("ePhyto");
                            applicableSPSClassification2.setSystemName("IPPC commodity class");
                            applicableSPSClassification2.setClassCode(ephytodetails.getClassCode());
                            applicableSPSClassification2.setClassName(ephytodetails.getClassName());
                            includedSPSTradeLineItem.getApplicableSPSClassification().add(applicableSPSClassification2);
                        }

                    } else {
                        //hide no adding
                    }
                } else {
                    //add to all countries other than netherlands these two fields
                    if (ephytodetails.getEpptClassCode() != null && ephytodetails.getEpptClassName() != null) {
                        applicableSPSClassification1.setSystemID("EPPT");
                        applicableSPSClassification1.setSystemName("EPPO Plant Protection Thesaurus");
                        applicableSPSClassification1.setClassCode(ephytodetails.getEpptClassCode());
                        applicableSPSClassification1.setClassName(ephytodetails.getEpptClassName());
                        includedSPSTradeLineItem.getApplicableSPSClassification().add(applicableSPSClassification1);
                    }
                    if (ephytodetails.getClassCode() != null && ephytodetails.getClassName() != null) {
                        applicableSPSClassification2.setSystemID("ePhyto");
                        applicableSPSClassification2.setSystemName("IPPC commodity class");
                        applicableSPSClassification2.setClassCode(ephytodetails.getClassCode());
                        applicableSPSClassification2.setClassName(ephytodetails.getClassName());
                        includedSPSTradeLineItem.getApplicableSPSClassification().add(applicableSPSClassification2);
                    }

                }
                if (ephytodetails.getCommonName().matches("Rose")) {
                    applicableSPSClassification4.setSystemID("WCO");
                    applicableSPSClassification4.setSystemName("Harmonised System (HS-4)");
                    applicableSPSClassification4.setClassCode("0603");
                    applicableSPSClassification4.setClassName("Cut flowers and flower buds of a kind suitable for bouquets or for ornamental purposes, fresh, dried, dyed, bleached, impregnated or otherwise prepared");
                    includedSPSTradeLineItem.getApplicableSPSClassification().add(applicableSPSClassification4);
//HSCODE 
                } else {
                    applicableSPSClassification4.setSystemID("WCO");
                    applicableSPSClassification4.setSystemName("Harmonised System (HS-4)");
                    applicableSPSClassification4.setClassCode(" ");
                    applicableSPSClassification4.setClassName(" ");
                    includedSPSTradeLineItem.getApplicableSPSClassification().add(applicableSPSClassification4);

                }

                if (ephytodetails.getConsigneeCountryIso() != null && ephytodetails.getConsigneeCountry() != null) {
                    applicableSPSClassification3.setSystemID("ePhyto");
                    applicableSPSClassification3.setSystemName("Country of destination");
                    applicableSPSClassification3.setClassCode(ephytodetails.getConsigneeCountryIso());
                    applicableSPSClassification3.setClassName(ephytodetails.getConsigneeCountry());
                    includedSPSTradeLineItem.getApplicableSPSClassification().add(applicableSPSClassification3);
                }
                if ((applicableSPSClassification1.getSystemID() == null ? ("EPPT") != null : !applicableSPSClassification1.getSystemID().equals("EPPT"))
                        && (applicableSPSClassification2.getSystemID() == null ? ("ePhyto") != null : !applicableSPSClassification2.getSystemID().equals("ePhyto"))
                        && (applicableSPSClassification3.getSystemID() == null ? ("ePhyto") != null : !applicableSPSClassification3.getSystemID().equals("ePhyto"))) {
                    applicableSPSClassification1.setSystemID("");
                    applicableSPSClassification1.setSystemName("");
                    applicableSPSClassification1.setClassCode("");
                    applicableSPSClassification1.setClassName("");
                    includedSPSTradeLineItem.getApplicableSPSClassification().add(applicableSPSClassification1);
                }

                PhysicalSPSPackage physicalSPSPackage = new PhysicalSPSPackage();
                physicalSPSPackage.setLevelCode(BigInteger.valueOf(4));
                if (ephytodetails.getPackageCode() != null) {
                    physicalSPSPackage.setTypeCode(ephytodetails.getPackageCode());
                } else {
                    physicalSPSPackage.setTypeCode("1A");
                }
                ItemQuantity itemQuantity = new ItemQuantity();
                itemQuantity.setUnitCode(ephytodetails.getConsignmentUnitCode());
                itemQuantity.setValue(BigInteger.valueOf(Integer.valueOf(ephytodetails.getLineItempackageNo())));
                physicalSPSPackage.setItemQuantity(itemQuantity);
                NominalGrossWeightMeasure nominalGrossWeightMeasure = new NominalGrossWeightMeasure();
                nominalGrossWeightMeasure.setValue(BigInteger.valueOf(0));//To update
                nominalGrossWeightMeasure.setUnitCode("KGM");// To update
                physicalSPSPackage.setNominalGrossWeightMeasure(nominalGrossWeightMeasure);
                PhysicalSPSShippingMarks physicalSPSShippingMarks = new PhysicalSPSShippingMarks();
                physicalSPSShippingMarks.setMarking(ephytodetails.getPhysShippingMarks());
                physicalSPSPackage.setPhysicalSPSShippingMarks(physicalSPSShippingMarks);
                includedSPSTradeLineItem.setPhysicalSPSPackage(physicalSPSPackage);
                OriginSPSCountry originSPScountry= new OriginSPSCountry();
                originSPScountry.setID("KE");
                originSPScountry.setName("Kenya");
                includedSPSTradeLineItem.setOriginSPSCountry(originSPScountry);
                int tradeItemCounter = 0;
                // add on condition previous not the same as current otherwise sum
                if (includedSPSTradeLineItems.size() == 0) {
                    //System.err.println("TRADE ITEM 1"+tradeItemCounter);
                    includedSPSTradeLineItems.add(includedSPSTradeLineItem);
                    // includedSPSConsignmentItem.setIncludedSPSTradeLineItem(includedSPSTradeLineItem);
                    //  includedSPSConsignmentItems.add(includedSPSConsignmentItem);
                    tradeItemCounter++;
                } else {

                    for (Iterator<IncludedSPSTradeLineItem> iterator1 = includedSPSTradeLineItems.iterator(); iterator1.hasNext();) {
                        IncludedSPSTradeLineItem TradeLineItem = iterator1.next();
                        //Loop through all consignemnts to check same consignment item level types by botanical name         
                        if (TradeLineItem.getScientificName().contains(includedSPSTradeLineItem.getScientificName())) {
                            //tradeline item repeated with same scientific name we ignored package type
                            // further elaboration for package type may be needed
                            if (ephytodetails.getConsignmentUnitId() == 3) {
                                GrossWeightMeasure grossweightmeasure = new GrossWeightMeasure();
                                grossweightmeasure.setUnitCode(ephytodetails.getConsignmentUnitCode());
                                grossweightmeasure.setValue(TradeLineItem.getGrossWeightMeasure().getValue().add(includedSPSTradeLineItem.getGrossWeightMeasure().getValue()));
                                includedSPSTradeLineItem.setGrossWeightMeasure(grossweightmeasure);
                                NetWeightMeasure nw = new NetWeightMeasure();
                                nw.setUnitCode("KGM");
                                nw.setValue(BigInteger.valueOf(0));
                                includedSPSTradeLineItem.setNetWeightMeasure(nw);

                            } else {
                                NetWeightMeasure nw = new NetWeightMeasure();
                                nw.setUnitCode(ephytodetails.getConsignmentUnitCode());
                                nw.setValue(TradeLineItem.getNetWeightMeasure().getValue().add(includedSPSTradeLineItem.getNetWeightMeasure().getValue()));
                                includedSPSTradeLineItem.setNetWeightMeasure(nw);
                                GrossWeightMeasure grossweightmeasure = new GrossWeightMeasure();
                                if (ephytodetails.getConsignmentUnitCode() == null) {
                                    grossweightmeasure.setUnitCode("KGM");
                                } else {
                                    grossweightmeasure.setUnitCode(ephytodetails.getConsignmentUnitCode());
                                }
                                grossweightmeasure.setValue(TradeLineItem.getGrossWeightMeasure().getValue().add(includedSPSTradeLineItem.getGrossWeightMeasure().getValue()));
                                includedSPSTradeLineItem.setGrossWeightMeasure(grossweightmeasure);
                            }
                            includedSPSTradeLineItems.remove(tradeItemCounter);
                            includedSPSTradeLineItems.add(includedSPSTradeLineItem);
                        } else {
                            includedSPSTradeLineItems.add(includedSPSTradeLineItem);
                            tradeItemCounter++;
                        }

                    }
                    //  System.out.println("FINAL TRADE LINE ITEMS" + includedSPSTradeLineItems.size());
                }

                if (EphytoList.size() > 0 && EphytoList.size() <= i) {
                    i = i + 1;
                }
            }

//increment
        }
        //List of trade line items 
        UtilityClass util = new UtilityClass();
        UtilityClass.removeDuplicate(includedSPSTradeLineItems);
        int SPSConsignmentItemListCounter = 0;
        for (Iterator<IncludedSPSTradeLineItem> iterator = includedSPSTradeLineItems.iterator(); iterator.hasNext();) {
            IncludedSPSTradeLineItem next = iterator.next();
            IncludedSPSConsignmentItem includedSPSConsignmentItem = new IncludedSPSConsignmentItem();
            includedSPSConsignmentItem.setIncludedSPSTradeLineItem(next);
            includedSPSConsignmentItemList.add(SPSConsignmentItemListCounter, includedSPSConsignmentItem);
            //System.err.println("CONSIGNMENT ITEM LIST ITEM" + SPSConsignmentItemListCounter + "COMMON NAME" + next.getCommonName());
        }
        //System.err.println("CONSIGNMENT ITEM LIST" + includedSPSConsignmentItemList.size());

        //System.err.println(includedSPSConsignmentItemList.size() + " " + includedSPSConsignmentItemList.get(1).getIncludedSPSTradeLineItem().getGrossWeightMeasure().getValue());
        ephytoSPSCertificate.getSPSConsignment().setIncludedSPSConsignmentItem(includedSPSConsignmentItemList);
        //sPSConsignment.setConsigneeSPSParty(ephytoSPSCertificate.getSPSConsignment().getConsigneeSPSParty());
        //sPSConsignment.setConsignorSPSParty(ephytoSPSCertificate.getSPSConsignment().getConsignorSPSParty());
        //sPSConsignment.setExaminationSPSEvent(ephytoSPSCertificate.getSPSConsignment().getExaminationSPSEvent());
        //sPSConsignment.setExportSPSCountry(ephytoSPSCertificate.getSPSConsignment().getExportSPSCountry());
        //sPSConsignment.setImportSPSCountry(ephytoSPSCertificate.getSPSConsignment().getImportSPSCountry());
        //sPSConsignment.setMainCarriageSPSTransportMovement(ephytoSPSCertificate.getSPSConsignment().getMainCarriageSPSTransportMovement());
        //sPSConsignment.setUnloadingBaseportSPSLocation(ephytoSPSCertificate.getSPSConsignment().getUnloadingBaseportSPSLocation());
        // sPSConsignment.setIncludedSPSConsignmentItem(includedSPSConsignmentItemList);
        //ephytoSPSCertificate.setSPSConsignment(sPSConsignment);

        Marshaller ms = context.createMarshaller();

        ms.setProperty(Marshaller.JAXB_ENCODING,
                "UTF-8");
        ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        ms.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);

        /**
         * NamespacePrefixMapper mapper = new NamespacePrefixMapper() {
         *
         * @Override public String getPreferredPrefix(String namespaceUri,
         * String suggestion, boolean requirePrefix) { if
         * ("urn:un:unece:uncefact:data:standard:SPSCertificate:8".equals(namespaceUri)
         * && !requirePrefix) return "rsm"; return "rsm";
         *
         * }
         * };
         *
         */
        ms.setProperty(
                "com.sun.xml.internal.bind.namespacePrefixMapper",
                new NamespacePrefixMapper() {
            @Override
            public String getPreferredPrefix(String arg0, String arg1,
                    boolean arg2
            ) {
                return "rsm";
            }
        }
        );

        ms.setProperty(Marshaller.JAXB_SCHEMA_LOCATION,
                "urn:un:unece:uncefact:data:standard:SPSCertificate:8 SPSCertificate_8p0.xsd");

        ms.setProperty(
                "com.sun.xml.internal.bind.namespacePrefixMapper", val);
        try {
            ms.setProperty("com.sun.xml.internal.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        } catch (PropertyException pex) {
            ms.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        }

        ms.marshal(
                new JAXBElement<SPSCertificate>(new QName("urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12", "SPSCertificate"),
                        SPSCertificate.class, ephytoSPSCertificate), new File("/cms/tmp/convertedePhyto.xml"));

        if (new File(
                "/cms/tmp/convertedePhyto.xml").exists()) {
            //update file details 
            // System.err.println("file exists " + new File("/cms/tmp/convertedePhyto.xml").exists());
            replaceInFile("/cms/tmp/convertedePhyto.xml");
            return new File("/cms/tmp/convertedePhyto.xml").getAbsolutePath();
        }

        return "";
    }

    public static void replaceInFile(String filepath) {
        try {

            File file = new File(filepath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "", oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "";
            }
            reader.close();
            // String newtext = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!--KEPHIS TEST E-PHYTO XML-VERSION 8--><rsm:SPSCertificate xsi:schemaLocation=\"urn:un:unece:uncefact:data:standard:SPSCertificate:8 SPSCertificate_8p0.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:ram=\"urn:un:unece:uncefact:data:standard:ReusableAggregateBusinessInformationEntity:12\" xmlns:rsm=\"urn:un:unece:uncefact:data:standard:SPSCertificate:8\">"
            //        + oldtext.substring(368).trim();

            oldtext = oldtext.replaceAll("rsm:SPSCertificate", "ram:SPSCertificate");
            FileWriter writer = new FileWriter(filepath);
            writer.write(oldtext);
            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static List<File> prepareProcessPhyoByDate(String date, File ECSFolder) {
       
        List<File> files = new ArrayList<>();
        int year = Integer.parseInt(date.substring(0, 4));
        File yearFolder = new File(configMapper.getCMSRootFolder() + File.separator + year + File.separator);
        ECertFileReader yearfilter;
        yearfilter = new ECertFileReader();
        count[0] = yearfilter.getFilesNoInRange(ECSFolder, year + "-12" + "-31");
        //System.out.println("YEAR FILES" + count[0]);
        if (count[0] > 0) {

            if (!yearFolder.exists()) {
                yearFolder.mkdir();
            }
            File monthFolder = new File(configMapper.getCMSRootFolder() + File.separator + year + File.separator + date.substring(5, 7) + File.separator);
            ECertFileReader monthfilter;
            monthfilter = new ECertFileReader();
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, Integer.parseInt(date.substring(5, 7)));
            int numDays = calendar.getActualMaximum(Calendar.DATE);
            count[1] = monthfilter.getFilesNoInRange(ECSFolder, year + "-" + date.substring(5, 7) + "-" + numDays);

            if (count[1] > 0) {
                if (!monthFolder.exists()) {
                    monthFolder.mkdir();
                }
                File dayFolder = new File(configMapper.getCMSRootFolder() + File.separator + year + File.separator + date.substring(5, 7) + File.separator + date.substring(8, 10) + File.separator + "unsigned" + File.separator);
                ECertFileReader dayfilter;
                dayfilter = new ECertFileReader(date, date, "");
                count[2] = 0;
                dayfilter.getFilesNoInRange(ECSFolder, date);
                count[2] = ECSFolder.listFiles(dayfilter).length;
                if (count[2] > 0) {
                    if (!dayFolder.exists()) {
                        dayFolder.mkdirs();
                    }
                    File file[] = ECSFolder.listFiles(dayfilter);
              
                    for (int i = 0; i < file.length; i++) {
                        File dayphytoFile = new File(configMapper.getCMSRootFolder() + File.separator + year + File.separator + date.substring(5, 7) + File.separator + date.substring(8, 10) + File.separator + "unsigned" + File.separator + file[i].getName());
                        try {
                            if (copyFolder(file[i], dayphytoFile)) {
                                files.add(dayphytoFile);
                                //To do check delete config
                                file[i].delete();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(FileXML2DBConverter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    // }

                }
            }

        }

        return files;
    }

    // copy based on date 
    public static boolean copyFolder(File src, File dest)
            throws IOException {
       
        if (src.isDirectory()) {
            if (!dest.exists()) {
                dest.mkdir();
            } 
            String[] files = src.list();
            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                if (!destFile.exists()) {
                    copyFolder(srcFile, destFile);
                }
            }

        } else {
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            // src.delete();
            return true;
        }

        return false;
    }

    // gets the  file
    //sign and save file in signed certificates folder and database
    public static boolean processsPhyto(File File) {
        // System.out.println("File" + File.getAbsolutePath());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertificateDetailsJpaController ecertCntrl = new ECertificateDetailsJpaController(emf);
        ECertificateDetails eCERT = new ECertificateDetails();
        ECertificateDetails eCERT3 = new ECertificateDetails();
        ECertSignXmlFile signEphyto = new ECertSignXmlFile(); 
        try {
            String EcertFile = File.getName();
            String EcertFileName = File.getAbsolutePath(); 
            eCERT3 = ecertCntrl.findECertificateDetails(EcertFile.replace(".xml", ""));
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            ParsePosition pp = new ParsePosition(0);
            Date d = sdf.parse(sdf.format(cal.getTime()), pp);
            if (eCERT3 == null) {
                //mashler to convert xml file and return templory file path
                final String currentPhyto = createPhytoCert(EcertFileName);
                final File newEphyto = new File(currentPhyto);
                ECertXMLParser ECert = new ECertXMLParser();
                ECert.parseDocument(currentPhyto);
                ECertificateDetails eCERT2 = ECert.getECertData();
                ECertFileReader xmlFile = new ECertFileReader(currentPhyto);
                eCERT = new ECertificateDetails();
                eCERT.setCertFile(EcertFile.replace(".xml", ""));
                eCERT.setCertStatus("APPROVED");
                eCERT.setCertNo(eCERT2.getCertNo());
                eCERT.setCertType(eCERT2.getCertType());
                eCERT.setDestinationCountry(eCERT2.getDestinationCountry().trim());
                eCERT.setIssuer(eCERT2.getIssuer());
                eCERT.setDateOfIssue(eCERT2.getDateOfIssue());
                eCERT.setPlaceOfIssue(eCERT2.getPlaceOfIssue());
                eCERT.setStatusDate(d);   
                FileOutputStream stream = new FileOutputStream(File);
                try {
                    stream.write(xmlFile.getFileContents(currentPhyto).trim().getBytes());
                } finally {
                    stream.close();
                }
                eCERT.setXmlCertFilePath(EcertFileName); 
                String SignedFilepath=signEphyto.getSignedXmlFile(newEphyto, EcertFileName);
                eCERT.setSignedXmlCertFilePath(SignedFilepath);
                eCERT.setPdfCertFilePath(getPDFPhytoPath(EcertFile));
                //TO SET CONFIG NOT TO SIGN
                ecertCntrl.create(eCERT);
                ECertificateHistory eCertificateHistory;
                eCertificateHistory = new ECertificateHistory();
                eCertificateHistory.setCertStatus("APPROVED");
                eCertificateHistory.setReason("INITIAL STATUS");
                eCertificateHistory.setEcertDetailsId(eCERT);
                eCertificateHistory.setStatusDate(d);
                ecertCntrl.create(eCertificateHistory);
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
           System.err.print(ex);
           return false;
        }

    }

    

    private static String getPDFPhytoPath(String EcertFileName) {
        
        return  configMapper.getEcsPdfCertificateBaseUrl() + EcertFileName.replaceAll("xml", "pdf");
    }
     
}  