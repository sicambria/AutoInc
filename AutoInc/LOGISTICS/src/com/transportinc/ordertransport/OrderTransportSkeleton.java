/**
 * OrderTransportSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.transportinc.ordertransport;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.transportinc.model.TransportClass;

/**
 * OrderTransportSkeleton java skeleton for the axisService
 */
public class OrderTransportSkeleton implements OrderTransportSkeletonInterface
{

	/**
	 * Auto generated method signature
	 * 
	 * @param cancelOrderTransport0
	 * @return cancelOrderTransportResponse1
	 */

	public com.transportinc.ordertransport.CancelOrderTransportResponse cancelOrderTransport(
			com.transportinc.ordertransport.CancelOrderTransport cancelOrderTransport0)
	{
		// TODO : fill this with the necessary business logic
		throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#cancelOrderTransport");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param orderTransport2
	 * @return orderTransportResponse3
	 */

	public com.transportinc.ordertransport.OrderTransportResponse orderTransport(
			com.transportinc.ordertransport.OrderTransport orderTransport2)
	{
		OrderTransportResponse OTR = new OrderTransportResponse();
		int orderId = orderTransport2.localOrderId;
		String supplier = orderTransport2.localSupplier;

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		boolean confirmed = TransportClass.LogTransport(orderId, supplier, timeStamp);

		OTR.setConfirmed(confirmed);
		OTR.setDeliveryDate(timeStamp);

		return OTR;
	}

}
