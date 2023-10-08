package com.zoubair.cafebusinesslogic;

import java.util.Scanner;
import java.util.ArrayList;

public class CafeUtil {
	private int numWeeks = 10;

	private double[] prices;

	private ArrayList<String> menuItems;

	private ArrayList<String> customers;

	// Constructors

	public CafeUtil(int numWeeks) {
		super();
		this.numWeeks = numWeeks;
	}

	public CafeUtil(int numWeeks, double[] prices, ArrayList<String> menuItems, ArrayList<String> customers) {
		super();
		this.numWeeks = numWeeks;
		this.prices = prices;
		this.menuItems = menuItems;
		this.customers = customers;
	}

	public CafeUtil(double[] prices) {
		super();
		this.prices = prices;
	}

	public CafeUtil() {
		super();
	}

	public CafeUtil(ArrayList<String> menuItems) {
		super();
		this.menuItems = menuItems;
	}

	// int getStreakGoal()

	int getStreakGoal(int numWeeks) {
		int temp = 0;
		for (int i = 0; i <= numWeeks; i++) {

			temp += i;
		}
		return temp;
	}

	// addCustomer(ArrayList<String> customers)

	void addCustomer(ArrayList<String> customers) {
		System.out.println("Please enter your name:");
		Scanner my_scan = new Scanner(System.in);
		String userName = my_scan.nextLine();
		System.out.println("Hello," + " " + userName);
		System.out.println("There are," + " " + customers.size() + " people in front of you");
		customers.add(userName);
		System.out.println(customers);

	}

	// void displayMenu(ArrayList<String> menuItems)
	void displayMenu(ArrayList<String> menuItems) {
		for (int a = 0; a < menuItems.size(); a++)
			System.out.println(a + " " + menuItems.get(a));
	}

	// double getOrderTotal(double[] prices)
	double getOrderTotal(double[] prices) {
		double tempo = 0.000000000000;
		for (int j = 0; j < prices.length; j++) {
			tempo += prices[j];
		}

		return tempo;

	}

//Getters and Setters 

	public int getNumWeeks() {
		return numWeeks;
	}

	public void setNumWeeks(int numWeeks) {
		this.numWeeks = numWeeks;
	}

	public double[] getPrices() {
		return prices;
	}

	public void setPrices(double[] prices) {
		this.prices = prices;
	}

	public ArrayList<String> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(ArrayList<String> menuItems) {
		this.menuItems = menuItems;
	}

	public ArrayList<String> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<String> customers) {
		this.customers = customers;
	}

}
