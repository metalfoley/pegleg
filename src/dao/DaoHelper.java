package dao;

import java.sql.PreparedStatement;

import base.DBConn;
import extract.ExtractHelper;

public class DaoHelper {

	/**
	 * Get number of columns
	 */
	public Integer getCount() {
		DBConn dbConn = new DBConn();
		return dbConn.query("SELECT COUNT(ID) AS Total FROM Pirate",new ExtractHelper());
	}
}
