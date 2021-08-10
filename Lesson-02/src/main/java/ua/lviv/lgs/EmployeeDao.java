package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	static String SHOW_ALL = "select * from employee";
	static String CREATE = "insert into employee (`first_name`,`last_name`) values (?,?)";
	static String READ_BY_ID = "select * from employee where id = ?";
	static String UPDATE_BY_ID = "update employee set first_name = ? , last_name = ? where id = ?";
	static String DELETE_BY_ID = "delete from employee where id = ?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;

	public EmployeeDao(Connection connection) {
		this.connection = connection;
	}
	
	public void insert(Employee e) throws SQLException {
		preparedStatement = connection.prepareStatement(CREATE);
	    preparedStatement.setString(1,e.getFirstname());
	    preparedStatement.setString(2,e.getLastname());
		preparedStatement.executeUpdate();
	}
	
	public void read(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		System.out.println(EmployeeMapper.map(result));
	}
	public void update(Employee e) throws SQLException {
		preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1,e.getFirstname());
	    preparedStatement.setString(2,e.getLastname());
	    preparedStatement.setInt(3, e.getId());
	    preparedStatement.executeUpdate();
	}
	public void delete(int id) throws SQLException {
		preparedStatement = connection.prepareStatement(DELETE_BY_ID);
	    preparedStatement.setInt(1, id);
	    preparedStatement.executeUpdate();
	}
	public void readall() throws SQLException {
		preparedStatement = connection.prepareStatement(SHOW_ALL);
		ResultSet result = preparedStatement.executeQuery();
		List list = new ArrayList();
		while(result.next()){
			list.add(EmployeeMapper.map(result));
		}
		list.stream().forEach(System.out::println);
		System.out.println("**********************************");
	}
}
