package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.UserDao;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.utils.ConnectionUtils;

public class UserDaoImpl implements UserDao{
	static String SHOW_ALL = "select * from user";
	static String CREATE = "insert into user (`email`,`first_name`,`last_name`,`role`) values (?,?,?,?)";
	static String READ_BY_ID = "select * from user where id = ?";
	static String UPDATE_BY_ID = "update user set email = ? , first_name = ? last_name = ? , role = ? where id = ?";
	static String DELETE_BY_ID = "delete from user where id = ?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	
	public UserDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}
	@Override
	public User create(User obj) {
		try {
			preparedStatement = connection.prepareStatement(CREATE,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,obj.getEmail());
		    preparedStatement.setString(2,obj.getFirstname());
		    preparedStatement.setString(3,obj.getLastname());
		    preparedStatement.setString(4,obj.getRole());
			preparedStatement.executeUpdate();
			
			ResultSet rs = preparedStatement.getGeneratedKeys();
			rs.next();
			obj.setId(rs.getInt(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		return obj;
	}

	@Override
	public User update(User obj) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1,obj.getEmail());
		    preparedStatement.setString(2,obj.getFirstname());
		    preparedStatement.setString(3,obj.getLastname());
		    preparedStatement.setString(4,obj.getRole());
		    preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	    return obj;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);	
		    preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public User read(Integer id) {
		User u = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			
			result.next();
			
			Integer user_id = result.getInt("id");
			String email = result.getString("email");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			String role = result.getString("role");
			u = new User(user_id,email,first_name,last_name,role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
		
	}

	@Override
	public List<User> readall() {
		List list = new ArrayList();
		try {
			preparedStatement = connection.prepareStatement(SHOW_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()){
				Integer user_id = result.getInt("id");
				String email = result.getString("email");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				String role = result.getString("role");
				list.add(new User(user_id,email,first_name,last_name,role));
			}
			list.stream().forEach(System.out::println);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
