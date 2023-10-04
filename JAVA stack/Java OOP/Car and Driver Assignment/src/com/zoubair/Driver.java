package com.zoubair;

public class Driver extends Car {
	public void drive()
	{
	
		super.setGas(super.getGas()-1);
		System.out.println("Driver is driving The remaining Gaz is "+super.getGas());
	}
	public void useBoosters()
	{
		if(getGas()<3)
		{
			System.out.println("You re not allwoed to boost");
		}
		else {
			
			
			super.setGas(super.getGas()-3);
			System.out.println("Driver is using booster The remaining Gaz is "+super.getGas());
		}
	}
	public void refuel()
	{
		if(getGas()>8)
		{
			System.out.println("You re not allwoed to refuel");
		}
		else {
			
			super.setGas(super.getGas()+2);
			System.out.println("Driver is refueling The remaining Gaz is  "+super.getGas());
		}
	}
}