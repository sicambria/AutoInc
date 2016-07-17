package com.autoinc.regional.model;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.axis2.AxisFault;

import com.autoinc.DTO.Cars;
import com.autoinc.DTO.RegionalOrders;
import com.autoinc.regional.util.DBUtil;
import com.autoinc.www.autoshippingws.client.AutoShippingWSStub;

public class RegionalOrderControl {

	public static boolean CreateOrders(int orderId, int customerId, int modelId, int quantity, int shippingId, String customerName, String customerAddress, String customerCountry, String status)
	{
		
		Boolean result = false;

		Connection connection = null;
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			//String query = "INSERT INTO orders (order_id, customer_id, model_id, quantity, shipping_id, customer_name, customer_address, country, status) VALUES (?,?,?,?,?,?,?,?,?)";
			String query = "INSERT INTO regional_orders (order_id, customer_id, model_id, quantity, shipping_id, customer_name, customer_address, country, status) VALUES (?,?,?,?,?,?,?,?,?)";
			//String query = "UPDATE Cars SET quantity=10 WHERE model_id = 12;";
			

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, orderId);
			preparedStmt.setInt(2,customerId);
			preparedStmt.setInt(3, modelId);
			preparedStmt.setInt(4,quantity);
			preparedStmt.setInt(5, shippingId);
			preparedStmt.setString(6, customerName);
			preparedStmt.setString(7, customerAddress);
			preparedStmt.setString(8, customerCountry);
			preparedStmt.setString(9, status);
			
			// execute the preparedstatement
			int res = preparedStmt.executeUpdate();
			if (  res > 0) {
				result = true;
			}
			else result = false;
			System.out.println("update result" + result);
			//resultSet = preparedStmt.executeQuery();
			
			//reply = new RegionalOrders(rsOrderId, rsCustomerId, rsModelId, rsQuantity, rsShippingId, rsCustomerName, rsCustomerAddress, rsCustomerCountry, rsStatus);
			

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
	
	public static boolean updateStatus(int orderId, int customerId, String status){
		
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			//String query = "UPDATE regional_orders SET status='shipped' WHERE order_id=2 AND customer_id=2";
			String query = "UPDATE regional_orders SET status=? WHERE order_id=? AND customer_id=?";
			

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setString(1, status);
			preparedStmt.setInt(2,orderId);
			preparedStmt.setInt(3, customerId);
			
			// execute the preparedstatement
			int res = preparedStmt.executeUpdate();
			if (  res > 0) {
				result = true;
			}
			else result = false;

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
	
	public static RegionalOrders getRegionalOrder ( int orderId, int customerId ) {
		
		int rsOrderId = 0;
		int rsCustomerId = 0;
		int rsModelId = 0;
		int rsQuantity = 0;
		int rsShippingId = 0;
		String rsCustomerName = "";
		String rsCustomerAddress = "";
		String rsCustomerCountry = "";
		String rsStatus = "";
		RegionalOrders reply = new RegionalOrders(rsOrderId, rsCustomerId, rsModelId, rsQuantity, rsShippingId, rsCustomerName, rsCustomerAddress, rsCustomerCountry, rsStatus);
		
		Connection connection = null;
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			//String query = "INSERT INTO orders (order_id, customer_id, model_id, quantity, shipping_id, customer_name, customer_address, country, status) VALUES (?,?,?,?,?,?,?,?,?)";
			String query = "SELECT * FROM `regional_orders` WHERE order_id=? AND customer_id=?";
			//String query = "UPDATE Cars SET quantity=10 WHERE model_id = 12;";
			

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, orderId);
			preparedStmt.setInt(2,customerId);
			
			// execute the preparedstatement
			resultSet = preparedStmt.executeQuery();
			
			while (resultSet.next())
			{

				
				rsOrderId = resultSet.getInt("order_id");
				rsCustomerId = resultSet.getInt("customer_id");
				rsModelId = resultSet.getInt("model_id");
				rsQuantity = resultSet.getInt("quantity");
				rsShippingId = resultSet.getInt("shipping_id");
				rsCustomerName = resultSet.getString("customer_name");
				rsCustomerAddress = resultSet.getString("customer_address");
				rsCustomerCountry = resultSet.getString("country");
				rsStatus = resultSet.getString("status");

			}
			
			reply = new RegionalOrders(rsOrderId, rsCustomerId, rsModelId, rsQuantity, rsShippingId, rsCustomerName, rsCustomerAddress, rsCustomerCountry, rsStatus);
			

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
		
		return reply;
		
	}
	
public static RegionalOrders getRegionalOrderByOrderId ( int orderId ) {
		
		int rsOrderId = 0;
		int rsCustomerId = 0;
		int rsModelId = 0;
		int rsQuantity = 0;
		int rsShippingId = 0;
		String rsCustomerName = "";
		String rsCustomerAddress = "";
		String rsCustomerCountry = "";
		String rsStatus = "";
		RegionalOrders reply = new RegionalOrders(rsOrderId, rsCustomerId, rsModelId, rsQuantity, rsShippingId, rsCustomerName, rsCustomerAddress, rsCustomerCountry, rsStatus);
		
		Connection connection = null;
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;

		try
		{

			connection = DBUtil.getConnection();

			// the mysql insert statement
			//String query = "INSERT INTO orders (order_id, customer_id, model_id, quantity, shipping_id, customer_name, customer_address, country, status) VALUES (?,?,?,?,?,?,?,?,?)";
			String query = "SELECT * FROM `regional_orders` WHERE order_id=?";
			//String query = "UPDATE Cars SET quantity=10 WHERE model_id = 12;";
			

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, orderId);
			
			// execute the preparedstatement
			resultSet = preparedStmt.executeQuery();
			
			while (resultSet.next())
			{

				rsOrderId = resultSet.getInt("order_id");
				rsCustomerId = resultSet.getInt("customer_id");
				rsModelId = resultSet.getInt("model_id");
				rsQuantity = resultSet.getInt("quantity");
				rsShippingId = resultSet.getInt("shipping_id");
				rsCustomerName = resultSet.getString("customer_name");
				rsCustomerAddress = resultSet.getString("customer_address");
				rsCustomerCountry = resultSet.getString("country");
				rsStatus = resultSet.getString("status");

			}
			
			reply = new RegionalOrders(rsOrderId, rsCustomerId, rsModelId, rsQuantity, rsShippingId, rsCustomerName, rsCustomerAddress, rsCustomerCountry, rsStatus);
			

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
		
		return reply;
		
	}
	
	public static boolean checkRowExist ( int orderId ) {
		
		int rsOrderId = 0;
		int rsCustomerId = 0;
		int rsModelId = 0;
		int rsQuantity = 0;
		int rsShippingId = 0;
		String rsCustomerName = "";
		String rsCustomerAddress = "";
		String rsCustomerCountry = "";
		String rsStatus = "";
		RegionalOrders reply = new RegionalOrders(rsOrderId, rsCustomerId, rsModelId, rsQuantity, rsShippingId, rsCustomerName, rsCustomerAddress, rsCustomerCountry, rsStatus);
		
		Connection connection = null;
		PreparedStatement preparedStmt = null;
		ResultSet resultSet = null;
		
		boolean checkRowStatus = false;

		try
		{
			//System.out.println("into try");
			connection = DBUtil.getConnection();

			// the mysql insert statement
			String query = "SELECT * FROM `regional_orders` WHERE order_id=?";
			//String query = "UPDATE Cars SET quantity=10 WHERE model_id = 12;";
			

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, orderId);
			
			// execute the preparedstatement
			resultSet = preparedStmt.executeQuery();
			boolean testRow = resultSet.next();
			//System.out.println("checking testrow " + testRow );
			
			if ( testRow ) {
				checkRowStatus = testRow;
			}
			else checkRowStatus = testRow;

			
			reply = new RegionalOrders(rsOrderId, rsCustomerId, rsModelId, rsQuantity, rsShippingId, rsCustomerName, rsCustomerAddress, rsCustomerCountry, rsStatus);
			

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
		
		return checkRowStatus;
		
	}
	
	/*
	 * get the status of an order through shipping WS
	 */
	
	public static Boolean getOrderStatus( int orderId, int shippingId )
	{
		System.out.println("getOrderStatus started");

		Boolean result = true;

		try
		{
			AutoShippingWSStub aStub = new AutoShippingWSStub();
			AutoShippingWSStub.GetStatus gso = new AutoShippingWSStub.GetStatus();
			gso.setOrderId(orderId);
			gso.setShippingId(shippingId);
			aStub.getStatus(gso);
		}
		catch (AxisFault e)
		{
			e.printStackTrace();
			result = false;
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			result = false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			result = false;
		}

		return result;
	} 
	
	/*
	 * do shipping through the shipping WS
	 */
	
	public static Boolean performShipping( int orderId, int quantity, String customerName, String customerAddress, String customerCountry, String modelName, String modelEdition, String modelColor )
	{
		System.out.println("performShipping started");

		Boolean result = true;

		try
		{
			AutoShippingWSStub aStub = new AutoShippingWSStub();
			AutoShippingWSStub.DoShipping dso = new AutoShippingWSStub.DoShipping(); 
			dso.setOrderId(orderId);
			dso.setQuantity(quantity);
			dso.setCustomerAddress(customerAddress);
			dso.setCustomerCountry(customerCountry);
			dso.setCustomerName(customerName);
			dso.setModelColor(modelColor);
			dso.setModelEdition(modelEdition);
			dso.setModelName(modelName);
			aStub.doShipping(dso);
		}
		catch (AxisFault e)
		{
			e.printStackTrace();
			result = false;
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			result = false;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			result = false;
		}

		return result;
	} 
	
	public static void main(String [] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		
		RegionalOrders orders = getRegionalOrder(1, 1);
		//boolean update = updateStatus(1, 1, "order updated");
		
		//boolean tr = checkRowExist(1);
		System.out.println(orders.getShippingId());
	}
	
}
