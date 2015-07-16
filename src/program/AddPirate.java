package program;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import base.Filo;
import dao.DaoCurrency;

public class AddPirate {
	
	private JSONParser jsonParser;
	private DaoCurrency dc;
	private JSONObject jsonObject;
	
	public AddPirate() {
		setDc(new DaoCurrency());
		setJsonParser(new JSONParser());
		setJsonObject(new JSONObject());
	}
	
	public String getShip(String ships){
		Filo.log(ships);
		String ship = null;
		int doubloons = 0;
		try {
			jsonObject = (JSONObject) jsonParser.parse(ships);
			ship = (String) jsonObject.get("ship");
			doubloons = Integer.parseInt((String) jsonObject.get("doubloons"));
			getDc().updateDoubloons(doubloons);
		} catch (ParseException e) {
			Filo.log("pirateEdit doGet: " + e.getMessage());
		}
		return ship;
	}

	public JSONParser getJsonParser() {
		return jsonParser;
	}

	public void setJsonParser(JSONParser jsonParser) {
		this.jsonParser = jsonParser;
	}

	public DaoCurrency getDc() {
		return dc;
	}

	public void setDc(DaoCurrency dc) {
		this.dc = dc;
	}

	public JSONObject getJsonObject() {
		return jsonObject;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
}
