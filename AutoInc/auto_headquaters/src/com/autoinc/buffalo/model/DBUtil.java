package com.autoinc.buffalo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	
	public static final String USERNAME = "autoinc";
	public static final String PASSWORD = "autoinc123";
	public static final String CONNECTION = "jdbc:mysql://s17975972.onlinehome-server.info:3306/headquaters";
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				connection = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
				
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
		return connection;
		
	}
	
	public static String getStringResult(String query, String columnName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

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

	public static int getIntResult(String query, String columnName) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

		int result = -1;

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

			resultSet.close();
			statement.close();
			connection.close();

		}
		catch (SQLException e) {
			System.err.println(e);
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
}
