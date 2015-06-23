package com.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/doubloonconvert/json")
public class DoubloonConvert {
 
	  @Path("{doubloon}")
	  @GET
	  @Produces("application/json")
	  public Response doubloonToDollarInput(@PathParam("doubloon") Double doubloon) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		Double dollar;
		dollar =  doubloon / 10; 
		jsonObject.put("doubloon", doubloon); 
		jsonObject.put("dollar", dollar);
 
		return Response.status(200).entity(jsonObject.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
	  }
}