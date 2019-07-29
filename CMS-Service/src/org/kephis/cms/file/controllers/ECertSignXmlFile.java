package org.kephis.cms.file.controllers;

import com.ascertia.adss.client.api.signing.SigningRequest;
import com.ascertia.adss.client.api.signing.SigningResponse;
import java.io.File;
import java.io.PrintStream;

public class ECertSignXmlFile {

    public String getSignedXmlFile(File sourceFile, String unsignedfilepath)
            throws Exception { 
        new ConfigMapper();
        String SignedFilepath = null;
        String filePath = sourceFile.getParent();
        File checkfile = null;
        boolean FileExist = false;
        String signedfilepath = "";
        try {
            signedfilepath = unsignedfilepath.replace("unsigned", "signed");
            checkfile = new File(signedfilepath); 
            FileExist = checkfile.exists();

        } catch (StringIndexOutOfBoundsException ex) {
            FileExist = false;
        } 
        if (!FileExist) {

            SigningRequest obj_signingRequest = new SigningRequest(ConfigMapper.getSigningClientOrgId(), sourceFile.getAbsolutePath().trim(), "XML");
            obj_signingRequest.setProfileId(ConfigMapper.getProfileId());
            obj_signingRequest.setCertificateAlias(ConfigMapper.getCertificateAlias());
            SigningResponse obj_signingResponse = (SigningResponse) obj_signingRequest.send(ConfigMapper.getSigningServerUrl().trim() + "/adss/signing/dsi");

            if (obj_signingResponse.isSuccessfull()) { 
                File destFolder = new File(signedfilepath.replace(checkfile.getName(), "")); 
                if (!destFolder.exists()) {
                    destFolder.mkdirs();
                }
                obj_signingResponse.publishDocument(destFolder.getAbsolutePath() + File.separator + unsignedfilepath.substring(25));

                SignedFilepath = destFolder.getAbsolutePath() + File.separator + unsignedfilepath.substring(25);
            } else {
                    System.out.println("SIGNINING ERROR :"+obj_signingResponse.getErrorMessage());
            }
             System.out.println("SIGNED FILE : "+SignedFilepath);
            return SignedFilepath;
        }

        return checkfile.getAbsolutePath();
    }
}
