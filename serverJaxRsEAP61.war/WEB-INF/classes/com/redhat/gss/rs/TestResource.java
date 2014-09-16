package com.redhat.gss.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("test")
public class TestResource {

    @GET   
    public String test() {
	System.out.println("== Received a Request ==")    ;
	return "Test passed";
    }
    	
}
