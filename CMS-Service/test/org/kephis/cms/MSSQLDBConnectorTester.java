/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kephis.cms.entities.controllers.EPhytoDetailsFileMapperController;
import static org.kephis.cms.entities.controllers.EPhytoDetailsFileMapperController.getMSSqlConnection;

/**
 *
 * @author bobby
 */
public class MSSQLDBConnectorTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            Connection conn2 = EPhytoDetailsFileMapperController.getMSSqlConnection();
            if (conn2 != null) {
    System.out.println("Connected");
}
            String CertificateNo="KEPHIS/2/76962/2017";
            String ePhytoProc = "{ call  GET_PHYTO_MAPPING(?) }";
            CallableStatement cs2 = conn2.prepareCall(ePhytoProc);
            
            cs2.setString(1, CertificateNo);
            cs2.execute();
            ResultSet rs = cs2.getResultSet();
           
            while (rs.next()) {
                String result = rs.getString(1);
                System.out.println(result);
            }

        } catch (Exception ex) {
            Logger.getLogger(MSSQLDBConnectorTester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
