package database.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}	
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/virtualDT","root","root");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}