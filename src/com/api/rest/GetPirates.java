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
	  private DaoPirate dp;
	  
	  public GetPirates() {
		  setDaoPirate(new DaoPirate());
	  }
 
	  @GET
	  @Produces("application/json")
	  public Response getPiratesResponse() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("pirates", getDaoPirate().getAllPirates()); 
 
		return Response.status(200).entity(jsonObject.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
	  }

	public DaoPirate getDaoPirate() {
		return dp;
	}

	public void setDaoPirate(DaoPirate dp) {
		this.dp = dp;
	}
}