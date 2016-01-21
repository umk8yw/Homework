package com.atraxo.homework1;

public class Part1ex1 {

	public static void main(String[] args) {

		int i = 3;

		for (; i >= 0; i--) {
			switch (i) {
			case 1:
				System.out.println("first case");
				 break;
			case 2:
				System.out.println("second case");
				 break;
			case 3:
				System.out.println("third case");
				 break;
			default:
				System.out.println("default case");
				 break;
			}
		}
	}
}

/*
 * Output with "break":
 * third case
 * second case
 * first case
 * default case
 * 
 * Output without "break": 
 * third case 
 * default case 
 * second case 
 * third case
 * default case 
 * first case 
 * second case 
 * third case 
 * default case 
 * default case
 * 
 * If there is missing the break keyword, the compiler will execute all the
 * cases which are after the case which is matching with the value of the
 * condition
 */