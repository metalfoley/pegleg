package dao;

import java.sql.SQLException;

import extract.ExtractCurrency;
import base.DBConn;
import base.Filo;

public class DaoCurrency {
	
	public Double getTotalCurrency() {
		DBConn dbConn = new DBConn();
		return dbConn.query("SELECT Currency From Currency", new ExtractCurrency().new ExtractDouble());
	}
	
	public Integer getTotalDoubloons() {
		DBConn dbConn = new DBConn();
		return dbConn.query("SELECT Doubloons From Currency", new ExtractCurrency().new ExtractInteger());
	}

	public void updateDoubloons(int dou) {
		DBConn dbConn = new DBConn();
		try {
			dbConn.update("UPDATE Currency SET Doubloons = Doubloons + " + dou);
			Filo.log("UPDATE Currency SET Doubloons = Doubloons + " + dou);
		} catch (SQLException e) {
			Filo.log("updateDoubloons: " + e.getMessage());
		}
	}
	
	public void updateCurrency(double currency, int doubloon) {
		String query = String.format("UPDATE Currency SET Currency=%f,Doubloons=%d WHERE ID=1", currency, doubloon);
		DBConn dbConn = new DBConn();
		try {
			dbConn.update(query);
		} catch (SQLException e) {
			Filo.log("updateCurrency: " + e.getMessage());
		}
	}
		
}
