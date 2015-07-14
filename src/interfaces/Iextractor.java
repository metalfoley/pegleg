package interfaces;

import java.sql.ResultSet;

public interface Iextractor<T> {
	public T extract(ResultSet rs);
}
