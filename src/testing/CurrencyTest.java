package testing;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import base.DBConn;
import dao.DaoCurrency;
import extract.ExtractCurrency;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyTest {
	
	DaoCurrency dc;
	
	@Mock
	DBConn db;
	@Mock
	ExtractCurrency.ExtractInteger extractInt;
	@Mock
	ExtractCurrency.ExtractDouble extractDouble;
	
	
	@Before
	public void setUp() throws SQLException {
		dc = new DaoCurrency(db);
		dc.setExtractInteger(extractInt);
		dc.setExtractDouble(extractDouble);
	}

	@Test
	@Category(PositiveTestsCategory.class)
	public void testTotalCurrencyPos() {
		when(db.query(anyString(), any(ExtractCurrency.ExtractDouble.class))).thenReturn(50.0);
		assertEquals(50.0,dc.getTotalCurrency(),.01);
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testTotalCurrencyNeg() {
		when(db.query(anyString(), any(ExtractCurrency.ExtractDouble.class))).thenReturn(50.0);
		assertNotEquals(50.02,dc.getTotalCurrency(),.01);
	}
	
	@Test
	@Category(PositiveTestsCategory.class)
	public void testTotalDoubloonPos() throws SQLException {
		when(db.query(anyString(), any(ExtractCurrency.ExtractInteger.class))).thenReturn(50);
		assertEquals(new Integer(50), dc.getTotalDoubloons());
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testTotalDoubloonNeg() {
		when(db.query(anyString(), any(ExtractCurrency.ExtractInteger.class))).thenReturn(50);
		assertNotEquals(new Integer(131),dc.getTotalDoubloons());
	}

}
