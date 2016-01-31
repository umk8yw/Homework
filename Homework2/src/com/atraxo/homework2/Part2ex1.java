package com.atraxo.homework2;

//[ZP] check out the difference
public abstract class Part2ex1 {

	public abstract void method();
}

class Subclass extends Part2ex1 {

	public void method() {
		
		System.out.println("non-static method");
	}

	public static void doSomething(Part2ex1 ex) {

		System.out.println("static method");
//		Subclass sub = (Subclass) ex;		
//		sub.method();
		ex.method();
	}
}

class StartP2E1 {

	public static void main(String[] args) {

		Part2ex1 ex = new Subclass();
		Subclass.doSomething(ex);
//		ex.method();
	}
}

//	If in the abstract class the method() method is not declared, 
//	the static method is needed to call the method() from the Subclass.
//	By declaring it abstract, in main an instance of Part2ex1 may call method()