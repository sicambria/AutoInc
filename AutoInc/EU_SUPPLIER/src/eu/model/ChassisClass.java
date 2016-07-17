package eu.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import eu.util.DBUtil;

public class ChassisClass
{
	public static void createSampleChassisInDB()
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{

			connection = DBUtil.getConnection();

			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			statement.executeQuery("INSERT INTO `autoinc`.`chassisProduced` (`chassis_id`, `order_date`, `required_date`, `done_date`, "
					+ "`model`, `color`, `edition`, `status`, `comments`) VALUES (NULL, '2015-06-01 00:00:00', "
					+ "'2015-06-01 00:00:00', '2015-06-01 00:00:00', 'smart', 'red', 'comfort', 'ready', 'Smart chassiss rock!'); ");

			statement.executeQuery("INSERT INTO `autoinc`.`chassisProduced` (`chassis_id`, `order_date`, `required_date`, `done_date`, "
					+ "`model`, `color`, `edition`, `status`, `comments`) VALUES (NULL, '2015-06-01 00:00:00', "
					+ "'2015-06-01 00:00:00', '2015-06-01 00:00:00', 'sport', 'blue', 'comfort', 'ready', 'Sport style'); ");

			statement
					.executeQuery("INSERT INTO `autoinc`.`chassisProduced` (`chassis_id`, `order_date`, `required_date`, `done_date`, "
							+ "`model`, `color`, `edition`, `status`, `comments`) VALUES (NULL, '2015-06-01 00:00:00', "
							+ "'2015-06-01 00:00:00', '2015-06-01 00:00:00', 'family', 'white', 'standard', 'ready', 'Great chassis for a family!'); ");

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

	}

	public static ArrayList<ChassisObject> getChassis()
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<ChassisObject> chassisList = new ArrayList<ChassisObject>();

		try
		{

			connection = DBUtil.getConnection();

			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery("SELECT * FROM Chassis ");
			while (resultSet.next())
			{

				int chassisId = resultSet.getInt("chassis_id");
				int quantity = resultSet.getInt("quantity");
				String comments = resultSet.getString("comments");

				ChassisObject chassis = new ChassisObject(chassisId, quantity, comments);
				chassisList.add(chassis);
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

		return chassisList;
	}

}
