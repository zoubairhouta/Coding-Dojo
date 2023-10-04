package com.zoubair.abstractart;

public class Sculpture extends Art {

	public Sculpture(String title, String author, String description,String material) {
		super(title, author, description);
		this.material= material;
		viewArt();
	}

	@Override
	public void viewArt() {
		System.out.println(("The sculpture  is " + getTitle()+" "+getAuthor()+" "+getDescription()+" "+getMaterial()));

	}
	
	private String material;

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
