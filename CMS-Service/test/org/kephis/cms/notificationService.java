package org.kephis.cms;

/*     */
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.text.DateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.mail.Message;
/*     */ import javax.mail.Message.RecipientType;
/*     */ import javax.mail.MessagingException;
/*     */ import javax.mail.Session;
/*     */ import javax.mail.Transport;
/*     */ import javax.mail.internet.InternetAddress;
/*     */ import javax.mail.internet.MimeMessage;
/*     */ 
/*     */ public class notificationService
/*     */ {
/*  28 */   static Date dDate = new Date();
/*  29 */   static DateFormat dFormat = DateFormat.getDateInstance(0, Locale.US);
/*     */ 
/*     */   public static void EmailClient(String emailaddress, String ccemailadress, String message)
/*     */   {
/*  34 */     String to = ccemailadress;
/*  35 */     String from = emailaddress;
/*     */ 
/*  37 */     String host = "192.168.0.100";
/*     */ 
/*  40 */     Properties props = new Properties();
/*     */ 
/*  44 */     props.put("mail.smtp.host", host);
/*     */ 
/*  46 */     props.put("mail.debug", "true");
/*  47 */     Session session = Session.getInstance(props);
/*  48 */     System.out.println("Cannot send email as an error occurred." + host + " " + ccemailadress + " " + emailaddress + " " + message);
/*     */     try
/*     */     {
/*  51 */       Message msg = new MimeMessage(session);
/*     */ 
/*  54 */       msg.setFrom(new InternetAddress(from));
/*  55 */       InternetAddress[] address = { new InternetAddress(to) };
/*  56 */       msg.setRecipients(Message.RecipientType.TO, address);
/*  57 */       msg.setSubject("KEPHIS SERVER E-Mail Notification ");
/*  58 */       msg.setSentDate(new Date());
/*     */ 
/*  61 */       msg.setText(message);
/*     */ 
/*  64 */       Transport.send(msg);
/*     */     }
/*     */     catch (MessagingException mex)
/*     */     {
/*  68 */       Logger.getLogger(notificationService.class.getName()).log(Level.SEVERE, null, mex);
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String SMSClient(String RecipientPhoneNo, String Message)
/*     */   {
/*     */     try
/*     */     {
/* 138 */       String username = "complex";
/* 139 */       String password = "76ftY";
/*     */ 
/* 141 */       String requestUrl = "http://192.168.0.11:13004/cgi-bin/sendsms?username=" + username + "&password=" + password + "&to=" + RecipientPhoneNo + "&text=" + Message + " This service is provided by KEPHIS. To get licensed seed sellers send the seed seller ID to the phone No 0727530093 as [1000200], To get seeds to plant in your division send the crop and the division to the same phone No 0727530093 as [Maize@Kibwezi]. For any more details call us on the numbers 0723-786779.";
/*     */ 
/* 146 */       URL url = new URL(requestUrl);
/* 147 */       System.out.println(url.toString());
/* 148 */       HttpURLConnection uc = (HttpURLConnection)url.openConnection();
/* 149 */       System.out.println("TEST0" + uc.getResponseMessage());
/*     */ 
/* 160 */       uc.disconnect();
/* 161 */       return "Message sent";
/*     */     }
/*     */    catch (Exception ex) {
            System.out.println(ex.getMessage());
            return (ex.getMessage());

        }
/*     */   }
/*     */ }

/* Location:           C:\DATA\Projects and programs\deployed  apps\dist CERT_2_DB_R-W_App\CERT_2_DB_R-W_App.jar
 * Qualified Name:     org.kephis.notificationService
 * JD-Core Version:    0.6.0
 */