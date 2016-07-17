package com.transportinc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.transportinc.util.DBUtil;

public class TransportClass
{

	// ------------------------------------------------------------
	// Log Supply Transport to DB
	// ------------------------------------------------------------
	public static Boolean LogTransport(int orderId, String supplier, String date)
	{

		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStmt = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			String query = " INSERT into Log (order_id, supplier, date)" + " values (?, ?, ? )";

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, orderId);
			preparedStmt.setString(2, supplier);
			preparedStmt.setString(3, date);

			// execute the prepared statement
			result = preparedStmt.executeUpdate();
			System.out.println("LogTransport " + orderId + supplier + date);

		}
		catch (SQLException e)
		{
			System.err.println(e);
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
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

		System.out.println(result);

		if (result == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
