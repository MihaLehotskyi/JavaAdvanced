package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazineMapper {
	
	
	public static Magazine map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String name = result.getString("name");
		int cost = result.getInt("cost");
		int amount = result.getInt("amount");
		
		return new Magazine(id,name,cost,amount);
		
	}
}
