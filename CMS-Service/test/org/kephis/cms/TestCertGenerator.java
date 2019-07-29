package org.kephis.cms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence; 
import org.kephis.cms.entities.controllers.EPhytoDetailsFileMapperController;

/**
 *
 * @author kim
 */
public class TestCertGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        EPhytoDetailsFileMapperController EPhytoDetailsController = new EPhytoDetailsFileMapperController();
  
          //  List<EPhytoDetails> EphytoList = EPhytoDetailsFileMapperController.getEPhytoDetails("KEPHIS/732086/2014");
        ////zSystem.err.println("Doc Name"+ephytoSPSCertificate.getSPSExchangedDocument().getID());
        System.err.println(" "  +EPhytoDetailsController.getEPhytoDetails("KEPHIS/732086/2014").size());
    
      /**
        try {
            // TODO code application logic here
            new FileXML2DBConverter();
            FileXML2DBConverter.createPhytoCert("/cms/kephis_cft_732087.xml");
        } catch (JAXBException ex) {
            Logger.getLogger(TestCertGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestCertGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TestCertGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    **/
    }}