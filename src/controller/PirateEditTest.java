package controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import program.AddPirate;
import program.Pirate;
import dao.DaoCurrency;
import dao.DaoPirate;

@RunWith(MockitoJUnitRunner.class)
public class PirateEditTest {
	
	@Mock
	DaoPirate dp;
	@Mock
	DaoCurrency dc;
	@Mock
	AddPirate addPirate;
	@Mock
	JSONObject jsonObject;
	@Mock
	JSONParser jsonParser;
	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	@Mock
	RequestDispatcher dispatcher;
	
	Pirate pirate;
	pirateEdit edit;
	

	@Before
	public void setUp() throws Exception {
		pirate = new Pirate();
		edit = new pirateEdit();
		edit.setDp(dp);
		edit.setAddPirate(addPirate);
		edit.setDispatcher(dispatcher);
		when(request.getRequestDispatcher("/WEB-INF/edit.jsp")).thenReturn(dispatcher);
	}

	@Test
	public void testIfIdExists() throws ServletException, IOException {
		when(request.getParameter("id")).thenReturn("1");
		
		edit.doGet(request,response);
		
		Mockito.verify(dispatcher).forward(request, response);
		Mockito.verify(request).setAttribute("pirate",dp.getPirate(1));
	}
	
	@Test
	public void testIfIdNotExists() throws ServletException, IOException, ParseException {		
		when(request.getParameter("id")).thenReturn(null);
		when(request.getParameter("ships")).thenReturn("");
		
		edit.doGet(request,response);
		
		Mockito.verify(addPirate).getShip("");
		Mockito.verify(dispatcher).forward(request, response);
		Mockito.verify(addPirate).getShip(Mockito.anyString());
		Mockito.verify(request).setAttribute("disabled", "disabled");
		Mockito.verify(request).setAttribute("pirate", dp.createPirate(""));
	}
	
	@Test
	@Ignore
	public void testGetShip() throws ParseException {
		addPirate.setJsonObject(jsonObject);
		addPirate.setJsonParser(jsonParser);
		addPirate.setDc(dc);
		//String ships = "{\"ship\":\"The Sea Killer\",\"doubloons\":\"3456\"}";
		//when(jsonParser.parse(ships)).thenReturn(jsonObject);
		//when(jsonObject.get("ship")).thenReturn("");
		//when(Integer.parseInt((String) jsonObject.get("0"))).thenReturn(0);
		
		addPirate.getShip("a");
		
		Mockito.verify(dc).updateDoubloons(0);
		
	}

}
