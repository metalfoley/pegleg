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
	Pirate pirate2;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		pirates = DaoPirate.getAllPirates();
		pirate = DaoPirate.getPirate(4);
		pirate2 = DaoPirate.createPirate("a");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllPiratesPos() {
		assertEquals(DaoPirate.getCount(), pirates.size());
		
	}
	
	@Test
	public void testGetAllPiratesNeg() {
		assertNotEquals(DaoPirate.getCount() +1, pirates.size());
	}

	@Test
	public void testGetPiratePos() {
		assertEquals(4, pirate.getID());
		assertEquals("Agnes", pirate.getFirstName());
		assertEquals("Stone", pirate.getLastName());
		assertEquals("The Speedy Revenge", pirate.getShipName());
		assertEquals("Haggis Queen", pirate.getPirateName());
	}
	
	@Test
	public void testGetPirateNeg() {
		assertNotEquals(5, pirate.getID());
		assertNotEquals("Agnesh", pirate.getFirstName());
		assertNotEquals("Stones", pirate.getLastName());
		assertNotEquals("The Sea Killer", pirate.getShipName());
		assertNotEquals("Haggs Queen", pirate.getPirateName());
	}

	@Test
	public void testCreatePiratePos() {
		assertEquals(0, pirate2.getID());
		assertEquals("", pirate2.getFirstName());
		assertEquals("", pirate2.getLastName());
		assertEquals("a", pirate2.getShipName());
		assertEquals("", pirate2.getPirateName());
	}
	
	@Test
	public void testCreatePirateNeg() {
		assertNotEquals(5, pirate2.getID());
		assertNotEquals("jgfdfk", pirate2.getFirstName());
		assertNotEquals("dfgg", pirate2.getLastName());
		assertNotEquals("ggkk", pirate2.getShipName());
		assertNotEquals("kkhjhjk", pirate2.getPirateName());
	}
	

}
