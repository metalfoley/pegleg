package testing;

import interfaces.Iextractor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;

import program.Pirate;
import extract.ExtractPirate;
import base.DBConn;
import base.DriverManagerHelper;

@RunWith(MockitoJUnitRunner.class)
public class DbConnTest {
	
	@Mock
	PreparedStatement ps;
	@Mock
	Connection conn;
	@Mock
	DriverManagerHelper driverManager;
	@Mock
	Pirate pirate;
	@Mock
	ExtractPirate extract;
	@Mock
	SQLException sqlEx;
	@Mock
	Iextractor<Pirate> ex;
	@Mock
	ResultSet rs;
	
	DBConn dbConn;
	
	@Before
	public void init(){
		when(driverManager.getConnection()).thenReturn(conn);		
		dbConn = new DBConn(driverManager);

	}
	
	@Test
	public void testUpdateSuccessful() throws SQLException{
		//Arrange
		when(conn.prepareStatement(anyString(), anyInt())).thenReturn(ps);
				
		//Act
		dbConn.update("");
		
		//Asserts
		verify(ps).executeUpdate();
	}

	@Test
	public void testUpdateFailWithException() throws SQLException{
		//Arrange
		when(sqlEx.getMessage()).thenReturn("test error, will mock later");
		when(conn.prepareStatement(anyString(), anyInt()))
			.thenThrow(sqlEx);
		
		//Act
		dbConn.update("");

		//Assert
		verify(sqlEx).getMessage();
	}
	
	@Test
	//@Ignore
	public void testQuerySuccessful() throws SQLException {
		//Arrange
		when(conn.prepareStatement(anyString(), anyInt())).thenReturn(ps);
		when(ps.executeQuery()).thenReturn(rs);
		when(ex.extract(rs)).thenReturn(pirate);
		
		//Act
		dbConn.query("", ex);
		
		//Assert
		verify(ps).executeQuery();
		verify(ex).extract(rs);
	}
	
	@Test
	public void testQueryFailWithException() throws SQLException{
		//Arrange
		when(sqlEx.getMessage()).thenReturn("test error, will mock later");
		when(conn.prepareStatement(anyString(), anyInt()))
			.thenThrow(sqlEx);
		
		//Act
		dbConn.query("", ex);

		//Assert
		verify(sqlEx).getMessage();
	}
}
