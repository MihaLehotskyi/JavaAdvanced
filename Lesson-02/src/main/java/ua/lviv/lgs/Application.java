package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Application {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
	MagazineDao m = new MagazineDao(ConnectionUtils.openConnection());
	m.readall();
	m.readall();
	System.out.println("________");
	m.showCheaperThan(9);
	m.showWorthierThan(11);
	}
}