package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper {
	public static Employee map(ResultSet result) throws SQLException {
		int id = result.getInt("id");
		String firstname = result.getString("first_name");
		String lastname = result.getString("last_name");
		
		Employee emp = new Employee(id,firstname,lastname);
		return emp;
	}
}
