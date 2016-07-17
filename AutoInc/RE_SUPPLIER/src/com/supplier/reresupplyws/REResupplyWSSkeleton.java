/**
 * REResupplyWSSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.supplier.reresupplyws;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.regionalsupplier.model.*;

/**
 * REResupplyWSSkeleton java skeleton for the axisService
 */
public class REResupplyWSSkeleton implements REResupplyWSSkeletonInterface
{

	/**
	 * Auto generated method signature
	 * 
	 * @param reserveStockOperation0
	 * @return reserveStockOperationResponse1
	 */

	public com.supplier.reresupplyws.ReserveStockOperationResponse reserveStockOperation(
			com.supplier.reresupplyws.ReserveStockOperation reserveStockOperation0)
	{
		ReserveStockOperationResponse RSO = new ReserveStockOperationResponse();

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

		boolean available = InventoryClass.ReserveStock(
				reserveStockOperation0.localQuantity,
				reserveStockOperation0.localPartName,
				reserveStockOperation0.localOrderId,
				timeStamp);

		RSO.setAvailable(available);
		RSO.setDeliveryDate(timeStamp);

		return RSO;

	}
}
