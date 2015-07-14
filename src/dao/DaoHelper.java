package dao;

import extract.ExtractHelper;
import base.DBConn;

public class DaoHelper {

	/**
	 * Get number of columns
	 */
	public Integer getCount() {
		DBConn dbConn = new DBConn();		
		return dbConn.query("SELECT COUNT(ID) AS Total FROM Pirate",new ExtractHelper());
	}
}
