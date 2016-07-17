package eu.model;

public class ChassisObject
{

	public ChassisObject()
	{
		super();
	}

	public ChassisObject(int chassisId, int quantity, String comments)
	{
		super();
		this.chassisId = chassisId;
		this.quantity = quantity;
		this.comments = comments;
	}

	public int getChassisId()
	{
		return chassisId;
	}

	public void setChassisId(int chassisId)
	{
		this.chassisId = chassisId;
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

	int chassisId;
	int quantity;
	String comments;

}
