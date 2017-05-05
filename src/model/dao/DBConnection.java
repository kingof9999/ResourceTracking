package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnection
 * 
 * Version 1.0
 * 
 * Date: 03/05/2017
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE				AUTHOR			DECRIPTION
 * -------------------------------------------
 * 03/05/2017		TinLQ			Create
 */
public class DBConnection {
	/**
	 * connect to database
	 * @return
	 */
	public Connection getConnect(){
		String url = "jdbc:sqlserver://localhost:1433;databaseName=ResourceTracking";
		String userName = "sa";
		String password = "abc@1234";
		Connection connection = null;
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
			System.out.println("Database connection success.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Database connection error.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Database connection error.");
		}finally {

		}
		return connection;
	}
}
