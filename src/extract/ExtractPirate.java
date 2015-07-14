package extract;

import interfaces.Iextractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.DBConn;
import base.Filo;
import program.Pirate;

public class ExtractPirate {
	
	public class ExtractPirateArrylist implements Iextractor<ArrayList<Pirate>>{
		public ArrayList<Pirate> extract(ResultSet rs) {
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
			}
			return pirates;
		}
	}
	
	public class ExtractPirateSingle implements Iextractor<Pirate> {
		public Pirate extract(ResultSet rs) {
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
			}
			return pirate;
		}
	}
}
