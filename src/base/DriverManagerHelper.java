package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverManagerHelper {
	private static final String connString = "jdbc:jtds:sqlserver://PC20141:1433/bms;instance=MSSQLServer";
	private static final String userName = "sbyington";
	private static final String password = "Catalyst123";

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connString, userName, password);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Filo.log("Connection not established: " + ex.getMessage());
		}
		return conn;
	}
}
