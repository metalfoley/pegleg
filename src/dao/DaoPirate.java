package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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
	public static ArrayList<Pirate> getAllPirates() {
		DBConn.openConn();
		ResultSet rs = DBConn.query("SELECT p.ID,p.FirstName,p.LastName,p.ShipName,p.PirateName FROM Pirate AS p");
		return ExtractPirate.extractAllPirates(rs);
	}
	
	/**
	 * Get a single pirate
	 * @param id
	 * @return
	 */
	public static Pirate getPirate(int id) {
		DBConn.openConn();
		ResultSet rs = DBConn.query("SELECT p.ID,p.FirstName,p.LastName,p.ShipName,p.PirateName FROM Pirate AS p WHERE p.ID=" + id);
		return ExtractPirate.extractPirate(rs);
	}
	
	/**
	 * Insert/update a new pirate in the database
	 * @param request
	 */
	public static void insertPirate(HttpServletRequest request) {
		int id;
		String query;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String shipName = request.getParameter("shipName");
		String pirateName = request.getParameter("pirateName");
		
		// If ID is present then update the current pirate. If no ID, then create new pirate in DB
		if(request.getParameter("id") != null) {
			id = Integer.parseInt(request.getParameter("id"));
			query = String.format("UPDATE Pirate SET FirstName='%s',lastName='%s',shipName='%s',pirateName='%s' WHERE ID='%d'", 
									firstName,lastName,shipName,pirateName,id);
		} else {
			query = String.format("INSERT INTO Pirate (FirstName,lastName,shipName,pirateName) VALUES ('%s','%s','%s','%s')", 
					firstName,lastName,shipName,pirateName);
		}
		
		DBConn.openConn();
		try {
			DBConn.update(query);
		} catch (SQLException e) {
			Filo.log("insertPirate" + e.getMessage());
		}
		DBConn.closeConn();
	}
	
	/**
	 * Create a blank pirate if no pirate exists
	 * @return
	 */
	public static Pirate createPirate(String name) {
		Pirate p = new Pirate();
		p.setFirstName("");
		p.setLastName("");
		p.setShipName(name);
		p.setPirateName("");
		return p;
	}
	
	/**
	 * Get number of columns
	 */
	public static int getCount() {
		int total = 0;
		DBConn.openConn();
		ResultSet rs = DBConn.query("SELECT COUNT(*) AS Total FROM Pirate");
		try {
			while(rs.next())
				total = rs.getInt("Total");
		} catch (SQLException e) {
			Filo.log("");
		}
		return total;
	}

}
