package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import program.Pirate;

import com.api.rest.DoubloonConvert;
import com.api.rest.DoubloonConvertXML;
import com.api.rest.GetPirate;
import com.api.rest.GetPirates;

import dao.DaoPirate;

@RunWith(MockitoJUnitRunner.class)
public class WebServiceTest {
	

	DoubloonConvert convert;
	DoubloonConvertXML convertXML;
	GetPirate getPirate;
	GetPirates getPirates;
	Pirate pirate;
	Response response;
	ArrayList<Pirate> pirates;
	
	@Mock
	JSONException exc;
	@Mock
	JSONObject jsonObject;
	@Mock
	DaoPirate dp;
	
	@Before
	public void setUp() throws Exception {
		convert = new DoubloonConvert();
		convertXML = new DoubloonConvertXML();
		
		getPirate = new GetPirate();
		getPirate.setDaoPirate(dp);
		
		getPirates = new GetPirates();
		getPirates.setDaoPirate(dp);
		
		pirate = new Pirate();
		pirates = new ArrayList<Pirate>();
		
	}

	/*********************
	 * 
	 * Doubloon Convert
	 * 
	 ***********************/
	
	@Test
	@Category(PositiveTestsCategory.class)
	public void testDoubloonConvertPos() {
		response = convert.doubloonToDollarInput(50.00);
		assertEquals("{\"doubloon\":50,\"dollar\":5}", response.getEntity());
		assertEquals(200, response.getStatus());
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testDoubloonConvertNeg() {
		response = convert.doubloonToDollarInput(50.00);
		assertNotEquals(response.getEntity(), "{\"doubloon\":50,\"dollar\":5.00}");
		assertNotEquals(404, response.getStatus());	
	}
	
	@Test
	@Ignore
	public void testConvertFailWithException() throws JSONException{
		//Arrange
		convert.setJsonObject(jsonObject);
		when(exc.getMessage()).thenReturn("test error, will mock later");
		when(jsonObject.put(anyString(), anyDouble())).thenThrow(exc);
		
		//Act
		convert.doubloonToDollarInput(50.00);

		//Assert
		verify(exc).getMessage();
	}
	
	@Test
	@Category(PositiveTestsCategory.class)
	public void testDoubloonConvertXMLPos() {
		String xml = convertXML.doubloonToDollarInput(50.00);
		String returnStr ="<doubloonToDollarservice><dollar>5.0</dollar><doubloonToDollarOutput>50.0</doubloonToDollarOutput></doubloonToDollarservice>";
		assertEquals(xml, returnStr);
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testDoubloonConvertXMLNeg() {
		String xml = convertXML.doubloonToDollarInput(50.00);
		String returnStr ="<doubloonToDollarservice><dollar>5.00</dollar><doubloonToDollarOutput>50.00</doubloonToDollarOutput></doubloonToDollarservice>";
		assertNotEquals(xml, returnStr);
	}
	
	/*********************
	 * 
	 * Get Pirate
	 * 
	 ***********************/
	
	@Test
	@Category(PositiveTestsCategory.class)
	public void testGetPirateCreatePos() {
		when(dp.getPirate(1)).thenReturn(createPirate(pirate));
		response = getPirate.getPiratesResponse(1);
		assertEquals(response.getEntity(), "{\"firstName\":\"Bob\",\"lastName\":\"Smith\",\"id\":1,\"shipName\":\"Ship\",\"pirateName\":\"pName\"}");
		assertEquals(200, response.getStatus());
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testGetPirateCreateNeg() {
		when(dp.getPirate(1)).thenReturn(createPirate(pirate));
		response = getPirate.getPiratesResponse(1);
		assertNotEquals(response.getEntity(), "{\"firstName\":\"bob\",\"lastName\":\"smith\",\"id\":1,\"shipName\":\"ship\",\"pirateName\":\"pname\"}");
		assertNotEquals(404, response.getStatus());
	}
	
	/*********************
	 * 
	 * Get Pirates
	 * 
	 ***********************/
	
	@Test
	@Category(PositiveTestsCategory.class)
	public void testGetPiratesCreatePos() {
		pirates.add(createPirate(pirate));
		pirates.add(createPirate(pirate));
		when(dp.getAllPirates()).thenReturn(pirates);
		response = getPirates.getPiratesResponse();
		assertEquals("{\"pirates\":[{\"lastName\":\"Smith\",\"firstName\":\"Bob\",\"ID\":1,\"shipName\":\"Ship\",\"pirateName\":\"pName\"},{\"lastName\":\"Smith\",\"firstName\":\"Bob\",\"ID\":1,\"shipName\":\"Ship\",\"pirateName\":\"pName\"}]}",response.getEntity());
		assertEquals(2,pirates.size());
		assertEquals(200, response.getStatus());
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testGetPiratesCreateNeg() {
		when(dp.getPirate(1)).thenReturn(pirate);
		response = getPirates.getPiratesResponse();
		assertNotEquals(response.getEntity(), "{\"firstName\":\"bob\",\"lastName\":\"smith\",\"id\":1,\"shipName\":\"ship\",\"pirateName\":\"pname\"}");
		assertNotEquals(3,pirates.size());
		assertNotEquals(404, response.getStatus());
	}
	
	private Pirate createPirate(Pirate pirate) {
		pirate.setID(1);
		pirate.setFirstName("Bob");
		pirate.setLastName("Smith");
		pirate.setShipName("Ship");
		pirate.setPirateName("pName");
		return pirate;
	}
}
