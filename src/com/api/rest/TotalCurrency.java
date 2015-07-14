package com.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import org.json.JSONException;
import org.json.JSONObject;


import dao.DaoCurrency;

 
@Path("/totalcurrency")
public class TotalCurrency {
 
	  @GET
	  @Produces("application/json")
	  public Response getPiratesResponse() throws JSONException {
		DaoCurrency dc = new DaoCurrency();
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("currency", dc.getTotalCurrency()); 
 
		return Response.status(200).entity(jsonObject.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
	  }
}