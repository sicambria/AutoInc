package com.autoinc.buffalo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaymentInformationClass {
	
//This class is used to enter or update information of bank details, if successful, this function results true
	
	public static boolean enterPaymentInformation(int customerId, String bank, String accountNumber) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		//this is returned at the end
		boolean result = false;
		
		Connection connection = DBUtil.getConnection();
		String query = "INSERT into payment_information (customer_id, bank, account_number) values(?,?,?);";
		
		//create the prepared statement
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, customerId);
		preparedStatement.setString(2, bank);
		preparedStatement.setString(3, accountNumber);
		
		// execute the prepared statement
		try {
			preparedStatement.execute();
		} catch (Exception e) {
			result = true;
		}
		finally
		{

			try
			{
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException e)
			{
				System.err.println(e);
			}

		}
		
		return result;
		
	}
	
//this method can be used to determine whether the user gave account as input
	public static boolean paymentInformationGiven(int customerId){
		
		boolean reply = false;
		
		Connection connection = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
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
			resultSet = statement.executeQuery("SELECT customer_id FROM payment_information WHERE customer_id = '" + customerId + "' ;");

			// If result set is not empty, then we have this shipment entry
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
	
	//this class is used to get payment information
	public static PaymentInformationObject getPaymentInformation(int customerId){
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String bank = null;
		String accountNumber = null;
		
		
		
		
		try
		{

			connection = DBUtil.getConnection();

			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery("SELECT * FROM payment_information WHERE customer_id= '" + customerId + "'");
			while (resultSet.next())
			{

				customerId = Integer.parseInt(resultSet.getString("customer_id"));
				bank = resultSet.getString("bank");
				accountNumber = resultSet.getString("account_number");

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
			}
		}

		PaymentInformationObject paymentInformationObject = new PaymentInformationObject(customerId, bank, accountNumber);
		
		return	paymentInformationObject;
	}

}
