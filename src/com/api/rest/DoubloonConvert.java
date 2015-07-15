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
	  private JSONObject jsonObject;
	  
	  public DoubloonConvert() {
		  setJsonObject(new JSONObject());
	  }

	  @Path("{doubloon}")
	  @GET
	  @Produces("application/json")
	  public Response doubloonToDollarInput(@PathParam("doubloon") Double doubloon) throws JSONException {
		Double dollar;
		dollar =  doubloon / 10; 
		getJsonObject().put("doubloon", doubloon); 
		getJsonObject().put("dollar", dollar);
 
		return Response.status(200).entity(getJsonObject().toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
	  }

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
}