package com.autoinc.buffalo.model;

public class PaymentInformationObject {

	int customer_id;
	String bank;
	String account_number;
	
	public PaymentInformationObject(int customer_id, String bank,
			String account_number) {
		super();
		this.customer_id = customer_id;
		this.bank = bank;
		this.account_number = account_number;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	
}
