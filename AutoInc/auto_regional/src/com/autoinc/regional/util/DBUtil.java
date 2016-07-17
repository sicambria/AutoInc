package com.autoinc.regional.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
	
	public static final String USERNAME = "autoinc";
	public static final String PASSWORD = "autoinc123";
	public static final String CONNECTION = "jdbc:mysql://s17975972.onlinehome-server.info:3306/warehouse";
	
	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		Connection connection = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
	
		return connection;
		
	}
	
	public static String getStringResult(String query, String columnName) {

		String result = "";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				result = resultSet.getString(columnName);
			}

			resultSet.close();
			statement.close();
			connection.close();

		}
		catch (SQLException e) {
			System.err.println(e);
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.err.println(e1);
		}
		finally {

			try {
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}
		}
		return result;

	}

	public static int getIntResult(String query, String columnName) {

		int result = 0;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				result = resultSet.getInt(columnName);
			}
			
			System.out.println(result);

			resultSet.close();
			statement.close();
			connection.close();

		}
		catch (SQLException e) {
			System.err.println(e);
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.err.println(e1);
		}
		finally {

			try {
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}
		}
		System.out.println(result + " result 2");
		return result;

	}
}

