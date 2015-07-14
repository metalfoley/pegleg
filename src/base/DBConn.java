package base;
import interfaces.Iextractor;

import java.sql.*;

public class DBConn {

	private Connection conn;
	
	static
	{
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (ClassNotFoundException e) {
            System.out.println("SQL Driver error: " + e.getMessage());
		}
	}
	
	public DBConn(DriverManagerHelper driverManager){
		setConn(driverManager.getConnection());
	}
	
	public DBConn(){
		this(new DriverManagerHelper());
	}
	

	
	public void update(String s) throws SQLException
	{
		try
		{
			PreparedStatement ps = getConn().prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
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
			PreparedStatement ps = getConn().prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			extracted = extractor.extract(ps.executeQuery());
		}
		catch (SQLException ex)
		{
			Filo.log("DBConn.query: " + ex.getMessage());
		}
		closeConn();
		return extracted;
	}

	private void closeConn()
	{
		try {
			getConn().close();
		} catch (SQLException e) {		
			Filo.log("DBConn.closeConn: " + e.getMessage());
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
}