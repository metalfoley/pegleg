package com.example.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/doubloonconvert/json")
public class DoubloonConvert {
 
	  @GET
	  @Produces("application/json")
	  public Response doubloonToDollar() throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		Double doubloon = 10.00;
		Double dollar;
		dollar = doubloon / 10; 
		jsonObject.put("doubloon Value", doubloon); 
		jsonObject.put("currency Value", dollar);
 
		String result = "@Produces(\"application/json\") Output: \n\nDoubloon to Dollar Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
 
	  @Path("{doubloon}")
	  @GET
	  @Produces("application/json")
	  public Response doubloonToDollarInput(@PathParam("doubloon") Double doubloon) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		Double dollar;
		dollar =  doubloon / 10; 
		jsonObject.put("doubloon Value", doubloon); 
		jsonObject.put("currency Value", dollar);
 
		String result = "@Produces(\"application/json\") Output: \n\nDoubloon to Dollar Converter: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
}