package dao;

import java.sql.SQLException;

import extract.ExtractCurrency;
import base.DBConn;
import base.Filo;

public class DaoCurrency {
	private DBConn dbConn;
	
	public DaoCurrency(){
		dbConn = new DBConn();
	}
	
	public DaoCurrency(DBConn dbConn){
		this.dbConn = dbConn;
	}
	
	private ExtractCurrency.ExtractDouble extractDouble = new ExtractCurrency().new ExtractDouble();
	private ExtractCurrency.ExtractInteger extractInteger = new ExtractCurrency().new ExtractInteger();
	
	public Double getTotalCurrency() {
		return getDbConn().query("SELECT Currency From Currency", getExtractDouble());
	}
	
	public Integer getTotalDoubloons() {
		return getDbConn().query("SELECT Doubloons From Currency", getExtractInteger());
	}

	public void updateDoubloons(int dou) {
		try {
			getDbConn().update("UPDATE Currency SET Doubloons = Doubloons + " + dou);
			Filo.log("UPDATE Currency SET Doubloons = Doubloons + " + dou);
		} catch (SQLException e) {
			Filo.log("updateDoubloons: " + e.getMessage());
		}
	}
	
	public void updateCurrency(double currency, int doubloon) {
		String query = String.format("UPDATE Currency SET Currency=%f,Doubloons=%d WHERE ID=1", currency, doubloon);
		try {
			getDbConn().update(query);
		} catch (SQLException e) {
			Filo.log("updateCurrency: " + e.getMessage());
		}
	}

	public DBConn getDbConn() {
		return dbConn;
	}

	public void setDbConn(DBConn dbConn) {
		this.dbConn = dbConn;
	}

	public ExtractCurrency.ExtractDouble getExtractDouble() {
		return extractDouble;
	}

	public void setExtractDouble(ExtractCurrency.ExtractDouble extractDouble) {
		this.extractDouble = extractDouble;
	}

	public ExtractCurrency.ExtractInteger getExtractInteger() {
		return extractInteger;
	}

	public void setExtractInteger(ExtractCurrency.ExtractInteger extractInteger) {
		this.extractInteger = extractInteger;
	}
		
}
