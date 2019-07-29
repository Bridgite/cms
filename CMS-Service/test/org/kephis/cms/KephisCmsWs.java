package org.kephis.cms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kim
 */
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService

public class KephisCmsWs {

    private static final String SALUTATION = "Hello";
    @Resource
    WebServiceContext wsctx;

    public String getGreeting(String name) {
        MessageContext mctx = wsctx.getMessageContext();

		// Use the request headers to get the details
		Map http_headers =
			(Map) mctx.get(
			MessageContext.HTTP_REQUEST_HEADERS);
		List<String> userList = (List) http_headers.get("Username");
		List<String> passList = (List) http_headers.get("Password");

		String username = "";
		String password = "";

		if (userList != null) {
			username = userList.get(0);
		}

		if (passList != null) {
			password = passList.get(0);

		}

		if (username.equals("Manisha")
			&&
			password.equals("password")) {
			return "Hello "
				+ username +
				" to world of Jax WS - Valid User!";
		} else {
			return " User No Valid!";
		}



    }
}
