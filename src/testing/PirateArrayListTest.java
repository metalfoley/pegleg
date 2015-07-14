package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import program.Pirate;
import dao.DaoHelper;
import dao.DaoPirate;

public class PirateArrayListTest {
	private static ArrayList<Pirate> pirates;
	private Pirate pirate;
	private static int count;
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		DaoHelper dh = new DaoHelper();
		DaoPirate dp = new DaoPirate();
		pirates = dp.getAllPirates();
		count = dh.getCount();
	}

	@Before
	public void setUp() throws Exception {
		pirate = new Pirate();
	}

	@Test
	@Category(PositiveTestsCategory.class)
	public void testGetAllPiratesPos() {
		assertEquals(count, pirates.size());
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testGetAllPiratesNeg() {
		assertNotEquals(count + 1, pirates.size());
	}
	
	@Test
	@Category(PositiveTestsCategory.class)
	public void testAddPirateToListPos() {
		pirates.add(pirate);
		assertEquals(count + 1, pirates.size());
		pirates.remove(pirate);
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testAddPirateToListNeg() {
		pirates.add(pirate);
		assertNotEquals(count, pirates.size());
		pirates.remove(pirate);
	}
	
	@Test
	@Category(PositiveTestsCategory.class)
	public void testRemovePirateToListPos() {
		pirates.remove(count - 1);
		assertEquals(count - 1, pirates.size());
		pirates.add(pirate);
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testRemovePirateToListNeg() {
		pirates.remove(count - 1);
		assertNotEquals(count, pirates.size());
		pirates.add(pirate);
	}
	
	@Test(expected= IndexOutOfBoundsException.class)
	@Category(PositiveTestsCategory.class)
	public void testGetNullPirateToList() {
		pirate = pirates.get(count + 1);
	}
	
	@Test(expected= IndexOutOfBoundsException.class)
	@Category(PositiveTestsCategory.class)
	public void testRemoveNullPirateToList() {
		pirate = pirates.remove(count + 1);
	}

}
