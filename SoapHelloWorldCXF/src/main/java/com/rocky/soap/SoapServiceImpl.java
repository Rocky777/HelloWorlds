package com.rocky.soap;

import javax.jws.WebService;

@WebService(endpointInterface="com.rocky.soap.SoapService")
public class SoapServiceImpl implements SoapService{

	public String hello() {
		return "Namaste";
	}

}
