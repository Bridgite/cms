package org.kephis.cms;




import javax.xml.ws.Endpoint;

public class RunService {

 /**
 * @param args
 */
    
 public static void main(String[] args) {
		
  System.out.println("SayHello Web Service started.");
  Endpoint.publish("http://localhost:8088/wsServerExample", new KephisCmsWs());

 }
}