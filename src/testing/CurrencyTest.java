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

import base.DBConn;
import dao.DaoCurrency;

public class CurrencyTest {
	private Integer expectedDoubloon;
	private Double expectedCurrency;
	private int updateDoubloon = 225;
	private DaoCurrency dc = new DaoCurrency();
	private ResultSet rs;
	
	@Before
	public void setUp() throws SQLException {
		expectedCurrency = 458.29;
		expectedDoubloon = 132;
		rs = Mockito.mock(ResultSet.class);
		DBConn db = Mockito.mock(DBConn.class);
	}

	@Test
	@Category(PositiveTestsCategory.class)
	public void testTotalCurrencyPos() {
		assertEquals(458.29,dc.getTotalCurrency(),.01);
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testTotalCurrencyNeg() {
		assertNotEquals(458.28,expectedCurrency,.01);
	}
	
	@Test
	@Category(PositiveTestsCategory.class)
	public void testTotalDoubloonPos() {
		assertEquals(new Integer(132) ,dc.getTotalDoubloons());
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testTotalDoubloonNeg() {
		assertNotEquals(new Integer(131),dc.getTotalDoubloons());
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
