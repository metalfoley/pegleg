package extract;

import interfaces.Iextractor;

import java.sql.ResultSet;
import java.sql.SQLException;

import base.Filo;

public class ExtractCurrency {

	public class ExtractDouble implements Iextractor<Double> {
		public Double extract(ResultSet rs) {
			Double currency = null;
			try {
				while(rs.next())
					currency = rs.getDouble("Currency");
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
			return currency;
		}
	}
	
	public class ExtractInteger implements Iextractor<Integer> {
		public Integer extract(ResultSet rs) {
			Integer doubloon = null;
			try {
				while(rs.next())
					doubloon = rs.getInt("Doubloons");
			} catch (SQLException e) {
				Filo.log(e.getMessage());
			}
			return doubloon;
		}
	}
}
