package com.modernmenu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConfigAndUtil {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");  
		
		Connection connection=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/dynamicmenu","root","Chandu@0502");  
//		Connection connection=DriverManager.getConnection(  
//				"jdbc:mysql://172.23.0.2:3306/dynamicmenu","sa","Chandu@0502");  
		
		return connection;
		
	}
	
	public static int getTableCount(String name) {
		
		int value = 0;
		
		try {

			Connection connection = DBConfigAndUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT COUNT(1) FROM dynamicmenu."+name+";");

			while (resultSet.next()) {
				value = resultSet.getInt(1);
			}
			connection.close();
			
		} catch (Exception e1) {
			System.out.println(e1.getStackTrace());
		}
		
		return value;
		
	}

}
