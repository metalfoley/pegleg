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
	 
	@Path("/getpirate")
	public class GetPirate {
	 
		  @Path("{pirateID}")
		  @GET
		  @Produces("application/json")
		  public Response getPiratesResponse(@PathParam("pirateID") int pirateID) throws JSONException {
			JSONObject jsonObject = new JSONObject();
			Pirate pirate = DaoPirate.getPirate(pirateID);
			jsonObject.put("id", pirate.getID());
			jsonObject.put("firstName", pirate.getFirstName());
			jsonObject.put("lastName", pirate.getLastName());
			jsonObject.put("shipName", pirate.getShipName());
			jsonObject.put("pirateName", pirate.getPirateName());
	 
			return Response.status(200).entity(jsonObject.toString()).type(MediaType.APPLICATION_JSON_TYPE).build();
		  }
	}
