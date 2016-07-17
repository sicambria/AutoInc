package com.autoinc.model;

import java.util.ArrayList;

public class Test
{

	public static void main(String[] args)
	{
		ArrayList<CarObject> carList = CarClass.getCars();
		
		for (CarObject cars : carList)
		{
			System.out.println(cars.getCar_id());
		}

	}

}
