package com.redhat.gss.rs.client;


import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;

@WebServlet("/request-server")
public class ClientServlet extends HttpServlet {

	final String WS_URL = "http://localhost:8080/serverJaxRsEAP61/rest/test";	

	final String PAGE_HEADER = "<html><head><title>Simple REST Client</title></head><body>";
	final String PAGE_FOOTER = "</body></html>";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("== Received Request ==");
		StringBuffer r  = new StringBuffer();
		r.append(PAGE_HEADER);
		r.append("<h1>");
		r.append(makeRequest());
		r.append("</h1>");
		r.append(PAGE_FOOTER);
		PrintWriter writer = resp.getWriter();
		writer.println(r.toString());
		writer.close();
	}

	public String makeRequest() {
		try{
			ClientRequest request = new ClientRequest(WS_URL);
			ClientResponse<String> response = request.get(String.class);
			System.out.println("== Response received from Server ==");
			return response.getEntity();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error when performing the request. See server logs.";
		}		
	}
}
