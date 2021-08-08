package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.lviv.lgs.dao.ProductDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;

public class ProductDaoImpl implements ProductDao{
	static String SHOW_ALL = "select * from product";
	static String CREATE = "insert into product (`name`,`description`,`price`) values (?,?,?)";
	static String READ_BY_ID = "select * from product where id = ?";
	static String UPDATE_BY_ID = "update product set name = ? , description = ? , price = ? where id = ?";
	static String DELETE_BY_ID = "delete from product where id = ?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;


	@Override
	public Product create(Product obj) {
		try {
			preparedStatement = connection.prepareStatement(CREATE,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,obj.getName());
		    preparedStatement.setString(2,obj.getDescription());
		    preparedStatement.setDouble(3,obj.getPrice());
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
	public Product update(Product obj) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1,obj.getName());
		    preparedStatement.setString(2,obj.getDescription());
		    preparedStatement.setDouble(3,obj.getPrice());
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
	public Product read(Integer id) {
		Product p = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			
			result.next();
			
			Integer product_id = result.getInt("id");
			String name = result.getString("name");
			String description = result.getString("description");
			Double price = result.getDouble("price");
			p = new Product(product_id,name,description,price);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> readall() {
		List list = new ArrayList();
		try {
			preparedStatement = connection.prepareStatement(SHOW_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()){
				Integer product_id = result.getInt("id");
				String name = result.getString("name");
				String description = result.getString("description");
				Double price = result.getDouble("price");
				list.add(new Product(product_id,name,description,price));
			}
			list.stream().forEach(System.out::println);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
