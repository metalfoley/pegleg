package testing;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;

import dao.DaoCurrency;

public class ServletTest {

	private Double currency;
	private Integer doubloon;
	private HttpServletRequest request;
	private HttpServletResponse response;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		request = Mockito.mock(HttpServletRequest.class);
		response = Mockito.mock(HttpServletResponse.class);
		
		currency = 22.25;
		doubloon = 50;

		Mockito.when(request.getParameter("dtod")).thenReturn(currency.toString());
		Mockito.when(request.getParameter("totalDoubloons")).thenReturn(doubloon.toString());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Category(PositiveTestsCategory.class)
	public void testUpdateCurrencyPostPos() {
		assertEquals(currency, new Double(request.getParameter("dtod")));
		assertEquals(doubloon, new Integer(request.getParameter("totalDoubloons")));
	}
	
	@Test
	@Category(NegativeTestsCategory.class)
	public void testUpdateCurrencyPostNeg() {
		assertNotEquals(currency + 1, new Double(request.getParameter("dtod")));
		assertNotEquals(new Integer(doubloon + 1), new Integer(request.getParameter("totalDoubloons")));
	}

}
