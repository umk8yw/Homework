package com.atraxo.homework1;

public class Part2xe2 {

	public static String s1 = "static string";

	static {
		String s2 = "sting from the static block";
		
		// s2 will be printed only if we add in this block
		// the print statement
		System.out.println(s2);
	}

	public static void print() {

		System.out.println(s1);

		// this is not possible because s2 is not created local
		// System.out.println(s2);
	}
	
	public static void main(String[] args){
		
		// at this point will be printed s1
		Part2xe2.print();
	}
}