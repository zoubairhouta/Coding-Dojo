package com.zoubair.abstractart;

public class Painting extends Art {

	
	
	
	//Variables
	private String paintType;
	
	
	
	public Painting(String title, String author, String description,String paintType) {
		super(title, author, description);
		this.paintType = paintType;
		viewArt();
	}



	@Override
	public void viewArt() {
		
		System.out.println(("The painting is " + getTitle()+" "+getAuthor()+" "+getDescription()+" "+getPaintType()));
	}

	
	//getters setters 
	
	public String getPaintType() {
		return paintType;
	}
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}
	
}