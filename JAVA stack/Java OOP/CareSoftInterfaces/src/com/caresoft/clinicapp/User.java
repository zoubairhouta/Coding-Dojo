package com.caresoft.clinicapp;

public class User {
    protected Integer id;
    protected int pin;
    
    
    
	// Implement a constructor that takes an ID
	public User() {
		super();
	}
	public User(Integer id, int pin) {
		super();
		this.id = id;
		this.pin = pin;
	}
	public User(Integer id) {
		super();
		this.id = id;
	
	}

    
    // TO DO: Getters and setters

	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}