package com.autoinc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil
{

	public static final String USERNAME = "autoinc";
	public static final String PASSWORD = "autoinc123";
	public static final String FACTORY_CONNECTION = "jdbc:mysql://s17975972.onlinehome-server.info:3306/FACTORY";
	public static final String WAREHOUSE_CONNECTION = "jdbc:mysql://s17975972.onlinehome-server.info:3306/warehouse";

	// Add to Tomcat7 CMD line arguments (Server > Open launch configuration):
	// -XX:MaxPermSize=128M -XX:+CMSClassUnloadingEnabled -XX:+CMSPermGenSweepingEnabled

	public static Connection getFactoryConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			SQLException
	{

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection(FACTORY_CONNECTION, USERNAME, PASSWORD);
		return connection;
	}

	public static Connection getWarehouseConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			SQLException
	{

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection(WAREHOUSE_CONNECTION, USERNAME, PASSWORD);
		return connection;
	}

	public static String getStringResult(String query, String columnName)
	{

		String result = "";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{
			connection = DBUtil.getFactoryConnection();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery(query);
			while (resultSet.next())
			{
				result = resultSet.getString(columnName);
			}

			resultSet.close();
			statement.close();
			connection.close();

		}
		catch (SQLException e)
		{
			System.err.println(e);
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1)
		{
			System.err.println(e1);
		}
		finally
		{

			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (SQLException e)
			{
				System.err.println(e);
			}
		}
		return result;

	}

	public static int getIntResult(String query, String columnName)
	{

		int result = -1;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{
			connection = DBUtil.getFactoryConnection();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery(query);
			while (resultSet.next())
			{
				result = resultSet.getInt(columnName);
			}

			resultSet.close();
			statement.close();
			connection.close();

		}
		catch (SQLException e)
		{
			System.err.println(e);
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1)
		{
			System.err.println(e1);
		}
		finally
		{

			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch (SQLException e)
			{
				System.err.println(e);
			}
		}
		return result;

	}
}
