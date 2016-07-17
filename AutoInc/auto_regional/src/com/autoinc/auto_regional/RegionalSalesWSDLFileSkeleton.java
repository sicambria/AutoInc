
/**
 * RegionalSalesWSDLFileSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package com.autoinc.auto_regional;

import com.autoinc.DTO.RegionalOrders;
import com.autoinc.regional.model.CarsInventory;
import com.autoinc.regional.model.RegionalOrderControl;
    /**
     *  RegionalSalesWSDLFileSkeleton java skeleton for the axisService
     */
    public class RegionalSalesWSDLFileSkeleton implements RegionalSalesWSDLFileSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param receiveOrder0 
             * @return receiveOrderResponse1 
         */
        
    	public com.autoinc.auto_regional.ReceiveOrderResponse receiveOrder(
    			com.autoinc.auto_regional.ReceiveOrder receiveOrder0) {
    		ReceiveOrderResponse ror = new ReceiveOrderResponse();
    		ror.setResult(false);

    		int rcvdOrderId = receiveOrder0.getOrderId();
    		int rcvdCustomerId = receiveOrder0.getCustomerId();
    		int rcvdQuantity = receiveOrder0.getQuantity();
    		String rcvdModelName = receiveOrder0.getModelName();
    		String rcvdEdition = receiveOrder0.getModelEdition();
    		String rcvdCountry = receiveOrder0.getCustomer_country();
    		String rcvdColor = receiveOrder0.getModelColor();

    		// To update shipping status
    		String shippingStatus = "ready to ship";

    		// Check the orderID is valid or not
    		boolean checkRow = RegionalOrderControl.checkRowExist(rcvdOrderId);

    		if (checkRow) {

    			// get model if from cars table
    			int getModelId = CarsInventory.GetModelId(rcvdModelName,
    					rcvdEdition, rcvdCountry, rcvdColor);

    			RegionalOrders regOrder = RegionalOrderControl.getRegionalOrder(
    					rcvdOrderId, rcvdCustomerId);
    			// int getModelId = regOrder.getModelId();
    			int orderQuantity = regOrder.getQuantity();

    			// System.out.println(getModelId + " getting model id");
    			int currentQuantity = CarsInventory.GetQuantity(getModelId);

    			/*
    			 * Calculating the new reserved for that model id
    			 */
    			int currentReserved = CarsInventory.GetReserved(getModelId);
    			// Accepting order when the current quantity is more than received
    			// quantity
    			if (currentReserved >= rcvdQuantity && rcvdQuantity != 0) {
    				int newSuccesfulReserved = currentReserved - rcvdQuantity;
    				boolean result = CarsInventory.UpdateCars(getModelId, currentQuantity, newSuccesfulReserved);
    				RegionalOrderControl.updateStatus(rcvdOrderId, rcvdCustomerId,
    						shippingStatus);
    				if (result) {
    					ror.setResult(true);
    					ror.setOrderId(rcvdOrderId);
    					ror.setShipping_status(shippingStatus);
    				} else {
    					ror.setResult(false);
    					ror.setOrderId(rcvdOrderId);
    					ror.setShipping_status("Unlikely Error!");
    				}
    			} else {
    				ror.setResult(false);
    				ror.setOrderId(rcvdOrderId);
    				ror.setShipping_status("Already Shipped");
    			}
    			
    		}

    		else {
    			ror.setResult(false);
    			ror.setShipping_status("OrderId invalid");
    		}

    		return ror;
    	}
         
        /**
         * Auto generated method signature
         * 
                                     * @param cancelOrder2 
             * @return cancelOrderResponse3 
         */
        
                 public com.autoinc.auto_regional.CancelOrderResponse cancelOrder
                  (
                  com.autoinc.auto_regional.CancelOrder cancelOrder2
                  )
            {
                CancelOrderResponse cor = new CancelOrderResponse();
                cor.setResult(false);
                
                int rcvdOrderId = cancelOrder2.getOrderId();
                int rcvdCustomerId = cancelOrder2.getCustomerId();
                
        		// Check the orderID is valid or not
        		boolean checkRow = RegionalOrderControl.checkRowExist(rcvdOrderId);
        		
        		if ( checkRow ) {
        		
            		String shippingStatus2 = "canceled";
        			RegionalOrders regOrder = RegionalOrderControl.getRegionalOrder(
        					rcvdOrderId, rcvdCustomerId);
        			int getModelId = regOrder.getModelId();
        			int orderQuantity = regOrder.getQuantity();
        			int shippingId = regOrder.getShippingId();
        			System.out.println(" print shipping id " + shippingId);
        			String currentStatus = regOrder.getStatus();

        			// System.out.println(getModelId + " getting model id");
        			int currentQuantity = CarsInventory.GetQuantity(getModelId);

        			/*
        			 * Calculating the new reserved for that model id
        			 */
        			int currentReserved = CarsInventory.GetReserved(getModelId);
        			//int newReserved = currentReserved + rcvdQuantity;
        				// System.out.println("in canceling condition");
        				String canceled = "canceled";
        				String shipped = "shipping succesful";
        				System.out.println(currentStatus);

        				// Checking if it's not shipped or in shipping or not canceled
        				// before.
        				if (!shipped.equals(currentStatus) && !canceled.equalsIgnoreCase(currentStatus)) {
        					System.out.println("into checking shipping status");
        					int newQuantity = CarsInventory.GetQuantity(getModelId)
        							+ orderQuantity;
        					boolean updateResult = CarsInventory.UpdateCars(getModelId,
        							newQuantity, currentReserved);
        					boolean updateStatus = RegionalOrderControl.updateStatus(
        							rcvdOrderId, rcvdCustomerId, shippingStatus2);

        					if (updateResult == true && updateStatus == true) {
        						cor.setResult(true);
        						cor.setShippingId(shippingId);
        						cor.setComment(shippingStatus2);
        					}
        				}
        				// If the order is canceled before
        				else if (canceled.equals(currentStatus)) {
        					// System.out.println("into checking canceled condition");
        					cor.setResult(false);
        					cor.setShippingId(shippingId);
        					cor.setComment("Canceled Before");
        				} else {
        					cor.setResult(false);
        					cor.setShippingId(0);
        					cor.setComment("not possible");
        				}
        			}
        		else {
        			cor.setResult(false);
        			cor.setShippingId(0);
        			cor.setComment("Order Id invalid");
        		}
                return cor;
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param receiveCarsFromManufacture4 
             * @return receiveCarsFromManufactureResponse5 
         */
        
                 public com.autoinc.auto_regional.ReceiveCarsFromManufactureResponse receiveCarsFromManufacture(
             			com.autoinc.auto_regional.ReceiveCarsFromManufacture receiveCarsFromManufacture2) {
             		ReceiveCarsFromManufactureResponse rcfmr = new ReceiveCarsFromManufactureResponse();
             		// rcfmr.setResult(false);

             		int rcvdOrderId = receiveCarsFromManufacture2.getOrderId();
             		String rcvdModelName = receiveCarsFromManufacture2.getModelName();
             		String rcvdModelEdition = receiveCarsFromManufacture2.getModelEdition();
             		String rcvdModelColor = receiveCarsFromManufacture2.getModelColor();
             		int rcvdQuantity = receiveCarsFromManufacture2.getQuantity();

             		// Check the orderID is valid or not
             		boolean checkRow = RegionalOrderControl.checkRowExist(rcvdOrderId);

             		if (checkRow) {

             			// getting model id from the previously created regional_order table
             			RegionalOrders regOrder = RegionalOrderControl
             					.getRegionalOrderByOrderId(rcvdOrderId);
             			int getModelId = regOrder.getModelId();
             			String rcvdCountry = regOrder.getCountry();

             			// get model if from cars table
             			int checkModelId = CarsInventory.GetModelId(rcvdModelName,
             					rcvdModelEdition, rcvdCountry, rcvdModelColor);
             			int currentQuantity = CarsInventory.GetQuantity(getModelId);
             			int currentReserved = CarsInventory.GetReserved(getModelId);

             			if (getModelId == checkModelId) {
             				int newQuantity = currentQuantity + rcvdQuantity;
             				//int newReserved = currentReserved + rcvdQuantity;
             				boolean updateSuccesful = CarsInventory.UpdateCars(getModelId,
             						newQuantity, currentReserved);

             				// System.out.println(updateSuccesful);

             				if (updateSuccesful == true) {
             					rcfmr.setResult(true);
             					rcfmr.setOrderId(rcvdOrderId);
             					rcfmr.setShippingStatus("Ready to Ship");
             					/*
             					 * Update order table status
             					 */
             					// System.out.println(rcfmr + "update successful");
             				} else {
             					rcfmr.setResult(false);
             					rcfmr.setOrderId(rcvdOrderId);
             					rcfmr.setShippingStatus("Invalid");
             					// System.out.println(rcfmr + "update failed");
             				}
             			}

             		} else {
             			rcfmr.setResult(false);
             			rcfmr.setOrderId(rcvdOrderId);
             			rcfmr.setShippingStatus("Invalid Order Id");
             		}

             		return rcfmr;

             	}
    }
    