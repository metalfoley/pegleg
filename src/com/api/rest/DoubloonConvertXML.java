package com.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/doubloonconvert/xml")
public class DoubloonConvertXML {
 
	@Path("{doubloon}")
	@GET
	@Produces("application/xml")
	public String doubloonToDollarInput(@PathParam("doubloon") Double doubloon) {
		Double dollar;
		dollar = doubloon / 10;
 
		return "<doubloonToDollarservice>" + "<dollar>" + dollar + "</dollar>" + "<doubloonToDollarOutput>" + doubloon + "</doubloonToDollarOutput>" + "</doubloonToDollarservice>";
	}
}
