package com.zoubair.puzzling;

import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
    	        //..
		// Write your other test cases here.
		//..
		Character randomCharacter = generator.getRandomLetter();
		
		System.out.println(randomCharacter );
		String password = generator.generatePassword();
		System.out.println(password );
		ArrayList<String> passsords=  generator.getNewPasswordSet(8);
		System.out.println(passsords);
		
		
		ArrayList<String> passsordsss =generator.shuffleArray( passsords);
		System.out.println(passsordsss);
		
		
	}
}