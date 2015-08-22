package com.example.te;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class AppHttpClient {

	 public static String get(String uri) throws HttpException, IOException{
	        HttpClient client = new HttpClient();
	        GetMethod getMethod = new GetMethod(uri);
	        getMethod.setDoAuthentication( true );
	        int status = client.executeMethod(getMethod);
	        System.out.println(status+"\n"+getMethod.getResponseBodyAsString());
	        getMethod.releaseConnection();
			return status+" - "+getMethod.getResponseBodyAsString();
	    }
}
