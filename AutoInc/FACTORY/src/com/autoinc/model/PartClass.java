package com.autoinc.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.autoinc.util.DBUtil;

public class PartClass
{

	public static ArrayList<PartObject> getPartsInventoryNumbers()
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<PartObject> partInventoryList = new ArrayList<PartObject>();

		try
		{

			connection = DBUtil.getWarehouseConnection();
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = statement.executeQuery("SELECT * FROM parts ");
			while (resultSet.next())
			{

				int partId = resultSet.getInt("part_id");
				String partName = resultSet.getString("part_name");
				int quantity = resultSet.getInt("quantity");

				PartObject partObj = new PartObject(partId, partName, quantity);

				partInventoryList.add(partObj);
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

		return partInventoryList;
	}

}
