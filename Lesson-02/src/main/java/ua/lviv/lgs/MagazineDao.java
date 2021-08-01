package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDao {
	
	static String SHOW_ALL = "select * from magazine";
	static String CREATE = "insert into magazine (`name`,`cost`,`amount`) values (?,?,?)";
	static String READ_BY_ID = "select * from magazine where id = ?";
	static String UPDATE_BY_ID = "update magazine set name = ? , cost = ?, amount = ? where id = ?";
	static String DELETE_BY_ID = "delete from magazine where id = ?";
	static String SHOW_CHEAPER = "select * from magazine where cost < ?";
	static String SHOW_WORTHIER = "select * from magazine where cost > ?";
	
	private Connection connection;
	private PreparedStatement preparedstatement;
	
	
	public MagazineDao(Connection connection) {
		super();
		this.connection = connection;
	}
	public void insert(Magazine m) throws SQLException{
		preparedstatement = connection.prepareStatement(CREATE);
		preparedstatement.setString(1,m.getName());
		preparedstatement.setInt(2,m.getCost());
		preparedstatement.setInt(3, m.getAmount());
		preparedstatement.executeUpdate();
	}
	public void readall() throws SQLException {
		preparedstatement = connection.prepareStatement(SHOW_ALL);
		ResultSet result = preparedstatement.executeQuery();
		List list = new ArrayList<>();
		while(result.next()){
				list.add(MagazineMapper.map(result));
			}
		list.stream().forEach(System.out::println);
		}
	public void readbyid(int id) throws SQLException {
		preparedstatement = connection.prepareStatement(READ_BY_ID);
		preparedstatement.setInt(1, id);
		ResultSet result = preparedstatement.executeQuery();
		result.next();
		System.out.println(MagazineMapper.map(result));
		
	}
	public void update(Magazine m) throws SQLException {
		preparedstatement = connection.prepareStatement(UPDATE_BY_ID);
		preparedstatement.setString(1,m.getName());
	    preparedstatement.setInt(2,m.getCost());
	    preparedstatement.setInt(3, m.getAmount());
	    preparedstatement.executeUpdate();
	}
	public void delete(int id) throws SQLException {
		preparedstatement = connection.prepareStatement(DELETE_BY_ID);
	    preparedstatement.setInt(1, id);
	    preparedstatement.executeUpdate();
	}
	public void showCheaperThan(int cost) throws SQLException {
		preparedstatement = connection.prepareStatement(SHOW_CHEAPER);
		preparedstatement.setInt(1,cost);
		ResultSet result = preparedstatement.executeQuery();
		List list = new ArrayList<>();
		while(result.next()){
			if(MagazineMapper.map(result).getCost() < cost) {
				System.out.println(MagazineMapper.map(result));
			}
		}
		
	}
	public void showWorthierThan(int cost) throws SQLException {
		preparedstatement = connection.prepareStatement(SHOW_WORTHIER);
		preparedstatement.setInt(1,cost);
		ResultSet result = preparedstatement.executeQuery();
		List list = new ArrayList<>();
		while(result.next()){
			if(MagazineMapper.map(result).getCost() > cost) {
				System.out.println(MagazineMapper.map(result));
			}
		}
		
	}
}
