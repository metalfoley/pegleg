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
	  private DaoCurrency dc;
	  private JSONObject jsonObject;
	  
	  public TotalCurrency(){
		  setDaoCurrency(new DaoCurrency());
		  setJsonObject(new JSONObject());
	  }
 
	  @GET
	  @Produces("application/json")
	  public Response getCurrencyResponse() throws JSONException {
		getJsonObject().put("currency", getDaoCurrency().getTotalCurrency()); 
		return Response.status(200).entity(getJsonObject().toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
	  }

	public DaoCurrency getDaoCurrency() {
		return dc;
	}

	public void setDaoCurrency(DaoCurrency dc) {
		this.dc = dc;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
}