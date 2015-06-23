package com.api.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import program.Pirate;
import dao.DaoPirate;
 
@Path("/getpirates")
public class GetPirates {
 
	  @GET
	  @Produces("application/json")
	  public Response doubloonToDollarInput() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		JSONArray ja = new JSONArray();
		DaoPirate dp = new DaoPirate();
		ja.put(dp.getAllPirates());
		jsonObject.put("Pirates", ja); 
 
		return Response.status(200).entity(jsonObject.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
	  }
}