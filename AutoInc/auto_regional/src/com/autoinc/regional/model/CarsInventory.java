package com.autoinc.regional.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.autoinc.DTO.Cars;
import com.autoinc.regional.util.*;


public class CarsInventory {

	public static int GetQuantity(int model)
	{

		int result = 0;
		String query = " SELECT quantity FROM cars WHERE model_id ="+ model +";";
		result = DBUtil.getIntResult(query, "quantity");
		return result;
	}
	
	public static int GetReserved(int model)
	{

		int result = 0;
		String query = " SELECT reserved FROM cars WHERE model_id ="+ model +";";
		result = DBUtil.getIntResult(query, "reserved");
		return result;
	}
	
	public static int GetModelId(String model, String edition, String country, String color)
	{

		int result = 0;
		String query = " SELECT model_id FROM `cars` WHERE model='" + model + "' AND color='" + color + "' AND country='" + country + "' AND edition='" + edition + "'";
		result = DBUtil.getIntResult(query, "model_id");
		//System.out.println(result + "result 3");
		return result;
	}
	
	public static Cars getCar (int model_id) throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		int modelId = 0;
		String modelName = "";
		String edition = "";
		String color = "";
		String country = "";
		int quantity = 0;
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try{
			connection = DBUtil.getConnection();
			
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			resultSet = statement.executeQuery("SELECT * FROM cars WHERE model_id= '" + model_id + "'");
			while (resultSet.next())
			{

				modelId = resultSet.getInt("model_id");
				modelName = resultSet.getString("model");
				edition = resultSet.getString("edition");
				color = resultSet.getString("color");
				quantity = resultSet.getInt("quantity");
				country = resultSet.getString("country");

			}
					
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		finally{
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
		
		Cars reply = new Cars(modelId, modelName, edition, country, color, quantity);
		
		return reply;
	}
	
	public static Boolean UpdateCars(int model_id, int quantity, int reserved)
	{

		Boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStmt = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			String query = "UPDATE cars SET quantity=?,reserved=? " + "WHERE model_id = ?;";
			//String query = "UPDATE Cars SET quantity=10 WHERE model_id = 12;";
			

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, quantity);
			preparedStmt.setInt(2,reserved);
			preparedStmt.setInt(3, model_id);

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
			// TODO Auto-generated catch block
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
	
	public static void main(String [] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		
		Cars car = getCar(1);
		System.out.println(car.getCountry());
	}
}
