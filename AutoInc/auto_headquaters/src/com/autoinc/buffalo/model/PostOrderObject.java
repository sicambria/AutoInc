package com.autoinc.buffalo.model;

import java.sql.Date;


public class PostOrderObject {
	
	public int orders_id;
	public int customer_id;
	public String model;
	public String edition;
	public String color;
	public int quantity;
	public int amount;
	public String status;
	public Date order_date;
	public String delivery_date;
	public int transaction_id;
	public String payment;
	public String warehouse;
	public String manufacturing;
	public String shipping_status;
	public PostOrderObject(int orders_id, int customer_id, String model,
			String edition, String color, int quantity, int amount,
			String status, Date order_date, String delivery_date,
			int transaction_id, String payment, String warehouse,
			String manufacturing, String shipping_status) {
		super();
		this.orders_id = orders_id;
		this.customer_id = customer_id;
		this.model = model;
		this.edition = edition;
		this.color = color;
		this.quantity = quantity;
		this.amount = amount;
		this.status = status;
		this.order_date = order_date;
		this.delivery_date = delivery_date;
		this.transaction_id = transaction_id;
		this.payment = payment;
		this.warehouse = warehouse;
		this.manufacturing = manufacturing;
		this.shipping_status = shipping_status;
	}
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(String delivery_date) {
		this.delivery_date = delivery_date;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	public String getManufacturing() {
		return manufacturing;
	}
	public void setManufacturing(String manufacturing) {
		this.manufacturing = manufacturing;
	}
	public String getShipping_status() {
		return shipping_status;
	}
	public void setShipping_status(String shipping_status) {
		this.shipping_status = shipping_status;
	}
	
	
	
	
	

}
