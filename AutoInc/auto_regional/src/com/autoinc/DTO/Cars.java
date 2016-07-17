package com.autoinc.DTO;

public class Cars {
	
	int model_id;
	String model;
	String edition;
	String country;
	String color;
	int quantity;
	
	public Cars(int model_id, String model, String edition, String country,
			String color, int quantity) {
		super();
		this.model_id = model_id;
		this.model = model;
		this.edition = edition;
		this.country = country;
		this.color = color;
		this.quantity = quantity;
	}
	public int getModel_id() {
		return model_id;
	}
	public void setModel_id(int model_id) {
		this.model_id = model_id;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	
	
}
