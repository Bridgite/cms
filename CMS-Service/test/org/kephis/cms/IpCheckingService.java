package org.kephis.cms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import org.kephis.cms.notificationService;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bkimutai
 */
public class IpCheckingService extends Thread {

    private static volatile boolean stop = false;
    static String message;
     static int counter=0;
    public static void checkIpIsOnline(final String hostname, final int p, final String phoneno1, final String phoneno2, final int emailsms) throws Exception {
        int delay = 10; // delay for 5 sec.
        int period = 60000; // repeat every sec.
        Timer timer = new Timer();
        stop = false;
     
        

        timer.scheduleAtFixedRate(new TimerTask() {

            int count = 1;
            Socket s = null;
            private Toolkit toolkit;

            @Override
            public void run() {
                while (!stop) {

                    try {      // this is to see if host exists:
                        InetAddress ipaddress = InetAddress.getByName(hostname);
                        try {
                            s = new Socket(ipaddress, p);
                            System.out.println("A server is running on port " + p + ".");
                            s.close();
                        } catch (Exception e) {
                            message = "The application " + hostname + " " + "on port " + p + " is down";
                            //if 1 the sms the client only
                            counter++;
                            toolkit = Toolkit.getDefaultToolkit();
                            toolkit.beep();
                            try {
                                Thread.sleep(60000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(IpCheckingService.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    } catch (UnknownHostException e) {
                        System.out.println("Could not find host: " + hostname + " ");
                    }
                    if (s != null) {
                        try {
                            s.close();
                        } catch (IOException ioEx) {
                        }
                    }


                    System.out.println("doing " + count);
                    count++;
                }
            }
        }, delay, period);
 if (counter>15){
        System.out.print("__ " + message);
        if (emailsms == 1) {
            notificationService.SMSClient(phoneno1, message);
            notificationService.SMSClient(phoneno2, message);
        }
        //if 2 email the client only
        if (emailsms == 2) {
            notificationService.EmailClient(phoneno1, phoneno2, message);
        }

        System.out.println(message);
counter=0;

}

    }

    public static void requestStop() {
        stop = true;
    }
}