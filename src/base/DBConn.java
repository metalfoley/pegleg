package base;
import java.sql.*;

public class DBConn {

	static private String connectionString = "jdbc:jtds:sqlserver://PC20141:1433/bms;instance=MSSQLServer";
	static private String connString =  "jdbc:jtds:sqlserver://PC20141:1433/bms;instance=MSSQLServer";
	static private String userName = "sbyington";
	static private String password = "Catalyst123";
	static private ResultSet rs;
	static private Connection conn;
	
	public static void connect()
	{
		try{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
		} catch (ClassNotFoundException e) {
            System.out.println("SQL Driver error: " + e.getMessage());
		}
	}
	
	public static void createDB() throws SQLException
	{
		connect();
		conn = DriverManager.getConnection(connectionString, userName, password);
		try
		{
			String s;
			
			s = "IF NOT EXISTS(Select * From sys.Databases where name = 'LearningManagementSystem') CREATE DATABASE LearningManagementSystem";
			PreparedStatement ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			
			s = "IF OBJECT_ID('[LearningManagementSystem].[dbo].[Roles]', 'U') is null CREATE TABLE [LearningManagementSystem].[dbo].[Roles](ID int NOT NULL PRIMARY KEY IDENTITY(1,1), Role varchar(254), Active bit default 'True')";
			ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			
			s = "IF OBJECT_ID('[LearningManagementSystem].[dbo].[Person]', 'U') is null CREATE TABLE [LearningManagementSystem].[dbo].[Person](ID bigint NOT NULL PRIMARY KEY IDENTITY(1,1), FirstName varchar(100), LastName varchar(200), Address varchar(254), City varchar(254), State varchar(254), Zipcode varchar(100), Phone1 varchar(20), Phone2 varchar(20), Email varchar(254), Role int, Active bit, FOREIGN KEY(Role) REFERENCES Roles(ID))";
			ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			
			s = "IF OBJECT_ID('[LearningManagementSystem].[dbo].[Place_Type]', 'U') is null CREATE TABLE [LearningManagementSystem].[dbo].[Place_Type](ID int NOT NULL PRIMARY KEY IDENTITY(1,1), Type varchar(254))";
			ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			
			s = "IF OBJECT_ID('[LearningManagementSystem].[dbo].[Place]', 'U') is null CREATE TABLE [LearningManagementSystem].[dbo].[Place](ID int NOT NULL PRIMARY KEY IDENTITY(1,1), Name varchar(254), Address varchar(254), City varchar(254), State varchar(254), Zipcode varchar(100), Phone varchar(20), Email varchar(254), WebURL varchar(254), Fax varchar(20), Place_Type int, Active bit FOREIGN KEY(Place_Type) REFERENCES Place_Type(ID))";
			ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();

		}
		catch (SQLException ex)
		{
			System.out.println("DBConn.createDB: " + ex.getMessage());
			Filo.log("DBConn.createDB: " + ex.getMessage());
		}
		finally
		{
			conn.close();
		}
	}
	
	public static void update(String s) throws SQLException
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
	}
	
	public static ResultSet query(String s) 
	{
		try
		{
			PreparedStatement ps = conn.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
			rs = ps.executeQuery();
	
			return rs;
		}
		catch (SQLException ex)
		{
			Filo.log("DBConn.query: " + ex.getMessage());
			return rs;
		} 
		
	}
	
	public static void openConn() {
		connect();
		try {
			conn = DriverManager.getConnection(connString, userName, password);
		} catch (SQLException e) {
			Filo.log("DBConn.openConn: " + e.getMessage());
		}
	}
	
	public static void closeConn()
	{
		try {
			conn.close();
		} catch (SQLException e) {		
			Filo.log("DBConn.closeConn: " + e.getMessage());
		}
	}
	
	
	
	
}