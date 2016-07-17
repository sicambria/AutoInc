/**
 * ResupplySkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.autoinc.resupply;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.autoinc.model.InventoryClass;

/**
 * ResupplySkeleton java skeleton for the axisService
 */
public class ResupplySkeleton implements ResupplySkeletonInterface
{

	/**
	 * Auto generated method signature
	 * 
	 * @param cancelResupplyOperation0
	 * @return cancelResupplyOperationResponse1
	 */

	public com.autoinc.resupply.CancelResupplyOperationResponse cancelResupplyOperation(
			com.autoinc.resupply.CancelResupplyOperation cancelResupplyOperation0)
	{
		CancelResupplyOperationResponse CRO = new CancelResupplyOperationResponse();
		int orderId = cancelResupplyOperation0.getOrderId();

		InventoryClass.changeResupplyStatus(orderId, "cancelled");

		return CRO;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param resupplyOperation2
	 * @return resupplyOperationResponse3
	 */

	public com.autoinc.resupply.ResupplyOperationResponse resupplyOperation(com.autoinc.resupply.ResupplyOperation resupplyOperation2)
	{
		ResupplyOperationResponse rOR = new ResupplyOperationResponse();

		int quantity = resupplyOperation2.localQuantity;
		int orderId = resupplyOperation2.localOrderId;
		String model = resupplyOperation2.getModel();
		String color = resupplyOperation2.getColor();
		String edition = resupplyOperation2.getEdition();
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

		if (InventoryClass.getSuppliesFromPartners(quantity, model, color, edition, orderId))
		{
			System.out.println("getSuppliesFromPartners TRUE");
			InventoryClass.changeResupplyStatus(orderId, "completed");
			rOR.localSuppliesReady = true;
			rOR.localDeliveryDate = timeStamp;
			return rOR;

		}
		else
		{
			System.out.println("getSuppliesFromPartners FALSE");
			InventoryClass.changeResupplyStatus(orderId, "failed");
			rOR.localSuppliesReady = false;
			rOR.localDeliveryDate = "";
			return rOR;
		}
	}

}
