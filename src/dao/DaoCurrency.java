package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import base.DBConn;
import base.Filo;

public class DaoCurrency {
	
	public static double getTotalCurrency() {
		double total = 0;
		DBConn.openConn();
		ResultSet rs = DBConn.query("SELECT Currency From Currency");
		try {
			while(rs.next())
				total = rs.getDouble("Currency");
		} catch (SQLException e) {
			Filo.log(e.getMessage());
		}
		DBConn.closeConn();
		return total;
	}
	
	public static int getTotalDoubloons() {
		int total = 0;
		DBConn.openConn();
		ResultSet rs = DBConn.query("SELECT Doubloons From Currency");
		try {
			while(rs.next())
				total = rs.getInt("Doubloons");
		} catch (SQLException e) {
			Filo.log(e.getMessage());
		}
		DBConn.closeConn();
		return total;
	}
	
	
	
	public static void updateDoubloons(int dou) {
		DBConn.openConn();
		try {
			DBConn.update("UPDATE Currency SET Doubloons = Doubloons + " + dou);
			Filo.log("UPDATE Currency SET Doubloons = Doubloons + " + dou);
		} catch (SQLException e) {
			Filo.log("updateDoubloons: " + e.getMessage());
		}
		DBConn.closeConn();
	}
		
}
