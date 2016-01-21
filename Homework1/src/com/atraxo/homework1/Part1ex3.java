package com.atraxo.homework1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Part1ex3 {

	private boolean isPrime(int number) {

		for (int i = 2; i < number; i++) {

			if (number % i == 0)
				return false;
		}
		return true;
	}
	
	private void getPrimeNumbers(int number){
		
		System.out.println("prime numbers: ");
		
		for(int i = number; i > 0; i--){
			
			if(isPrime(i))
				System.out.println(i);
		}
	}

	public static void main(String[] args) {

		Part1ex3 ex = new Part1ex3();

		System.out.println("number: ");

		try (Scanner scanner = new Scanner(System.in)) {

			int number = scanner.nextInt();

			ex.getPrimeNumbers(number);
			
		}catch(InputMismatchException e){
			
			System.out.println("this is not a number");
		}
	}
}
