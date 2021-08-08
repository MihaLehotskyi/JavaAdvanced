package ua.lviv.lgs.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ua.lviv.lgs.dao.BucketDao;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.utils.ConnectionUtils;

public class BucketDaoImpl implements BucketDao{
	static String SHOW_ALL = "select * from bucket";
	static String CREATE = "insert into bucket (`user_id`,`product_id`,`purchase_date`) values (?,?,?)";
	static String READ_BY_ID = "select * from bucket where id = ?";
	static String DELETE_BY_ID = "delete from bucket where id = ?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	
	public BucketDaoImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		connection = ConnectionUtils.openConnection();
	}

	@Override
	public Bucket create(Bucket obj) {
		try {
			preparedStatement = connection.prepareStatement(CREATE,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1,obj.getUserid());
		    preparedStatement.setInt(2,obj.getProductid());
		    preparedStatement.setDate(3,new Date(obj.getPurchasetime().getTime()));
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
	public Bucket update(Bucket obj) {
		throw new IllegalArgumentException("bucket has no updates");
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
	public Bucket read(Integer id) {
		Bucket b = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			
			result.next();
			
			Integer bucket_id = result.getInt("id");
			Integer user_id = result.getInt("user_id");
			Integer product_id = result.getInt("product_id");
			java.util.Date date = result.getDate("product_id");
			b = new Bucket(bucket_id,user_id,product_id,date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
		
	}

	@Override
	public List<Bucket> readall() {
		List list = new ArrayList();
		try {
			preparedStatement = connection.prepareStatement(SHOW_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while(result.next()){
				Integer bucket_id = result.getInt("id");
				Integer user_id = result.getInt("user_id");
				Integer product_id = result.getInt("product_id");
				java.util.Date date = result.getDate("product_id");
				list.add(new Bucket(bucket_id,user_id,product_id,date));
			}
			list.stream().forEach(System.out::println);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
