package com.regionalsupplier.model;

public class AccessoryObject
{

	public AccessoryObject(int accessoryId, int quantity, String comments)
	{
		super();
		this.accessoryId = accessoryId;
		this.quantity = quantity;
		this.comments = comments;
	}

	public int getAccessoriesId()
	{
		return accessoryId;
	}

	public void setAccessories_id(int accessoriesId)
	{
		this.accessoryId = accessoriesId;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	int accessoryId;
	int quantity;
	String comments;

}
