package org.kephis.cms;



  import com.ascertia.adss.client.api.signing.SigningRequest;
  import com.ascertia.adss.client.api.signing.SigningResponse;
  import java.io.PrintStream;
  
  public class signXmlFile
  {
    public static void main(String[] args)
      throws Exception
    {
/* 23 */     String[] param = new String[3];
/* 24 */     param[0] = "/home/kim/ecs_xml_v1_phyto_certs/kephis_cft_744230.xml";
/* 25 */     param[1] = "/home/kim/ecs_xml_v1_phyto_certs/signed_kephis_cft_744230.xml";
/* 26 */     param[2] = "http://192.168.0.9:8777";
  
/* 28 */     signfile(param);
    }
  
    public static void signfile(String[] args)
      throws Exception
    {
/* 37 */     if (args.length < 3) {
/* 38 */       System.out.println("Insufficient Command Line parameters");
/* 39 */       System.out.println("Usage: ");
/* 40 */       System.out.println("args[0] - Input File name");
/* 41 */       System.out.println("args[1] - Output  File name");
/* 42 */       System.out.println("args[2] - ADSS Server Address like http://192.168.0.9:8777");
/* 43 */       System.exit(0);
      }
  
/* 65 */     SigningRequest obj_signingRequest = new SigningRequest("SIGNINGCLIENT", args[0].trim(), "XML");
/* 66 */     obj_signingRequest.setProfileId("adss:signing:profile:010");
/* 67 */     obj_signingRequest.setCertificateAlias("KEPHISCMSCert2015");
  
/* 69 */     obj_signingRequest.writeTo("C:\\ECERTSYS\\CERT_2_DB_R-W_App\\SignXML-request.xml");
  
/* 71 */     System.out.println("\n/**********************************************************************/");
/* 72 */     System.out.println("\nA request has been sent to sign the XML document. Waiting for response...");
  
/* 75 */     SigningResponse obj_signingResponse = (SigningResponse)obj_signingRequest.send(args[2].trim() + "/adss/signing/dsi");
  
/* 77 */     obj_signingResponse.writeTo("C:\\ECERTSYS\\CERT_2_DB_R-W_App\\SignXML-response.xml");
  
/* 81 */     if (obj_signingResponse.isSuccessfull()) {
/* 82 */       obj_signingResponse.publishDocument(args[1].trim());
/* 83 */       System.out.println("\nRequest has been processed successfully.");
      }
      else {
/* 86 */       System.out.println(obj_signingResponse.getErrorMessage());
      }
/* 88 */     System.out.println("\n/**********************************************************************/");
    }
  }

/* Location:           C:\DATA\Projects and programs\deployed  apps\dist CERT_2_DB_R-W_App\CERT_2_DB_R-W_App.jar
 * Qualified Name:     signXmlFile
 * JD-Core Version:    0.6.0
 */