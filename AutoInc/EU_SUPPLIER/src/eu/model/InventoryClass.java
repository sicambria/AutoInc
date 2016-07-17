package eu.model;

import eu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventoryClass
{

	// ------------------------------------------------------------
	// Reserve Stock logic
	// ------------------------------------------------------------
	public static Boolean ReserveStock(int quantity, String chassisType, int orderId, String date)
	{
		int inventoryQuantity = InventoryClass.GetInventory(chassisType);
		int newQuantity = inventoryQuantity - quantity;

		System.out.println("---EU ReserveStock---");
		System.out.println("Chassis type :" + chassisType);
		System.out.println("EU Inventory quantity :" + inventoryQuantity);
		System.out.println("quantity asked :" + quantity);

		if (inventoryQuantity > quantity)
		{
			System.out.println("EU newQuantity :" + newQuantity);

			LogOrder(quantity, chassisType, orderId, date);
			UpdateChassisInventory(chassisType, newQuantity);
			System.out.println("EU OK");
			return true;
		}
		else
		{
			System.out.println("Not enough Chassis in EU Inventory!");
			return false;
		}

	}

	// ------------------------------------------------------------
	// Log order to DB
	// ------------------------------------------------------------
	public static Boolean LogOrder(int quantity, String chassisType, int orderId, String date)
	{

		Boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStmt = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			String query = " INSERT INTO Log (quantity, chassis_name, order_id, date) " + " values (?, ?, ?, ? )";

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, quantity);
			preparedStmt.setString(2, chassisType);
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

	public static int GetInventory(String chassisType)
	{
		int result = 0;
		String query = " SELECT quantity FROM Chassis WHERE chassis_name=\"" + chassisType + "\";";
		result = DBUtil.getIntResult(query, "quantity");
		return result;
	}

	// ------------------------------------------------------------
	// Update Inventory in DB - Chassis TABLE
	// ------------------------------------------------------------
	public static Boolean UpdateChassisInventory(String chassisType, int quantity)
	{

		Boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStmtChassis = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			String queryUpdateChassis = " UPDATE Chassis SET quantity=? " + "WHERE chassis_name=?;";

			preparedStmtChassis = connection.prepareStatement(queryUpdateChassis);

			// create the mysql prepared statement

			preparedStmtChassis.setInt(1, quantity);
			preparedStmtChassis.setString(2, chassisType);

			// execute the preparedstatement
			result = preparedStmtChassis.execute();

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
				preparedStmtChassis.close();
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
