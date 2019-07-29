package org.kephis.cms;

/**
package org.kephis.cms.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

public class SmbConnect {

    public static void main(String... args) {
        new SmbConnect().copyFiles();
    }

    public void copyFiles() {
        StringBuilder builder = null;
        try {
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(null, Constant.USER_NAME, Constant.PASSWORD); //This class stores and encrypts NTLM user credentials.

            SmbFile sFile = new SmbFile(Constant.FILE_SOURCE_PATH, auth); //This class represents a resource on an SMB network.

            try {
                builder = new StringBuilder();
                builder = readFileContent(sFile, builder);

                System.out.println("========================== display all .txt info  here ==============");
                System.out.println(builder.toString());
                System.out.println("========================== End  here ================================");

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private StringBuilder readFileContent(SmbFile sFile, StringBuilder builder) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new SmbFileInputStream(sFile)));
        } catch (SmbException ex) {
            System.out.println(ex);
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        }
        String lineReader = null;
        {
            try {
                while ((lineReader = reader.readLine()) != null) {
                    builder.append(lineReader).append("\n");
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        }
        return builder;
    }
}
**/