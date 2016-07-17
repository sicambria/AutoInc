package com.autoinc.buffalo.model;

import java.sql.Date;


public class OrderObject {
	
	public int orders_id;
	public int customer_id;
	public String model;
	public String edition;
	public String color;
	public int quantity;
	public int amount;
	public String status;
	public Date order_date;
	
	public OrderObject(int orders_id, int customer_id, String model,
			String edition, String color, int quantity, int amount,
			String status, Date order_date) {
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
	
	

}
