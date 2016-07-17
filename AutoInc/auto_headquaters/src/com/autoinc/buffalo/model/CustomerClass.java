package com.autoinc.buffalo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CustomerClass
{

	public static CustomerObject getCustomer(String email_address) throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{

		int customerId = 0;
		String email = "";
		String password = "";
		String name = "";
		String phoneNumber = "";
		String country = "";
		String address = "";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{

			connection = DBUtil.getConnection();

			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery("SELECT * FROM customers WHERE email= '" + email_address + "'");
			while (resultSet.next())
			{

				customerId = Integer.parseInt(resultSet.getString("customer_id"));
				email = resultSet.getString("email");
				password = resultSet.getString("password");
				name = resultSet.getString("name");
				// We already have e-mail
				phoneNumber = resultSet.getString("phone_number");
				country = resultSet.getString("country");
				address = resultSet.getString("address");

			}

		}
		catch (SQLException e)
		{
			System.err.println(e);
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
				e.printStackTrace();
			}
		}

		CustomerObject reply = new CustomerObject(
				customerId,
				email,
				password,
				name,
				phoneNumber,
				country,
				address);

		return reply;
	}

	// ------------------------------------------------------------
	// Method is called when a customer wants to log in
	// ------------------------------------------------------------
	public static Boolean Login(String email, String enteredPassword)
	{

		String query = "SELECT password from customers WHERE email ='" + email + "';";
		String storedPassword = null;
		try {
			storedPassword = DBUtil.getStringResult(query, "password");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		boolean matched = BCrypt.checkpw(enteredPassword, storedPassword);
		return matched;
	}

	// ------------------------------------------------------------
	// Method is called when a new customer wants to register
	// ------------------------------------------------------------
	public static Boolean Register(String country, String name, String address, String phoneNumber, String email, String password) throws IllegalAccessException, InstantiationException, ClassNotFoundException
	{

		Boolean result = false;
		String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt(12));

		Connection connection = null;
		PreparedStatement preparedStmt = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			String query = " insert into customers (email, password, name, phone_number, "
					+ "country, address)" + " values (?, ?, ?, ?, ?, ?)";

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setString(1, email);
			preparedStmt.setString(2, passwordHash);
			preparedStmt.setString(3, name);
			preparedStmt.setString(4, phoneNumber);
			preparedStmt.setString(5, country);
			preparedStmt.setString(6, address);

			// execute the prepared statement
			result = preparedStmt.execute();
			result = true;

		}
		catch (SQLException e)
		{
			System.err.println(e);
		}
		finally
		{

			try
			{
				preparedStmt.close();
				connection.close();
			}
			catch (SQLException e)
			{
				
				System.err.println(e);
			}
		}

		return result;
	}

	// ------------------------------------------------------------
	// Updating customer base profile data in "customer" table
	// ------------------------------------------------------------
	public static Boolean UpdateCustomerData(String gender, String firstName, String middleName, String lastName, String emailAddress,
			String loginName, String loginPassword, String phoneNumber) throws IllegalAccessException, ClassNotFoundException, InstantiationException
	{

		Boolean result = false;
		String passwordHash = "";

		// If loginPassword is not empty then user set a new password,
		// re-hashing is needed
		if (loginPassword != "")
		{
			passwordHash = BCrypt.hashpw(loginPassword, BCrypt.gensalt(12));
		}
		// otherwise just query the current password hash
		else
		{
			String query = "SELECT password FROM customer WHERE email_address = '" + emailAddress + "'";
			passwordHash = DBUtil.getStringResult(query, "password");
		}

		Connection connection = null;
		PreparedStatement preparedStmt = null;

		try
		{
			connection = DBUtil.getConnection();

			// the mysql insert statement
			String query = " UPDATE customer SET gender=?, first_name=?, middle_name=?, last_name=?, "
					+ "email_address=?, login_name=?, password=?, phone_number=?" + "WHERE email_address = ?;";

			preparedStmt = connection.prepareStatement(query);

			// create the MySQL prepared statement

			preparedStmt.setString(1, gender);
			preparedStmt.setString(2, firstName);
			preparedStmt.setString(3, middleName);
			preparedStmt.setString(4, lastName);
			preparedStmt.setString(5, emailAddress);
			preparedStmt.setString(6, loginName);
			preparedStmt.setString(7, passwordHash);
			preparedStmt.setString(8, phoneNumber);
			preparedStmt.setString(9, emailAddress);

			// execute the prepared statement
			result = preparedStmt.execute();

		}
		catch (SQLException e)
		{
			System.err.println(e);
		}
		finally
		{

			try
			{
				preparedStmt.close();
				connection.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				System.err.println(e);
			}
		}

		return result;
	}

	// ------------------------------------------------------------
	// Updating shipment-related data in "customer" table
	// ------------------------------------------------------------
	public static Boolean UpdateShipmentData(String emailAddress, String address1, String address2, String city, String zipCode,
			String country) throws IllegalAccessException, InstantiationException, ClassNotFoundException
	{

		Boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStmt = null;

		try
		{
			connection = DBUtil.getConnection();

			// the mysql statement
			String query = " UPDATE customer SET address1=?, address2=?, city=?, zip_code=?, country=? WHERE email_address = ?;";

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement
			preparedStmt.setString(1, address1);
			preparedStmt.setString(2, address2);
			preparedStmt.setString(3, city);
			preparedStmt.setString(4, zipCode);
			preparedStmt.setString(5, country);
			preparedStmt.setString(6, emailAddress);

			// execute the preparedstatement
			result = preparedStmt.execute();

		}
		catch (SQLException e)
		{
			System.err.println(e);
		}
		finally
		{

			try
			{
				preparedStmt.close();
				connection.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				System.err.println(e);
			}
		}

		return result;
	}

	public static Boolean IsUserRegistered(String emailAddress) throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException
	{

		Boolean reply = false;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		connection = DBUtil.getConnection();
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}
		catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try
		{
			// Check if an orderId has a corresponding shipment table entry
			resultSet = statement.executeQuery("SELECT email_address FROM customer WHERE email_address = '" + emailAddress + "' ;");

			// If resultset is not empty, then we have this shipment entry
			if (resultSet.next())
			{
				reply = true;
			}

		}
		catch (SQLException e)
		{
			System.err.println(e);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e);
			}

		}
		return reply;

	}

	public static int getCustomerIDbyCustomerEmail(String emailAddress) throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException
	{

		int customerID = 0;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		connection = DBUtil.getConnection();
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}
		catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try
		{
			// Check if an orderId has a corresponding shipment table entry
			resultSet = statement.executeQuery("SELECT customer_id FROM customers WHERE email = '" + emailAddress + "' ;");
			while (resultSet.next())
			{
				customerID = resultSet.getInt("customer_id");
			}

		}
		catch (SQLException e)
		{
			System.err.println(e);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e);
			}

		}
		return customerID;

	}

}
