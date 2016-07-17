
/**
 * CarInventoryWSDLFileSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package com.autoinc.www.carinventorywsdlfile;

import com.autoinc.regional.model.CarsInventory;
import com.autoinc.regional.model.RegionalOrderControl;
    /**
     *  CarInventoryWSDLFileSkeleton java skeleton for the axisService
     */
    public class CarInventoryWSDLFileSkeleton implements CarInventoryWSDLFileSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param checkForCars0 
             * @return checkForCarsResponse1 
         */
        
                 public com.autoinc.www.carinventorywsdlfile.CheckForCarsResponse checkForCars
                  (
                  com.autoinc.www.carinventorywsdlfile.CheckForCars checkForCars0
                  )
            {
                	 CheckForCarsResponse cfcr = new CheckForCarsResponse();
                     cfcr.setResult(false);
                     
                     String rcvdModelName = checkForCars0.getModelName();
                     String rcvdColor = checkForCars0.getColor();
                     String rcvdEdition = checkForCars0.getEdition();
                     String rcvdCountry = checkForCars0.getCountry();
                     int rcvdQuantity = checkForCars0.getQuantity();
                     int rcvdOrderId = checkForCars0.getOrderId();
                     String rcvdCustomerName = checkForCars0.getCustomerName();
                     String rcvdCustomerAddress = checkForCars0.getCustomerAddress();
                     int rcvdCustomerId = checkForCars0.getCustomerId();
                     
                     //Setting shipping status
                     String setShippingStatus = "initialized";
                     
                     
                     int getModelId = CarsInventory.GetModelId(rcvdModelName, rcvdEdition, rcvdCountry, rcvdColor);
                     //System.out.println(getModelId + " getting model id");
                     int currentQuantity =  CarsInventory.GetQuantity(getModelId);
                     
                     
                     /*
                      * Calculating the new reserved for that model id
                      */
                     int currentReserved = CarsInventory.GetReserved(getModelId);
                     int newReserved = currentReserved + rcvdQuantity;
                     RegionalOrderControl.CreateOrders(rcvdOrderId, rcvdCustomerId, getModelId, rcvdQuantity, 0, rcvdCustomerName, rcvdCustomerAddress, rcvdCountry, setShippingStatus);
                     //System.out.println(currentQuantity + " getting current quantity");
                     
                     if ( getModelId > 0 && currentQuantity > rcvdQuantity ) {
                     	int newQuantity = currentQuantity - rcvdQuantity;
                     	boolean result = CarsInventory.UpdateCars(getModelId, newQuantity, newReserved);
                     	//RegionalOrderControl.CreateOrders(rcvdOrderId, rcvdCustomerId, getModelId, rcvdQuantity, 0, rcvdCustomerName, rcvdCustomerAddress, rcvdCountry, setShippingStatus);
                     	//System.out.println("printing updateCars result " + result);
                     	if (result)
                     	{
                     		cfcr.setResult(true);
                     		cfcr.setQuantity(rcvdQuantity);
                     	}
                     	else {
                     		cfcr.setResult(false);
                     		cfcr.setQuantity(currentQuantity);
                     	}

                     }
                     
                     else {
                     	cfcr.setResult(false);
                     	cfcr.setQuantity(currentQuantity);
                     }            
                     return cfcr;

        }
     
    }
    