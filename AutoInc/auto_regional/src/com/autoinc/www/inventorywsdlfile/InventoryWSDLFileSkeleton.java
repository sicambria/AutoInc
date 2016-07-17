/**
 * InventoryWSDLFileSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.autoinc.www.inventorywsdlfile;

import com.autoinc.regional.model.Inventory;

/**
 * InventoryWSDLFileSkeleton java skeleton for the axisService
 */
public class InventoryWSDLFileSkeleton implements
		InventoryWSDLFileSkeletonInterface {

	/**
	 * Auto generated method signature
	 * 
	 * @param addParts0
	 * @return addPartsResponse1
	 */
	public com.autoinc.www.inventorywsdlfile.AddPartsResponse addParts(
			com.autoinc.www.inventorywsdlfile.AddParts addParts0) {
		AddPartsResponse apr = new AddPartsResponse();
		apr.setResult(false);

		String rcvdModelName = addParts0.getPartName();
		int rcvdQuantity = addParts0.getQuantity();
		int getModelId = Inventory.GetPartsId(rcvdModelName);
		int currentQuantity = Inventory.GetQuantity(getModelId);
		//System.out.println("into wsdl " + currentQuantity);

		if (getModelId > 0) {
			int newQuantity = currentQuantity + rcvdQuantity;
			boolean addPartsResult = Inventory.UpdateInventory(getModelId,
					newQuantity);
			//System.out.println(addPartsResult);

			if (addPartsResult) {
				apr.setResult(true);
				apr.setAvailableQuantity(newQuantity);
			}
		}

		else {
			apr.setResult(false);
			apr.setAvailableQuantity(currentQuantity);
		}

		return apr;
		// TODO : fill this with the necessary business logic
		// throw new java.lang.UnsupportedOperationException("Please implement "
		// + this.getClass().getName() + "#addParts");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param supplyParts2
	 * @return supplyPartsResponse3
	 */
	public com.autoinc.www.inventorywsdlfile.SupplyPartsResponse supplyParts(
			com.autoinc.www.inventorywsdlfile.SupplyParts supplyParts2) {
		SupplyPartsResponse spr = new SupplyPartsResponse();
		spr.setResult(false);

		String rcvdModelName = supplyParts2.getPartName();
		int rcvdQuantity = supplyParts2.getQuantity();
		int getModelId = Inventory.GetPartsId(rcvdModelName);
		int currentQuantity = Inventory.GetQuantity(getModelId);

		if (currentQuantity > rcvdQuantity) {
			int newQuantity = currentQuantity - rcvdQuantity;
			boolean addPartsResult = Inventory.UpdateInventory(getModelId,
					newQuantity);

			if (addPartsResult) {
				spr.setResult(true);
				spr.setAvailableQuantity(newQuantity);
			}
		} else {
			spr.setResult(false);
			spr.setAvailableQuantity(currentQuantity);
		}

		return spr;
		// TODO : fill this with the necessary business logic
		// throw new java.lang.UnsupportedOperationException("Please implement "
		// + this.getClass().getName() + "#supplyParts");
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param updateParts4
	 * @return updatePartsResponse5
	 */

	public com.autoinc.www.inventorywsdlfile.UpdatePartsResponse updateParts(
			com.autoinc.www.inventorywsdlfile.UpdateParts updateParts4) {
		UpdatePartsResponse upr = new UpdatePartsResponse();
		upr.setResult(false);

		String rcvdModelName = updateParts4.getPartName();
		int rcvdQuantity = updateParts4.getQuantity();
		int getModelId = Inventory.GetPartsId(rcvdModelName);
		boolean addPartsResult = Inventory.UpdateInventory(getModelId,
				rcvdQuantity);

		if (addPartsResult) {
			upr.setResult(true);
			upr.setAvailableQuantity(rcvdQuantity);
		} else {
			upr.setResult(false);
			upr.setAvailableQuantity(0);
		}

		return upr;
	}

	/**
	 * Auto generated method signature
	 * 
	 * @param getParts6
	 * @return getPartsResponse7
	 */
	public com.autoinc.www.inventorywsdlfile.GetPartsResponse getParts(
			com.autoinc.www.inventorywsdlfile.GetParts getParts4) {
		GetPartsResponse upr = new GetPartsResponse();
		upr.setResult(false);

		String rcvdModelName = getParts4.getPartName();
		int getModelId = Inventory.GetPartsId(rcvdModelName);
		int currentQuantity = Inventory.GetQuantity(getModelId);

		boolean addPartsResult = Inventory.UpdateInventory(getModelId,
				currentQuantity);

		if (addPartsResult) {
			upr.setResult(true);
			upr.setAvailableQuantity(currentQuantity);
		} else {
			upr.setResult(false);
			upr.setAvailableQuantity(currentQuantity);
		}

		return upr;
	}

}
