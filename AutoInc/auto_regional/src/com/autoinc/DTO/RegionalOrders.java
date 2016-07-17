package com.autoinc.DTO;

public class RegionalOrders {
	
	int orderId;
	int customerId;
	int modelId;
	int quantity;
	int shippingId;
	String customerName;
	String customerAddress;
	String country;
	String status;
	
	public RegionalOrders(int orderId, int customerId, int modelId,
			int quantity, int shippingId, String customerName,
			String customerAddress, String country, String status) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.modelId = modelId;
		this.quantity = quantity;
		this.shippingId = shippingId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.country = country;
		this.status = status;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getShippingId() {
		return shippingId;
	}
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
