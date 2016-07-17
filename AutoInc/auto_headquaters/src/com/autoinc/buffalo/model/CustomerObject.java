package com.autoinc.buffalo.model;

public class CustomerObject
{
	int customerId;
	String email;
	String password;
	String name;
	String phoneNumber;
	String country;
	String address;
	
	public CustomerObject(int customerId, String email, String password,
			String name, String phoneNumber, String country, String address) {
		super();
		this.customerId = customerId;
		this.email = email;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.address = address;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
