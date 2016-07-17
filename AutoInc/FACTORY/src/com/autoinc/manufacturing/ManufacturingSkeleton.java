/**
 * ManufacturingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.autoinc.manufacturing;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.autoinc.model.InventoryClass;

/**
 * ManufacturingSkeleton java skeleton for the axisService
 */
public class ManufacturingSkeleton implements ManufacturingSkeletonInterface
{

	/**
	 * Auto generated method signature
	 * 
	 * @param manufactureOperation0
	 * @return manufactureOperationResponse1
	 */

	public com.autoinc.manufacturing.ManufactureOperationResponse manufactureOperation(
			com.autoinc.manufacturing.ManufactureOperation manufactureOperation0)
	{
		ManufactureOperationResponse mOR = new ManufactureOperationResponse();

		int quantity = manufactureOperation0.localQuantity;
		int orderId = manufactureOperation0.localOrderId;
		String model = manufactureOperation0.getModel();
		String color = manufactureOperation0.getColor();
		String edition = manufactureOperation0.getEdition();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

		if (InventoryClass.manufactureCars(quantity, model, color, edition, orderId))
		{
			InventoryClass.notifyWarehouseOfCompletedManufacturing(quantity, model, color, edition, orderId);

			mOR.localCompleted = true;
			mOR.localDeliveryDate = timeStamp;
			return mOR;

		}
		else
		{
			mOR.localCompleted = false;
			mOR.localDeliveryDate = "";
			return mOR;
		}
	}

}
