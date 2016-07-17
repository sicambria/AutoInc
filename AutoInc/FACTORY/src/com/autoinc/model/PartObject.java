package com.autoinc.model;

public class PartObject
{

	int partId;
	String partName;
	int quantity;

	public int getPartId()
	{
		return partId;
	}

	public void setPartId(int partId)
	{
		this.partId = partId;
	}

	public String getPartName()
	{
		return partName;
	}

	public void setPartName(String partName)
	{
		this.partName = partName;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public PartObject(int partId, String partName, int quantity)
	{
		super();
		this.partId = partId;
		this.partName = partName;
		this.quantity = quantity;
	}

}
