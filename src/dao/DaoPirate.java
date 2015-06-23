package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import extract.ExtractPirate;
import base.DBConn;
import program.Pirate;

public class DaoPirate {
	
	public DaoPirate() {}
	
	public ArrayList<Pirate> getAllPirates() {
		DBConn.openConn();
		ResultSet rs = DBConn.query("SELECT * FROM Pirate");
		return ExtractPirate.extractAllPirates(rs);
	}
	
	public Pirate getPirate(int id) {
		DBConn.openConn();
		ResultSet rs = DBConn.query("SELECT * FROM Pirate WHERE ID=" + id);
		return ExtractPirate.extractPirate(rs);
	}
}
