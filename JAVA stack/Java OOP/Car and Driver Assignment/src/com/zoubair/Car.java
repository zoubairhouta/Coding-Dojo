package com.zoubair;

public class Car {
private int  gas =10;

// Constructors


public Car(int gas) {
	super();
	this.gas = gas;
}


public Car() {
	super();
}





// Getters and Setters
public int getGas() {
	return gas;
}

public void setGas(int gas) {
	if(gas <=0 || this.gas <=0 )
	{
		System.out.println("game over");
		this.gas =0;
		
	}
	else {
		
		
		this.gas = gas;
	}
	
}


}
