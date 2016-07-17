package com.autoinc.model;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.axis2.AxisFault;

import com.autoinc.auto_regional.RegionalSalesWSDLFileStub;
import com.autoinc.auto_regional.RegionalSalesWSDLFileStub.ReceiveCarsFromManufacture;
import com.autoinc.auto_regional.RegionalSalesWSDLFileStub.ReceiveCarsFromManufactureResponse;
import com.autoinc.util.DBUtil;
import com.autoinc.ws.inventory.InventoryWSDLFileStub;
import com.autoinc.ws.inventory.InventoryWSDLFileStub.AddParts;
import com.autoinc.ws.inventory.InventoryWSDLFileStub.AddPartsResponse;
import com.autoinc.ws.inventory.InventoryWSDLFileStub.GetParts;
import com.autoinc.ws.inventory.InventoryWSDLFileStub.GetPartsResponse;
import com.autoinc.ws.inventory.InventoryWSDLFileStub.SupplyParts;
import com.autoinc.ws.inventory.InventoryWSDLFileStub.SupplyPartsResponse;
import com.supplier.reresupplyws.REResupplyWSStub;
import com.supplier.reresupplyws.REResupplyWSStub.ReserveStockOperationResponse;
import com.transportinc.ordertransport.OrderTransportStub;
import com.transportinc.ordertransport.OrderTransportStub.OrderTransport;
import com.transportinc.ordertransport.OrderTransportStub.OrderTransportResponse;

import eu.autoinc.euresupplyws.EUResupplyWSStub;
import eu.autoinc.euresupplyws.EUResupplyWSStub.ReserveStockOperation;

public class InventoryClass
{
	// DEFINE extra chassis to RESUPPLY in addition to absolutely needed quantity
	static int extraChassis = 500;

	// DEFINE extra parts to RESUPPLY in addition to absolutely needed quantity
	static int extraParts = 1000;

	// ------------------------------------------------------------
	// Manufacture cars and insert them to CarsProduced DB TABLE
	// ------------------------------------------------------------
	public static Boolean manufactureCars(int quantity, String model, String color, String edition, int orderId)
	{
		// Calculate number of parts used for this batch
		ArrayList<String> itemsUsed = new ArrayList<String>();
		// Get list of used chassis and parts
		itemsUsed = getManufacturingResourceList(model, edition);

		logCarsProduced(quantity, model, color, edition, orderId);

		for (String partName : itemsUsed)
		{
			removeFromInventory(partName, quantity);
			System.out.println("removeFromInventory: " + quantity + " " + partName);
		}

		return true;
	}

	// ------------------------------------------------------------
	// Manufacture cars and insert them to CarsProduced DB TABLE
	// ------------------------------------------------------------
	public static Boolean notifyWarehouseOfCompletedManufacturing(int quantity, String model, String color, String edition, int orderId)
	{
		System.out.println("notifyWarehouseOfCompletedManufacturing started");

		Boolean result = false;

		try
		{
			RegionalSalesWSDLFileStub regionalSalesWSStub = new RegionalSalesWSDLFileStub();
			ReceiveCarsFromManufactureResponse rCFMR = new ReceiveCarsFromManufactureResponse();
			ReceiveCarsFromManufacture rCarsFromManufacture = new ReceiveCarsFromManufacture();
			rCarsFromManufacture.setModelColor(color);
			rCarsFromManufacture.setModelEdition(edition);
			rCarsFromManufacture.setModelName(model);
			rCarsFromManufacture.setOrderId(orderId);
			rCarsFromManufacture.setQuantity(quantity);
			rCFMR = regionalSalesWSStub.receiveCarsFromManufacture(rCarsFromManufacture);

			result = rCFMR.getResult();
		}
		catch (AxisFault e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("notifyWarehouseOfCompletedManufacturing END");
		return result;
	}

	// ------------------------------------------------------------
	// Manufacture cars and insert them to CarsProduced DB TABLE
	// ------------------------------------------------------------
	public static Boolean getSuppliesFromPartners(int quantity, String model, String color, String edition, int orderId)
	{
		String chassisType = getChassisType(model);
		Boolean chassisNeeded = false;
		Boolean partsNeeded = false;

		// Calculate number of parts used for this batch
		ArrayList<String> partsUsed = new ArrayList<String>();
		ArrayList<String> needResupplyPartsList = new ArrayList<String>();

		partsUsed = getManufacturingResourceList(model, edition);
		logSupplyRequests(orderId, model, edition, color, quantity);

		System.out.println("*** CHECKING PHASE ***");
		chassisNeeded = determineIfChassisResupplyIsNeeded(quantity, orderId, chassisType, true);
		partsNeeded = determineIfPartsResupplyIsNeeded(quantity, partsUsed, needResupplyPartsList, true);
		System.out.println("---> chassisNeeded: " + chassisNeeded);
		System.out.println("---> partsNeeded: " + partsNeeded + "\n");

		if (chassisNeeded)
		{
			System.out.println("*** RESUPPLY PHASE - Chassis ***");

			// Get EU resupply for Chassis
			Boolean euResupplyResult = false;
			euResupplyResult = getChassisResupply(chassisType, quantity + extraChassis, orderId);
			System.out.println("---> euResupplyResult: " + euResupplyResult);

			if (euResupplyResult)
			{
				// Add to AutoInc global Inventory
				addToInventory(chassisType, quantity + extraChassis);

				// Log Transport order
				orderSupplyTransport(orderId, "EU");
			}
		}

		if (partsNeeded)
		{
			System.out.println("*** RESUPPLY PHASE - Parts ***");
			Boolean regionalResupplyResult = false;
			Boolean regionalTransportNeeded = false;

			for (String partName : needResupplyPartsList)
			{
				// Get regional resupply for parts
				regionalResupplyResult = getPartsResupply(partName, quantity + extraParts, orderId);
				System.out.println("---> regionalResupplyResult: " + regionalResupplyResult);

				if (regionalResupplyResult)
				{
					// Add to AutoInc global Inventory
					addToInventory(partName, quantity + extraParts);
					regionalTransportNeeded = true;

					System.out.println("addToInventory: " + quantity + " " + partName);
				}
			}

			if (regionalTransportNeeded)
			{
				// Log Transport order
				orderSupplyTransport(orderId, "REGIONAL");
			}
		}

		System.out.println("\ngetSuppliesFromPartners ENDS, Checking if Resupplies are ready...\n");
		chassisNeeded = determineIfChassisResupplyIsNeeded(quantity, orderId, chassisType, true);
		partsNeeded = determineIfPartsResupplyIsNeeded(quantity, partsUsed, needResupplyPartsList, true);
		System.out.println("CN: " + chassisNeeded + " - PN: " + partsNeeded);

		if (!chassisNeeded && !partsNeeded)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private static Boolean determineIfPartsResupplyIsNeeded(int quantity, ArrayList<String> partsUsed,
			ArrayList<String> needResupplyPartsList, Boolean showDetails)
	{
		Boolean partsNeeded = false;

		// Check all parts if resupply is needed
		for (String partName : partsUsed)
		{
			int currentPartQuantity = getInventoryQuantityOfPart(partName);

			if (showDetails)
			{
				System.out.println("--- " + partName + " ---");
				System.out.println("Needed quantity of " + partName + " is: " + quantity);
				System.out.println("Current quantity of " + partName + " is: " + currentPartQuantity);
			}

			// Get regional resupply for parts
			if (currentPartQuantity < quantity)
			{
				// Resupply is needed if there is not enough to kick off manufacturing
				partsNeeded = true;
				needResupplyPartsList.add(partName);
				if (showDetails)
				{
					System.out.println(partName + " NEEDS RESUPPLY");
				}
			}
			else
			{
				// DONT'T CHANGE partsNeeded here, even if if one part is missing, partsNeeded MUST BE TRUE
				if (showDetails)
				{
					System.out.println(partName + " NO NEED TO RESUPPLY");
				}
			}
		}
		return partsNeeded;
	}

	private static Boolean determineIfChassisResupplyIsNeeded(int quantity, int orderId, String chassisType, Boolean showDetails)
	{
		Boolean chassisNeeded = false;
		int currentChassisQuantity = getInventoryQuantityOfPart(chassisType);

		if (showDetails)
		{
			System.out.println("Needed quantity of " + chassisType + " is: " + quantity);
			System.out.println("Current quantity of " + chassisType + " is: " + currentChassisQuantity);
		}

		// IF NEEDED - Get Chassis resupply from EU Supplier
		if (currentChassisQuantity < quantity)
		{
			chassisNeeded = true;
			if (showDetails)
			{
				System.out.println(chassisType + " NEEDS RESUPPLY");
			}
		}
		else
		{
			// DONT'T CHANGE chassisNeeded here, even if one chassis is missing, chassisNeeded MUST BE TRUE
			if (showDetails)
			{
				System.out.println(chassisType + " NO NEED TO RESUPPLY");
			}
		}
		return chassisNeeded;
	}

	// ------------------------------------------------------------
	// Cancel Resupply status
	// ------------------------------------------------------------
	public static Boolean changeResupplyStatus(int orderId, String resupplyStatus)
	{
		Boolean result = false;
		try
		{
			System.out.println("changeResupplyStatus called, new state for orderId: " + orderId + " is: " + resupplyStatus);
			result = updateResupplyOrder(orderId, resupplyStatus);
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// ------------------------------------------------------------
	// Determine the list of parts needed for a given car model and edition
	// ------------------------------------------------------------
	public static String getChassisType(String model)
	{
		System.out.println("getChassisType started");

		String chassis = "none";

		switch (model)
		{
			case "family":
				chassis = "family_chassis";
				break;

			case "sport":
				chassis = "sport_chassis";
				break;

			case "smart":
				chassis = "smart_chassis";
				break;
		}

		return chassis;
	}

	// ------------------------------------------------------------
	// Determine the list of parts needed for a given car model and edition
	// ------------------------------------------------------------
	public static ArrayList<String> getManufacturingResourceList(String model, String edition)
	{
		System.out.println("getParts started");

		ArrayList<String> partsList = new ArrayList<String>();

		switch (model)
		{
			case "family":
				partsList.add("family_chassis");
				partsList.add("family_parts");
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
	// Add parts to Inventory through Inventory WS
	// ------------------------------------------------------------
	public static Boolean addToInventory(String partName, int quantity)
	{
		System.out.println("addToInventory started");

		Boolean result = false;

		try
		{
			InventoryWSDLFileStub InventoryWSStub = new InventoryWSDLFileStub();
			AddPartsResponse aPR = new AddPartsResponse();
			AddParts aParts = new AddParts();
			aParts.setPartName(partName);
			aParts.setQuantity(quantity);
			aPR = InventoryWSStub.addParts(aParts);

			result = aPR.getResult();
		}
		catch (AxisFault e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("addToInventory END");
		return result;
	}

	// ------------------------------------------------------------
	// Resupply Chassis through EU WS
	// ------------------------------------------------------------
	public static Boolean getChassisResupply(String chassisType, int quantity, int orderId)
	{
		System.out.println("getChassisResupply started");

		Boolean result = false;

		try
		{
			EUResupplyWSStub euResupplyWSStub = new EUResupplyWSStub();
			ReserveStockOperation rSO = new ReserveStockOperation();
			eu.autoinc.euresupplyws.EUResupplyWSStub.ReserveStockOperationResponse rSOR = new eu.autoinc.euresupplyws.EUResupplyWSStub.ReserveStockOperationResponse();
			rSO.setChassisType(chassisType);
			rSO.setQuantity(quantity);
			rSO.setOrderId(orderId);
			rSOR = euResupplyWSStub.reserveStockOperation(rSO);

			result = rSOR.getAvailable();
		}
		catch (AxisFault e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("getChassisResupply END");

		return result;
	}

	// ------------------------------------------------------------
	// Resupply parts through Regional WS
	// ------------------------------------------------------------
	public static Boolean getPartsResupply(String partName, int quantity, int orderId)
	{
		System.out.println("getPartsResupply started");

		Boolean result = false;

		try
		{
			REResupplyWSStub euResupplyWSStub = new REResupplyWSStub();
			com.supplier.reresupplyws.REResupplyWSStub.ReserveStockOperation rSO = new com.supplier.reresupplyws.REResupplyWSStub.ReserveStockOperation();
			com.supplier.reresupplyws.REResupplyWSStub.ReserveStockOperationResponse sSOR = new com.supplier.reresupplyws.REResupplyWSStub.ReserveStockOperationResponse();
			rSO.setPartName(partName);
			rSO.setQuantity(quantity);
			rSO.setOrderId(orderId);
			sSOR = euResupplyWSStub.reserveStockOperation(rSO);

			result = sSOR.getAvailable();
		}
		catch (AxisFault e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("getPartsResupply END");
		return result;
	}

	// ------------------------------------------------------------
	// Resupply parts through Regional WS
	// ------------------------------------------------------------
	public static Boolean orderSupplyTransport(int orderId, String supplier)
	{
		System.out.println("orderSupplyTransport started - orderId: " + orderId + " - Supplier: " + supplier);

		Boolean result = false;

		try
		{
			OrderTransportStub orderTransportWSStub = new OrderTransportStub();
			OrderTransport oT = new OrderTransport();
			OrderTransportResponse oTR = new OrderTransportResponse();
			oT.setOrderId(orderId);
			oT.setSupplier(supplier);
			oTR = orderTransportWSStub.orderTransport(oT);

			result = oTR.getConfirmed();
		}
		catch (AxisFault e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("orderSupplyTransport END");
		return result;
	}

	// ------------------------------------------------------------
	// Remove parts from Inventory through Inventory WS
	// ------------------------------------------------------------
	public static Boolean removeFromInventory(String partName, int quantity)
	{
		System.out.println("removeFromInventory (supplyParts) started");

		Boolean result = false;

		try
		{
			InventoryWSDLFileStub InventoryWSStub = new InventoryWSDLFileStub();
			SupplyPartsResponse sPR = new SupplyPartsResponse();
			SupplyParts sParts = new SupplyParts();
			sParts.setPartName(partName);
			sParts.setQuantity(quantity);
			sPR = InventoryWSStub.supplyParts(sParts);

			result = sPR.getResult();
		}
		catch (AxisFault e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("removeFromInventory (supplyParts) END");
		return result;
	}

	// ------------------------------------------------------------
	// Get quantity of a part in MAIN Inventory through Inventory WS
	// ------------------------------------------------------------
	public static int getInventoryQuantityOfPart(String partName)
	{
		System.out.println("getInventoryQuantityOfPart started");

		int result = 0;

		try
		{
			InventoryWSDLFileStub InventoryWSStub = new InventoryWSDLFileStub();
			GetPartsResponse gPR = new GetPartsResponse();
			GetParts gParts = new GetParts();
			gParts.setPartName(partName);
			gPR = InventoryWSStub.getParts(gParts);
			result = gPR.getAvailableQuantity();
		}
		catch (AxisFault e)
		{
			e.printStackTrace();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		System.out.println("getInventoryQuantityOfPart END");
		return result;
	}

	// ------------------------------------------------------------
	// Log cars manufactured and insert them to CarsProduced DB TABLE
	// ------------------------------------------------------------
	public static Boolean logCarsProduced(int quantity, String model, String color, String edition, int orderId)
	{

		System.out.println("\nlogCarsProduced started\n");

		Boolean result = false;
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

		Connection connection = null;
		PreparedStatement preparedStmt = null;

		try
		{

			connection = DBUtil.getFactoryConnection();

			// the mysql insert statement
			String query = " insert into CarsProduced (quantity, model, color, edition, "
					+ "order_id, order_date, required_date, done_date, status)" + " values (?, ?, ?, ?, ? , ?, ?, ?, ?)";

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, quantity);
			preparedStmt.setString(2, model);
			preparedStmt.setString(3, color);
			preparedStmt.setString(4, edition);
			preparedStmt.setInt(5, orderId);
			preparedStmt.setString(6, timeStamp);
			preparedStmt.setString(7, timeStamp);
			preparedStmt.setString(8, timeStamp);
			preparedStmt.setString(9, "ready");

			// execute the prepared statement
			result = preparedStmt.execute();
			result = true;

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
		System.out.println("\nlogCarsProduced END\n");
		return result;
	}

	// ------------------------------------------------------------
	// Log cars manufactured and insert them to CarsProduced DB TABLE
	// ------------------------------------------------------------
	public static Boolean logSupplyRequests(int orderId, String model, String edition, String color, int quantity)
	{

		System.out.println("\n logSupplyRequests started\n");

		Boolean result = false;
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());

		Connection connection = null;
		PreparedStatement preparedStmt = null;

		try
		{

			connection = DBUtil.getFactoryConnection();

			// the mysql insert statement
			String query = " INSERT into ResupplyRequests (order_id, model, edition, color, " + "quantity, status, date)"
					+ " values (?, ?, ?, ?, ? , ?, ? )";

			preparedStmt = connection.prepareStatement(query);

			// create the mysql prepared statement

			preparedStmt.setInt(1, orderId);
			preparedStmt.setString(2, model);
			preparedStmt.setString(3, edition);
			preparedStmt.setString(4, color);
			preparedStmt.setInt(5, quantity);
			preparedStmt.setString(6, "pending");
			preparedStmt.setString(7, timeStamp);

			// execute the prepared statement
			result = preparedStmt.execute();
			result = true;

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
		System.out.println("\n logSupplyRequests END\n");
		return result;
	}

	// ------------------------------------------------------------
	// Update Resupply order status in DB
	// ------------------------------------------------------------
	public static Boolean updateResupplyOrder(int orderId, String status) throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException
	{

		Boolean result = false;

		Connection connection = null;
		Statement statement = null;

		connection = DBUtil.getFactoryConnection();
		statement = connection.createStatement();

		try
		{
			statement.executeUpdate("UPDATE ResupplyRequests SET status = \"" + status + "\" WHERE order_id = " + orderId);
			System.out.println("orderId: " + orderId + " updated to status: " + status);
		}
		catch (SQLException e)
		{
			System.err.println(e);
		}
		finally
		{
			statement.close();
			connection.close();
		}

		return result;
	}

}
