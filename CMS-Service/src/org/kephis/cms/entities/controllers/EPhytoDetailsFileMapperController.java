/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms.entities.controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kephis.cms.entities.EPhytoDetails;

/**
 *
 * @author kim
 */
public class EPhytoDetailsFileMapperController {

    public static List<EPhytoDetails> getEPhytoDetails(String CertificateNo) {
        List<EPhytoDetails> ephyto = new ArrayList<EPhytoDetails>() {
        };
        try {
            Connection conn2 = getMSSqlConnection();
            String ePhytoProc = "{ call GET_PHYTO_MAPPING(?) }";
            CallableStatement cs2 = conn2.prepareCall(ePhytoProc);
            cs2.setString(1, CertificateNo);
            cs2.execute();
            ResultSet rs = cs2.getResultSet();
           
            while (rs.next()) {
                EPhytoDetails ephytodetails = new EPhytoDetails();
                ephytodetails.setId(rs.getString("ID"));
                ephytodetails.setDocumentNr(rs.getString("DOCUMENT_NR"));
                ephytodetails.setReceipientSpsPartyCode(rs.getString("RECEIPIENT_SPS_PARTY_CODE"));
                ephytodetails.setReceipientSpsPartyName(rs.getString("RECEIPIENT_SPS_PARTY_NAME"));
                ephytodetails.setProviderSpsPartyLocationId(rs.getString("PROVIDER_SPS_PARTY_OFFICE_LOC_ID"));
                ephytodetails.setProviderSpsPartyLocationName(rs.getString("PROVIDER_SPS_PARTY_OFFICE_LOC_NAME"));
                ephytodetails.setInvoicenr(rs.getString("Invoice_nr"));
                ephytodetails.setFirmName(rs.getString("FIRM_NAME"));
                ephytodetails.setClientCntCode(rs.getString("CLIENT_CNT_CODE"));
                ephytodetails.setClientCountry(rs.getString("CLIENT_COUNTRY"));
                ephytodetails.setClientCity(rs.getString("CLIENT_CITY"));
                ephytodetails.setClientPostNo(rs.getString("CLIENT_POST_NUMBER"));
                ephytodetails.setConsigneePostalCode(rs.getString("CONSIGNEE_POSTAL_CODE"));
                ephytodetails.setConsigneeCountryIso(rs.getString("CONSIGNEE_COUNTRY_ISO"));
                ephytodetails.setConsigneeCountry(rs.getString("CONSIGNEE_COUNTRY"));
                ephytodetails.setConsigneeTown(rs.getString("CONSIGNEE_CITY"));
                ephytodetails.setPoe(rs.getString("POE"));
                ephytodetails.setInspectionCityCode(rs.getString("INSPECTION_CITY_CODE"));
                ephytodetails.setInspectionCity(rs.getString("INSPECTION_CITY"));
                ephytodetails.setConsignmentUnitId(rs.getInt("CONSIGNMENT_UNIT_ID"));
                ephytodetails.setConsignmentUnitCode(rs.getString("UNIT_CODE"));
                ephytodetails.setConsignmentUnitName(rs.getString("UNIT_NAME"));
                ephytodetails.setCommodityForm(rs.getString("COMMODITY_FORM"));
                ephytodetails.setPackaging(rs.getString("PACKAGING"));
                ephytodetails.setPackageCode(rs.getString("PACKAGE_CODE"));
                ephytodetails.setPackageName(rs.getString("PACKAGE_NAME"));
                ephytodetails.setLineItempackageNo(rs.getString("VAQ_NUMBER_OF_PACKAGES"));
                ephytodetails.setLineItempackageWeight(rs.getString("VAQ_PACKAGES_WEIGHT"));
                ephytodetails.setPhysShippingMarks(rs.getString("PHY_SHIPPING_MARKS"));
                ephytodetails.setCommonName(rs.getString("COMMON_NAME"));
                ephytodetails.setAdditionalinfo(rs.getString("ADDITIONAL_INFO"));
                ephytodetails.setEpptClassCode(rs.getString("EPPT_CODE"));
                ephytodetails.setEpptClassName(rs.getString("EPPT_NAME"));
                ephytodetails.setBotanicalName(rs.getString("BOTANICAL_NAME"));
                ephytodetails.setQuantityPassed((int) Double.parseDouble(rs.getString("QUANTITY_PASSED")));
                ephytodetails.setClassCode(rs.getString("CLASS_CODE"));
                ephytodetails.setClassName(rs.getString("CLASS_NAME"));
                ephytodetails.setTransCode(rs.getInt("TRANS_CODE"));
                ephytodetails.setTransMode(rs.getString("TRANS_MODE"));
                ephyto.add(ephytodetails);
            }
            
            Connection conn = getMySqlConnection();
            String simpleProc = "{ call GET_PHYTO_MAPPING(?) }";
            CallableStatement cs = conn.prepareCall(simpleProc);
            cs.setString(1, CertificateNo);
            cs.execute();
            ResultSet rs1 = cs.getResultSet();

            
            while (rs1.next()) {
                EPhytoDetails ephytodetails = new EPhytoDetails();
                ephytodetails.setId(rs1.getString("ID"));
                ephytodetails.setDocumentNr(rs1.getString("DOCUMENT_NR"));
                ephytodetails.setReceipientSpsPartyCode(rs1.getString("RECEIPIENT_SPS_PARTY_CODE"));
                ephytodetails.setReceipientSpsPartyName(rs1.getString("RECEIPIENT_SPS_PARTY_NAME"));
                ephytodetails.setProviderSpsPartyLocationId(rs1.getString("PROVIDER_SPS_PARTY_OFFICE_LOC_ID"));
                ephytodetails.setProviderSpsPartyLocationName(rs1.getString("PROVIDER_SPS_PARTY_OFFICE_LOC_NAME"));
                ephytodetails.setInvoicenr(rs1.getString("Invoice_nr"));
                ephytodetails.setFirmName(rs1.getString("FIRM_NAME"));
                ephytodetails.setClientCntCode(rs1.getString("CLIENT_CNT_CODE"));
                ephytodetails.setClientCountry(rs1.getString("CLIENT_COUNTRY"));
                ephytodetails.setClientCity(rs1.getString("CLIENT_CITY"));
                ephytodetails.setClientPostNo(rs1.getString("CLIENT_POST_NUMBER"));
                ephytodetails.setConsigneePostalCode(rs1.getString("CONSIGNEE_POSTAL_CODE"));
                ephytodetails.setConsigneeCountryIso(rs1.getString("CONSIGNEE_COUNTRY_ISO"));
                ephytodetails.setConsigneeCountry(rs1.getString("CONSIGNEE_COUNTRY"));
                ephytodetails.setConsigneeTown(rs1.getString("CONSIGNEE_CITY"));
                ephytodetails.setPoe(rs1.getString("POE"));
                ephytodetails.setInspectionCityCode(rs1.getString("INSPECTION_CITY_CODE"));
                ephytodetails.setInspectionCity(rs1.getString("INSPECTION_CITY"));
                ephytodetails.setConsignmentUnitId(rs1.getInt("CONSIGNMENT_UNIT_ID"));
                ephytodetails.setConsignmentUnitCode(rs1.getString("UNIT_CODE"));
                ephytodetails.setConsignmentUnitName(rs1.getString("UNIT_NAME"));
                ephytodetails.setCommodityForm(rs1.getString("COMMODITY_FORM"));
                ephytodetails.setPackaging(rs1.getString("PACKAGING"));
                ephytodetails.setPackageCode(rs1.getString("PACKAGE_CODE"));
                ephytodetails.setPackageName(rs1.getString("PACKAGE_NAME"));
                ephytodetails.setLineItempackageNo(rs1.getString("VAQ_NUMBER_OF_PACKAGES"));
                ephytodetails.setLineItempackageWeight(rs1.getString("VAQ_PACKAGES_WEIGHT"));
                ephytodetails.setPhysShippingMarks(rs1.getString("PHY_SHIPPING_MARKS"));
                ephytodetails.setCommonName(rs1.getString("COMMON_NAME"));
                ephytodetails.setAdditionalinfo(rs1.getString("ADDITIONAL_INFO"));
                ephytodetails.setEpptClassCode(rs1.getString("EPPT_CODE"));
                ephytodetails.setEpptClassName(rs1.getString("EPPT_NAME"));
                ephytodetails.setBotanicalName(rs1.getString("BOTANICAL_NAME"));
                ephytodetails.setQuantityPassed((int) Double.parseDouble(rs1.getString("QUANTITY_PASSED")));
                ephytodetails.setClassCode(rs1.getString("CLASS_CODE"));
                ephytodetails.setClassName(rs1.getString("CLASS_NAME"));
                ephytodetails.setTransCode(rs1.getInt("TRANS_CODE"));
                ephytodetails.setTransMode(rs1.getString("TRANS_MODE"));
                ephyto.add(ephytodetails);
            }
            conn.close();

        } catch (Exception ex) {
            System.err.println("" + ex);
            Logger.getLogger(EPhytoDetailsFileMapperController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ephyto;
    }

    public boolean getPhytoIsPresent(String CertificateNo) {
        boolean isExisting = false;

        return isExisting;
    }

    private static Connection getMySqlConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        //       // System.out.println("Driver Loaded.");
        //System.out.println("Driver Loaded.");
        String url = "jdbc:mysql://192.168.0.32:3306/ecert_cms_db?zeroDateTimeBehavior=convertToNull";
        //String url = "jdbc:mysql://localhost:3306/ecert_cms_db?zeroDateTimeBehavior=convertToNull";
        return DriverManager.getConnection(url, "ecsapps", "ecsapps");
        //return DriverManager.getConnection(url, "root", "root");

    }

    public static Connection getMSSqlConnection() throws Exception {

                     
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        System.out.println("Driver Loaded.");
        //System.out.println("Driver Loaded.");
        String url ="jdbc:sqlserver://192.168.0.29\\SQL2014;";
    
        return DriverManager.getConnection(url, "ecs_cms", "ecs_cms");

    }
}
