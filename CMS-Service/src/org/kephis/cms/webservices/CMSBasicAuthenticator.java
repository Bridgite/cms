/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kephis.cms.webservices;

import com.sun.net.httpserver.BasicAuthenticator;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.kephis.cms.entities.ECertUsers;
import org.kephis.cms.entities.controllers.ECertUsersJpaController;
 
/**
 *
 * @author kim
 */
public class CMSBasicAuthenticator extends BasicAuthenticator {

    public CMSBasicAuthenticator(String realm) {
        super(realm);

    }

    @Override
    public boolean checkCredentials(String username, String password) {
        // Query database for users and return valid 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CERT_2_DB_R-W_AppPU");
        ECertUsersJpaController ecertUsersCon = new ECertUsersJpaController(emf);
        List<ECertUsers> UserList = ecertUsersCon.findECertUsersEntities();
        for (Iterator<ECertUsers> iterator = UserList.iterator(); iterator.hasNext();) {
            ECertUsers user = iterator.next();
            if (username.equals(user.getUsername()) && user.getPassword().equals(getHash(password,"MD5"))) {
                return true;
            }

        }

        return false;
    }
    public  static String getHash(String txt, String hashType) {
        try {
                    java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
                    byte[] array = md.digest(txt.getBytes());
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < array.length; ++i) {
                        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
                 }
                    return sb.toString();
            } catch (java.security.NoSuchAlgorithmException e) {
                //error action
            }
            return null;
    }
 
}
