package com.autoinc.model;

public class CarObject
{
	public int getCar_id()
	{
		return car_id;
	}
	public void setCar_id(int car_id)
	{
		this.car_id = car_id;
	}
	public String getOrder_date()
	{
		return order_date;
	}
	public void setOrder_date(String order_date)
	{
		this.order_date = order_date;
	}
	public String getRequired_date()
	{
		return required_date;
	}
	public void setRequired_date(String required_date)
	{
		this.required_date = required_date;
	}
	public String getDone_date()
	{
		return done_date;
	}
	public void setDone_date(String done_date)
	{
		this.done_date = done_date;
	}
	public String getModel()
	{
		return model;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public String getColor()
	{
		return color;
	}
	public void setColor(String color)
	{
		this.color = color;
	}
	public String getEdition()
	{
		return edition;
	}
	public void setEdition(String edition)
	{
		this.edition = edition;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	public String getComments()
	{
		return comments;
	}
	public void setComments(String comments)
	{
		this.comments = comments;
	}
	int car_id;
	String order_date;
	String required_date;
	String done_date;
	String model;
	String color;
	String edition;
	String status;
	String comments;
	
	
	public CarObject(int car_id, String order_date, String required_date, String done_date, String model, String color, String edition,
			String status, String comments)
	{
		super();
		this.car_id = car_id;
		this.order_date = order_date;
		this.required_date = required_date;
		this.done_date = done_date;
		this.model = model;
		this.color = color;
		this.edition = edition;
		this.status = status;
		this.comments = comments;
	}
	
	public CarObject()
	{
		super();

	}

}
