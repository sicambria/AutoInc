package com.regionalsupplier.model;

import com.regionalsupplier.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InventoryClass
{

	// ------------------------------------------------------------
	// Reserve Stock logic
	// ------------------------------------------------------------
	public static Boolean ReserveStock(int quantity, String partName, int orderId, String date)
	{
		int inventoryQuantity = InventoryClass.getAccessoryInventory(partName);
		int newQuantity = inventoryQuantity - quantity;

		System.out.println("---regionalsupplier ReserveStock---");
		System.out.println("Part name :" + partName);
		System.out.println("Regionalsupplier inventoryQuantity :" + inventoryQuantity);
		System.out.println("Quantity asked :" + quantity);

		if (inventoryQuantity > quantity)
		{
			System.out.println("regionalsupplier newQuantity :" + newQuantity);

			LogOrder(quantity, partName, orderId, date);
			UpdateInventory(partName, newQuantity);
			System.out.println("regionalsupplier OK");
			return true;
		}
		else
		{
			System.out.println("Not enough " + partName + " in regionalsupplier Inventory!");
			return false;
		}

	}

	// ------------------------------------------------------------
	// Log order to DB
	// ------------------------------------------------------------
	public static Boolean LogOrder(int quantity, String partName, int orderId, String date)
	{

		Boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStmt = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			String query = " INSERT into Log (quantity, part_name, order_id, date)" + " values (?, ?, ?, ? )";

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, quantity);
			preparedStmt.setString(2, partName);
			preparedStmt.setInt(3, orderId);
			preparedStmt.setString(4, date);

			// execute the prepared statement
			result = preparedStmt.execute();

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

		return result;
	}

	public static int getAccessoryInventory(String partName)
	{

		int result = 0;
		String query = " SELECT quantity FROM Accessories WHERE part_name =\"" + partName + "\";";
		result = DBUtil.getIntResult(query, "quantity");
		return result;
	}

	public static ArrayList<AccessoryObject> getAccessories()
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<AccessoryObject> accessoriesList = new ArrayList<AccessoryObject>();

		try
		{

			connection = DBUtil.getConnection();

			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery("SELECT * FROM Accessories ");
			while (resultSet.next())
			{

				int accessoryId = resultSet.getInt("accessory_id");
				int quantity = resultSet.getInt("quantity");
				String comments = resultSet.getString("comments");

				AccessoryObject accessory = new AccessoryObject(accessoryId, quantity, comments);

				accessoriesList.add(accessory);
			}

		}
		catch (SQLException e)
		{
			System.err.println(e);
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		return accessoriesList;

	}

	// ------------------------------------------------------------
	// Update Inventory in DB
	// ------------------------------------------------------------
	public static Boolean UpdateInventory(String partName, int quantity)
	{

		Boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStmtAccessories = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			String queryAccessories = " UPDATE Accessories SET quantity=? " + "WHERE part_name = ?;";

			preparedStmtAccessories = connection.prepareStatement(queryAccessories);

			// create the mysql prepared statement

			preparedStmtAccessories.setInt(1, quantity);
			preparedStmtAccessories.setString(2, partName);

			// execute the preparedstatement
			result = preparedStmtAccessories.execute();

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
				preparedStmtAccessories.close();
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
