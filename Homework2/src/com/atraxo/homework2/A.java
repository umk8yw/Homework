package com.atraxo.homework2;

public class A{

	public static void print(){
		
		System.out.println("from a");
	}
}

class B extends A{

	public static void print() {
		
		System.out.println("from b");
	}	
}

class StartP2E3{
	
	public static void main(String[] args){
		
		B b = new B();
		b.print();
		
		((A) b).print();
	}
}

//[ZP] Think how should you modify the classes and specially the print methods to solve the exercise

// pay more attention !!!!!!!!!!!