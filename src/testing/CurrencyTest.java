package testing;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import dao.DaoCurrency;

public class CurrencyTest {
	private static double currency;
	private static int doubloon;
	private int updateDoubloon = 225;
	private ResultSet rs;
	private static DaoCurrency dc = new DaoCurrency();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		currency = dc.getTotalCurrency();
		doubloon = dc.getTotalDoubloons();
	}
	
	@AfterClass
	public static void teardownAfterClass() throws Exception {
		dc.updateCurrency(currency, doubloon);
	}
	
	@Before
	public void setUp() {
		rs = Mockito.mock(ResultSet.class);
		try {
			Mockito.when(rs.getDouble("Currency")).thenReturn(458.29);
			Mockito.when(rs.getInt("Doubloon")).thenReturn(132);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	@Category(PositiveTestsCategory.class)
	public void testTotalCurrencyPos() {
		assertEquals(458.29,currency,.01);
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testTotalCurrencyNeg() {
		assertNotEquals(458.28,currency,.01);
	}
	
	@Test
	@Category(PositiveTestsCategory.class)
	public void testTotalDoubloonPos() {
		assertEquals(132,doubloon);
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testTotalDoubloonNeg() {
		assertNotEquals(131,doubloon);
	}
	
	@Test
	@Ignore
	public void testUpdateCurrency() {
		dc.updateCurrency(15.25, updateDoubloon);
		assertEquals(15.25,dc.getTotalCurrency(),.01);
		//assertEquals(225,dc.getTotalDoubloons());
	}
	
	@Test
	@Ignore
	public void testUpdateDoubloons() {
		dc.updateDoubloons(50);
		//assertEquals(50 + updateDoubloon,dc.getTotalDoubloons());
	}

}
