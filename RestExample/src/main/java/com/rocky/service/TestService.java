package com.rocky.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rocky.vo.Account;

@Path("/accountservice/")
public interface TestService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/accounts/{id}/")
	public Account getAccount(@PathParam("id") String id);
}
