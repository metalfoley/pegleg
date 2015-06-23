package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/doubloonconvert/xml")
public class DoubloonConvertXML {
	@GET
	@Produces("application/xml")
	public String doubloonToDollar() {
 
		Double doubloon = 10.00;
		Double dollar;
		dollar = doubloon / 10;
 
		String result = "@Produces(\"application/xml\") Output: \n\nDoubloon to Dollar Converter Output: \n\n" + doubloon;
		return "<doubloonToDollarservice>" + "<dollar>" + dollar + "</dollar>" + "<doubloonToDollarOutput>" + result + "</doubloonToDollarOutput>" + "</doubloonToDollarservice>";
	}
 
	@Path("{doubloon}")
	@GET
	@Produces("application/xml")
	public String doubloonToDollarInput(@PathParam("doubloon") Double doubloon) {
		Double dollar;
		dollar = doubloon / 10;
 
		String result = "@Produces(\"application/xml\") Output: \n\nDoubloon to Dollar Converter Output: \n\n" + doubloon;
		return "<doubloonToDollarservice>" + "<dollar>" + dollar + "</dollar>" + "<doubloonToDollarOutput>" + result + "</doubloonToDollarOutput>" + "</doubloonToDollarservice>";
	}
}
