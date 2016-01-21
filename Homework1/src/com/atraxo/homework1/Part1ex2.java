package com.atraxo.homework1;

public class Part1ex2 {

	private void convert(int decimal) {

		int binar[] = new int[50];
		int i = 0;

		while (decimal > 0) {
			
			binar[i++] = decimal % 2;
			decimal /= 2;
		}
		
		System.out.println("my method: ");
		for(i = i - 1 ; i >= 0; i--)
			System.out.print(binar[i]);
	}

	public static void main(String[] args) {

		Part1ex2 ex = new Part1ex2();
		int decimal = 3465;

		System.out.println("easy way: " + Integer.toBinaryString(decimal));
		
		ex.convert(decimal);
	}
}
