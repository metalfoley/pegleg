package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import program.Pirate;
import dao.DaoPirate;

public class DaoPirateTest {
	ArrayList<Pirate> pirates;
	Pirate pirate;
	int total;
	HttpServletRequest request;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllPiratesPos() {
		pirates = DaoPirate.getAllPirates();
		assertEquals(DaoPirate.getCount(), pirates.size());
		
	}
	
	@Test
	public void testGetAllPiratesNeg() {
		pirates = DaoPirate.getAllPirates();
		assertNotEquals(DaoPirate.getCount() +1, pirates.size());
	}

	@Test
	public void testGetPiratePos() {
		pirate = DaoPirate.getPirate(4);
		assertEquals(4, pirate.getID());
		assertEquals("Agnes", pirate.getFirstName());
		assertEquals("Stone", pirate.getLastName());
		assertEquals("The Sea Killer", pirate.getShipName());
		assertEquals("Haggis Queen", pirate.getPirateName());
	}
	
	@Test
	public void testGetPirateNeg() {
		pirate = DaoPirate.getPirate(4);
		assertNotEquals(5, pirate.getID());
		assertNotEquals("Agnesh", pirate.getFirstName());
		assertNotEquals("Stones", pirate.getLastName());
		assertNotEquals("The Seas Killer", pirate.getShipName());
		assertNotEquals("Haggs Queen", pirate.getPirateName());
	}

	@Test
	public void testCreatePiratePos() {
		pirate = DaoPirate.createPirate("a");
		assertEquals(0, pirate.getID());
		assertEquals("", pirate.getFirstName());
		assertEquals("", pirate.getLastName());
		assertEquals("a", pirate.getShipName());
		assertEquals("", pirate.getPirateName());
	}
	
	@Test
	public void testCreatePirateNeg() {
		pirate = DaoPirate.createPirate("a");
		assertNotEquals(5, pirate.getID());
		assertNotEquals("jgfdfk", pirate.getFirstName());
		assertNotEquals("dfgg", pirate.getLastName());
		assertNotEquals("ggkk", pirate.getShipName());
		assertNotEquals("kkhjhjk", pirate.getPirateName());
	}
	

}
