package com.autoinc.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.autoinc.util.DBUtil;

public class CarClass
{
	public static void createSampleCarsinDB()
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try
		{

			connection = DBUtil.getFactoryConnection();

			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			statement.executeQuery("INSERT INTO `autoinc`.`CarsProduced` (`car_id`, `order_date`, `required_date`, `done_date`, "
					+ "`model`, `color`, `edition`, `status`, `comments`) VALUES (NULL, '2015-06-01 00:00:00', "
					+ "'2015-06-01 00:00:00', '2015-06-01 00:00:00', 'smart', 'red', 'comfort', 'ready', 'Smart cars rock!'); ");

			statement.executeQuery("INSERT INTO `autoinc`.`CarsProduced` (`car_id`, `order_date`, `required_date`, `done_date`, "
					+ "`model`, `color`, `edition`, `status`, `comments`) VALUES (NULL, '2015-06-01 00:00:00', "
					+ "'2015-06-01 00:00:00', '2015-06-01 00:00:00', 'sport', 'blue', 'comfort', 'ready', 'Sport style'); ");

			statement.executeQuery("INSERT INTO `autoinc`.`CarsProduced` (`car_id`, `order_date`, `required_date`, `done_date`, "
					+ "`model`, `color`, `edition`, `status`, `comments`) VALUES (NULL, '2015-06-01 00:00:00', "
					+ "'2015-06-01 00:00:00', '2015-06-01 00:00:00', 'family', 'white', 'standard', 'ready', 'Great car for a family!'); ");

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

	public static ArrayList<CarObject> getCars()
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		ArrayList<CarObject> carList = new ArrayList<CarObject>();

		try
		{

			connection = DBUtil.getFactoryConnection();

			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery("SELECT * FROM CarsProduced LIMIT 10 ");
			while (resultSet.next())
			{

				int carId = resultSet.getInt("car_id");
				String orderDate = resultSet.getString("order_date");
				String requiredDate = resultSet.getString("required_date");
				String doneDate = resultSet.getString("done_date");
				String model = resultSet.getString("model");
				String color = resultSet.getString("color");
				String edition = resultSet.getString("edition");
				String status = resultSet.getString("status");
				String comments = resultSet.getString("comments");

				CarObject car = new CarObject(carId, orderDate, requiredDate, doneDate, model, color, edition, status, comments);

				carList.add(car);
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

		return carList;
	}
	


}
