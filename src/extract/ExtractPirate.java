package extract;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBConn;
import base.Filo;
import program.Pirate;

public class ExtractPirate {
	
	public static ArrayList<Pirate> extractAllPirates(ResultSet rs) {
		ArrayList<Pirate> pirates = new ArrayList<Pirate>();
		Pirate pirate;
		try {
			while(rs.next()) {
				pirate = new Pirate();
				pirate.setID(rs.getInt("ID"));
				pirate.setLastName(rs.getString("LastName"));
				pirate.setFirstName(rs.getString("FirstName"));
				pirate.setShipName(rs.getString("ShipName"));
				pirate.setPirateName(rs.getString("PirateName"));
				pirates.add(pirate);
			}
		} catch (SQLException e) {
			Filo.log("extractAllPirates" + e.getMessage());
		} finally {
			DBConn.closeConn();
		}
		return pirates;
	}
	
	public static Pirate extractPirate(ResultSet rs) {
		Pirate pirate = new Pirate();
		try {
			while(rs.next()) {
				pirate = new Pirate();
				pirate.setID(rs.getInt("ID"));
				pirate.setLastName(rs.getString("LastName"));
				pirate.setFirstName(rs.getString("FirstName"));
				pirate.setShipName(rs.getString("ShipName"));
				pirate.setPirateName(rs.getString("PirateName"));
			}
		} catch (SQLException e) {
			Filo.log("extractPirate" + e.getMessage());
		} finally {
			DBConn.closeConn();
		}
		return pirate;
	}
}
