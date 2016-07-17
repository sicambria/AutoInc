/**
 * EUResupplyWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package eu.autoinc.euresupplyws;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import eu.model.InventoryClass;

/**
 * EUResupplyWSSkeleton java skeleton for the axisService
 */
public class EUResupplyWSSkeleton implements EUResupplyWSSkeletonInterface
{

	/**
	 * Auto generated method signature
	 * 
	 * @param reserveStockOperation0
	 * @return reserveStockOperationResponse1
	 */

	public eu.autoinc.euresupplyws.ReserveStockOperationResponse reserveStockOperation(
			eu.autoinc.euresupplyws.ReserveStockOperation reserveStockOperation0)
	{
		ReserveStockOperationResponse RSO = new ReserveStockOperationResponse();

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

		boolean available = InventoryClass.ReserveStock(
				reserveStockOperation0.localQuantity,
				reserveStockOperation0.localChassisType,
				reserveStockOperation0.localOrderId,
				timeStamp);

		RSO.setAvailable(available);
		RSO.setDeliveryDate(timeStamp);

		return RSO;

	}
}
