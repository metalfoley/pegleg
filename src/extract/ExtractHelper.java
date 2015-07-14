package extract;

import java.sql.ResultSet;
import java.sql.SQLException;

import base.Filo;
import interfaces.Iextractor;

public class ExtractHelper implements Iextractor<Integer>{

	@Override
	public Integer extract(ResultSet rs) {
		Integer total = null;
		try {
			while(rs.next())
				total = rs.getInt("Total");
		} catch (SQLException e) {
			Filo.log("DaoPirate getCount: " + e.getMessage());
		}
		return total;
	}
	
	
}
