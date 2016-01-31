package com.atraxo.homework3;

import java.util.Random;

public class RandomPlay {

	static int i = 0;
	static String message = new String();
	
	public void generate() {

		Random random = new Random();
		int nr1 = random.nextInt(10) + 1;
		int nr2 = random.nextInt(10) + 1;
		//[ZP] if nr1 = 1 and nr = 7 ?????
		if((nr1 - nr2) > 3)
			try {
				throw new DifferenceException("result smaller than 3");
			} catch (DifferenceException e) {
				System.out.println(i);
				i++;
				message =  e.getMessage();
			}
	}
	
	public static void main(String[] args) throws DifferenceException{
		
		RandomPlay play = new RandomPlay();
		//[ZP] don't know if 100 iteration is enough
		for(int index = 0; index < 100; index++)
			play.generate();
		
		System.out.println("number of exceptions thrown is: " + i + "\n" + RandomPlay.message);
	}
}

class DifferenceException extends Exception{
	
	private static final long serialVersionUID = 6257765546131683715L;
	
	public DifferenceException(String message){
	     super(message);
	  }
}