package testing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;

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
	
	DBConn dbConn;
	
	@Before
	public void init(){
		when(driverManager.getConnection()).thenReturn(conn);		
		dbConn = new DBConn(driverManager);

	}
	
	@Test
	public void testUpdateSuccessful() throws SQLException{
		//Arrange
		String expectedQuery = "test query";
		when(conn.prepareStatement(expectedQuery, Statement.RETURN_GENERATED_KEYS)).thenReturn(ps);
				
		//Act
		dbConn.update(expectedQuery);
		
		//Asserts
		verify(ps).executeUpdate();
	}
	
	@Test
	public void testUpdateFailWithException() throws SQLException{
		//Arrange
		SQLException sqlEx = mock(SQLException.class);
		when(sqlEx.getMessage()).thenReturn("test error, will mock later");
		when(conn.prepareStatement(anyString(), anyInt()))
			.thenThrow(sqlEx);
		
		//Act
		dbConn.update("");

		//Assert
		verify(sqlEx).getMessage();
	}
}
