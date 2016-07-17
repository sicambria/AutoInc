package com.autoinc.regional.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.autoinc.regional.util.DBUtil;



public class Inventory {

	public static int GetQuantity(int part)
	{

		int result = 0;
		String query = " SELECT quantity FROM parts WHERE part_id ="+ part +"; ";
		//String query = " SELECT quantity FROM parts WHERE part_id =10;";
		result = DBUtil.getIntResult(query, "quantity");
		//System.out.println(result + "printing result");
		return result;
	}
	
	public static int GetPartsId(String modelName)
	{

		int result = 0;
		String query = " SELECT part_id FROM parts WHERE part_name='"+ modelName + "'";
		result = DBUtil.getIntResult(query, "part_id");
		return result;
	}

	public static ArrayList<String> getParts(String model, String edition)
	{
		ArrayList<String> partsList = new ArrayList<String>();

		switch (model)
		{
			case "family":
				partsList.add("normal_chassis");
				partsList.add("normal_parts");
				break;

			case "sport":
				partsList.add("sport_chassis");
				partsList.add("sport_parts");
				break;

			case "smart":
				partsList.add("smart_chassis");
				partsList.add("smart_parts");
				break;
		}

		switch (edition)
		{
			case "standard":
				partsList.add("radio");

				if (model.equals("smart"))
				{
					partsList.add("regenerative_breaks");
				}

				break;

			case "comfort":
				partsList.add("radio");
				partsList.add("ac");
				if (model.equals("sport"))
				{
					partsList.add("sunroof");
				}
				if (model.equals("smart"))
				{
					partsList.add("turbo_electric_charger");
				}

				break;

		}

		return partsList;
	}

	// ------------------------------------------------------------
	// Update Parts Inventory in DB
	// ------------------------------------------------------------
	public static Boolean UpdateInventory(int partId, int quantity)
	{

		Boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStmt = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			String query = " UPDATE parts SET quantity=? " + "WHERE part_id = ?;";
			//String query = " UPDATE parts SET quantity=334 WHERE part_id = 5";
			

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, quantity);
			preparedStmt.setInt(2, partId);

			// execute the preparedstatement
			int updateQuery = preparedStmt.executeUpdate();
			if (  updateQuery > 0) {
				result = true;
			}
			else result = false;
			//System.out.println("update result" + result);

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

	
}
