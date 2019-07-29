package org.kephis.cms;

 
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
 
 public class ECertCheckIp extends Thread
 {
 private static volatile boolean stop = false;
   static String message;
  static int counter = 0;
 
    public static void checkIpIsOnline(final String hostname, final int p, final String phoneno1, final String phoneno2, final int emailsms) throws Exception { int delay = 10;
      int period = 60000;
      Timer timer = new Timer();
       stop = false;

        timer.scheduleAtFixedRate(new TimerTask() {

       int count = 1;
       Socket s = null;
       private Toolkit toolkit;
       public void run() { while (!stop)
         {
           try {
           InetAddress ipaddress = InetAddress.getByName(hostname);
             try {
                this.s = new Socket(ipaddress, p);
               System.out.println("A server is running on port " + p + ".");
                this.s.close();
             } catch (Exception e) {
               ECertCheckIp.message = "The application " + hostname + " " + "on port " + p + " is down";
 
               ECertCheckIp.counter += 1;
                this.toolkit = Toolkit.getDefaultToolkit();
               this.toolkit.beep();
               try {
                  Thread.sleep(60000L);
               } catch (InterruptedException ex) {
                 Logger.getLogger(ECertCheckIp.class.getName()).log(Level.SEVERE, null, ex);
               }
             }
           } catch (UnknownHostException e) {
              System.out.println("Could not find host: " + hostname + " ");
           }
           if (this.s != null) {
             try {
               this.s.close();
             }
             catch (IOException ioEx)
             {
             }
           }
            System.out.println("doing " + this.count);
            this.count += 1;
         }
       }
     }
     , delay, period);
 
      if (counter > 15) {
       System.out.print("__ " + message);
/* 82 */       if (emailsms == 1) {
/* 83 */         notificationService.SMSClient(phoneno1, message);
/* 84 */         notificationService.SMSClient(phoneno2, message);
       }
 
/* 87 */       if (emailsms == 2) {
/* 88 */         notificationService.EmailClient(phoneno1, phoneno2, message);
       }
 
/* 91 */       System.out.println(message);
/* 92 */       counter = 0;
     }
   }
 
   public static void requestStop()
   {
    stop = true;
   }
 }
