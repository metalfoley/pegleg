package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import program.Pirate;
import dao.DaoPirate;

public class PirateTest {
	private static Pirate pirate;
	private static Pirate pirate2;
	private static Pirate pirate3;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DaoPirate dp = new DaoPirate();
		pirate = dp.getPirate(4);
		pirate2 = dp.createPirate("a");
		pirate3 = new Pirate("a","b","c","d");
	}

	@Test
	@Category(PositiveTestsCategory.class)
	public void testGetPiratePos() {
		assertEquals(4, pirate.getID());
		assertEquals("Agnes", pirate.getFirstName());
		assertEquals("Stone", pirate.getLastName());
		assertEquals("The Speedy Revenge", pirate.getShipName());
		assertEquals("Haggis Queen", pirate.getPirateName());
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testGetPirateNeg() {
		assertNotEquals(5, pirate.getID());
		assertNotEquals("Agnesh", pirate.getFirstName());
		assertNotEquals("Stones", pirate.getLastName());
		assertNotEquals("The Sea Killer", pirate.getShipName());
		assertNotEquals("Haggs Queen", pirate.getPirateName());
	}

	@Test
	@Category(PositiveTestsCategory.class)
	public void testCreatePiratePos() {
		assertEquals(0, pirate2.getID());
		assertEquals("", pirate2.getFirstName());
		assertEquals("", pirate2.getLastName());
		assertEquals("a", pirate2.getShipName());
		assertEquals("", pirate2.getPirateName());
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testCreatePirateNeg() {
		assertNotEquals(5, pirate2.getID());
		assertNotEquals("jgfdfk", pirate2.getFirstName());
		assertNotEquals("dfgg", pirate2.getLastName());
		assertNotEquals("ggkk", pirate2.getShipName());
		assertNotEquals("kkhjhjk", pirate2.getPirateName());
	}
	
	@Test
	@Category(PositiveTestsCategory.class)
	public void testPirateConstructorPos() {
		assertEquals("a", pirate3.getFirstName());
		assertEquals("b", pirate3.getLastName());
		assertEquals("c", pirate3.getShipName());
		assertEquals("d", pirate3.getPirateName());
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testPirateConstructorNeg() {
		assertNotEquals("jgfdfk", pirate3.getFirstName());
		assertNotEquals("dfgg", pirate3.getLastName());
		assertNotEquals("ggkk", pirate3.getShipName());
		assertNotEquals("kkhjhjk", pirate3.getPirateName());
	}
	
}
