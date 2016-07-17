package com.autoinc.buffalo.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class OrderClass {
	
//This class is used to create an order
	
	public static int createOrder(int customerId, String model,
			String edition, String color, int quantity, int amount,
			String status) throws SQLException{
		
		Connection connection = DBUtil.getConnection();
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date( date.getTime() );
		
		String query = "INSERT into orders (customer_id, model, "
				+ "edition, color, quantity, amount, status, order_date) values(?,?,?,?,?,?,?,?)";
		
		//create the prepared statement
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, customerId);
		preparedStatement.setString(2, model);
		preparedStatement.setString(3, edition);
		preparedStatement.setString(4, color);
		preparedStatement.setInt(5, quantity);
		preparedStatement.setInt(6, amount);
		preparedStatement.setString(7, status);
		preparedStatement.setDate(8, sqlDate);
		
		preparedStatement.execute();
		
		Statement statement = null;
		ResultSet resultSet = null;
		int orderId = 0;
		
		statement = connection.createStatement();
		resultSet = statement.executeQuery("select last_insert_id() as last_id from orders");
		
		while(resultSet.next()){
			orderId = Integer.parseInt(resultSet.getString("last_id"));
		}
		
		
		try
		{
			preparedStatement.close();
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return orderId;
	}

//this class is used to get the order list
	
	public static ArrayList<PostOrderObject> getOrdersByCustomerId(int customerId){
		
		ArrayList<PostOrderObject> postOrderList = new ArrayList<PostOrderObject>();
		
		Connection connection = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `orders` WHERE `customer_id` = ' "+customerId+"';");
			
			while(resultSet.next()){
				
				int orderId = resultSet.getInt("orders_id");
				String model = resultSet.getString("model");
				String edition = resultSet.getString("edition");
				String color = resultSet.getString("color");
				int quantity = resultSet.getInt("quantity");
				int amount = resultSet.getInt("amount");
				String status = resultSet.getString("status");
				Date sqlDate = resultSet.getDate("order_date");
				String deliveryDate  = resultSet.getString("delivery_date");
				int transactionId = resultSet.getInt("transaction_id");
				String payment = resultSet.getString("payment");
				String warehouse  = resultSet.getString("warehouse");
				String manufacturing  = resultSet.getString("manufacturing");
				String shippingStatus = resultSet.getString("shipping_status"); 
				
				PostOrderObject postOrderObject = new PostOrderObject(orderId, customerId, model, edition, color, quantity, amount, status, sqlDate, deliveryDate, transactionId, payment, warehouse, manufacturing, shippingStatus);
				
				postOrderList.add(postOrderObject);
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		
		return postOrderList;
		
	}
	
	public static OrderObject getOrdersObjByOrderId(int orderId){
		
		
		Connection connection = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		OrderObject orderObject = new OrderObject(0, 0, null, null, null, 0, 0, null, null);
				
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM `orders` WHERE `orders_id` = ' "+orderId+"';");
			
			while(resultSet.next()){
				
				int customerId = resultSet.getInt("customer_id");
				String model = resultSet.getString("model");
				String edition = resultSet.getString("edition");
				String color = resultSet.getString("color");
				int quantity = resultSet.getInt("quantity");
				int amount = resultSet.getInt("amount");
				String status = resultSet.getString("status");
				Date sqlDate = resultSet.getDate("order_date");
			
				
				orderObject = new OrderObject(orderId, customerId, model, edition, color, quantity, amount, status, sqlDate);
				
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
		
		return orderObject;
		
	}
	
	public static void updatePostOrderInfo(int orderId, int transactionId, String deliveryDate, boolean payment, boolean warehouse, boolean manufacturing, String shippingStatus) throws SQLException{
		
		Connection connection = DBUtil.getConnection();
		
		String query = "UPDATE `orders` SET `transaction_id`='"+transactionId+"', `delivery_date`='"+deliveryDate+"', `payment`='"+payment+"', `warehouse`='"+warehouse+"', `manufacturing`='"+manufacturing+"', `shipping_status`='"+shippingStatus+"' WHERE `orders_id` = "+orderId+";";
		
		Statement statement = null;
		
		statement = connection.createStatement();
		
		statement.executeUpdate(query);
		
		try
		{
			statement.close();
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static void updateStatus(int orderId, String status) throws SQLException{
		
		Connection connection = DBUtil.getConnection();
		
		String query = "UPDATE `orders` SET `status`='"+status+"' WHERE `orders_id` = "+orderId+";";
		
		Statement statement = null;
		
		statement = connection.createStatement();
		
		statement.executeUpdate(query);
		
		try
		{
			statement.close();
			connection.close();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
}
