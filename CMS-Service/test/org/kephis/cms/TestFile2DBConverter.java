package org.kephis.cms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import org.kephis.cms.file.controllers.FileXML2DBConverter;

/**
 *
 * @author kim
 */
public class TestFile2DBConverter {
     public static void main(String[] args) {
        
            // TODO code application logic here
            new FileXML2DBConverter();
         try {
              FileXML2DBConverter.processsPhyto(new File("/cms/kephis_cft_097668.xml"));
           //  FileXML2DBConverter.createPhytoCert("/cms/ecs_mount/kephis_cft_731919.xml");
         } catch (Exception ex) {
             Logger.getLogger(TestFile2DBConverter.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
}
