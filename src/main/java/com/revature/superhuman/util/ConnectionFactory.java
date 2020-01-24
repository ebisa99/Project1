package com.revature.superhuman.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static String url;
	private static String username;
	private static String password;
	
	private static ConnectionFactory cf;

	private ConnectionFactory () {
		url = "jdbc:postgresql://" + System.getenv("Postgresql_url") + ":5432/project1?currentSchema=superhumans";
		username = System.getenv("prostresql_username");
		password = System.getenv("postgresql_password");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if (cf == null)
			cf = new ConnectionFactory();
		
		return cf.createConnection();
	}
	
	private Connection createConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return conn;
	}
}
