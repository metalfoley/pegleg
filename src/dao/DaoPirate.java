package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import extract.ExtractPirate;
import base.DBConn;
import base.Filo;
import program.Pirate;

public class DaoPirate {
	
	public DaoPirate() {}
	
	/**
	 * Get all the pirates in the db
	 * @return
	 */
	public ArrayList<Pirate> getAllPirates() {
		DBConn dbConn = new DBConn();
		String query = "SELECT p.ID,p.FirstName,p.LastName,p.ShipName,p.PirateName FROM Pirate AS p";
		return dbConn.query(query, new ExtractPirate().new ExtractPirateArrylist());
	}
	
	/**
	 * Get a single pirate
	 * @param id
	 * @return
	 */
	public Pirate getPirate(int id) {
		DBConn dbConn = new DBConn();
		String query = "SELECT p.ID,p.FirstName,p.LastName,p.ShipName,p.PirateName FROM Pirate AS p WHERE p.ID=" + id;
		return dbConn.query(query, new ExtractPirate().new ExtractPirateSingle());
	}
	
	/**
	 * Insert/update a new pirate in the database
	 * @param request
	 */
	public void insertPirate(Pirate p, Integer id) {
		String query;

		// If ID is present then update the current pirate. If no ID, then create new pirate in DB
		if(id != null) {
			query = String.format("UPDATE Pirate SET FirstName='%s',lastName='%s',shipName='%s',pirateName='%s' WHERE ID='%d'", 
									p.getFirstName(),p.getLastName(),p.getShipName(),p.getPirateName(),id);
		} else {
			query = String.format("INSERT INTO Pirate (FirstName,lastName,shipName,pirateName) VALUES ('%s','%s','%s','%s')", 
					p.getFirstName(),p.getLastName(),p.getShipName(),p.getPirateName());
		}
		
		DBConn dbConn = new DBConn();
		try {
			dbConn.update(query);
		} catch (SQLException e) {
			Filo.log("insertPirate" + e.getMessage());
		}
	}
	
	/**
	 * Create a blank pirate if no pirate exists
	 * @return
	 */
	public Pirate createPirate(String name) {
		Pirate p = new Pirate();
		p.setFirstName("");
		p.setLastName("");
		p.setShipName(name);
		p.setPirateName("");
		return p;
	}

}
