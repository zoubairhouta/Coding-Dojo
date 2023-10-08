package com.zoubair.puzzling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava {
	private int randomNum;
	private int  randomIndex;
 private 	String password = "";
    char character;
	Random rand = new Random();

	public ArrayList<Integer> getTenRolls() {
		ArrayList<Integer> rolls = new ArrayList<Integer>();

		for (int i = 0; i < 20; i++) {
			randomNum = rand.nextInt(20) + 1;
			rolls.add(randomNum);
		}
		return rolls;

	}

	//getRandomLetter
	
	
	public Character getRandomLetter()
	{
		ArrayList<Character> alphabet = new ArrayList<Character>();
		for (character = 'A'; character <= 'Z'; ++character)
		{
			alphabet .add(character);
			
		}
		randomIndex = rand.nextInt(26);
		
		return alphabet.get(randomIndex);
	}
	
	
	public String generatePassword()
	{

		for (int i = 0;i<8;i++)
		{
		
			password+=getRandomLetter();
			
		}
		return password;
	}
	public ArrayList<String>getNewPasswordSet(int arrayOfPasswordLength)
	{
		ArrayList<String>setOfPasswords = new ArrayList<String>();
		for (int i =0 ;i<arrayOfPasswordLength;i++)
		{
			setOfPasswords.add(generatePassword());
		}
			return setOfPasswords;
	}

	
	
	//Shuffle an array
	
	public ArrayList<String> shuffleArray( ArrayList<String> passordss)
	{
	Collections.shuffle(passordss);
	return (passordss);
	}
	// Getters and setters

	
	public int getRandomNum() {
		return randomNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRandomNum(int randomNum) {
		this.randomNum = randomNum;
	}

	public int getRandomIndex() {
		return randomIndex;
	}

	public void setRandomIndex(int randomIndex) {
		this.randomIndex = randomIndex;
	}

	
}
