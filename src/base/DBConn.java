package base;
import interfaces.Iextractor;

import java.sql.*;

public class DBConn {

	private static final String connString =  "jdbc:jtds:sqlserver://PC20141:1433/bms;instance=MSSQLServer";
	private static final String userName = "sbyington";
	private static final String password = "Catalyst123";
	private Connection conn;
	
	static
	{
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (ClassNotFoundException e) {
            System.out.println("SQL Driver error: " + e.getMessage());
		}
	}
	
	public DBConn(){
		openConn();
	}
	
	public void update(String s) throws SQLException
	{
		try
		{
			PreparedStatement ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
	
		}
		catch (SQLException ex)
		{
			Filo.log("DBConn.update: " + ex.getMessage());
		}
		closeConn();
	}
	
	public <T> T query(String s, Iextractor<T> extractor) 
	{		
		T extracted = null;
		try
		{
			PreparedStatement ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			extracted = extractor.extract(ps.executeQuery());
		}
		catch (SQLException ex)
		{
			Filo.log("DBConn.query: " + ex.getMessage());
		}
		closeConn();
		return extracted;
	}
	
	private void openConn() 
	{
		try {
			conn = DriverManager.getConnection(connString, userName, password);
		} catch (SQLException e) {
			Filo.log("DBConn.openConn: " + e.getMessage());
		}
	}
	
	private void closeConn()
	{
		try {
			conn.close();
		} catch (SQLException e) {		
			Filo.log("DBConn.closeConn: " + e.getMessage());
		}
	}
	
	public void rollback() {
		if(conn!=null){
			try {
				conn.rollback();
			} catch (SQLException e) {
				Filo.log("DBConn rollback" + e.getMessage());
			}
		}
	}
	
	
}