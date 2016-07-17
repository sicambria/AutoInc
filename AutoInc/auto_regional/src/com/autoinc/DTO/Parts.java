package com.autoinc.DTO;

public class Parts {
	
	int partId;
	String partName;
	int quantity;
	
	
	
	public Parts(int partId, String partName, int quantity) {
		super();
		this.partId = partId;
		this.partName = partName;
		this.quantity = quantity;
	}
	
	public int getPartId() {
		return partId;
	}
	public void setPartId(int partId) {
		this.partId = partId;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
