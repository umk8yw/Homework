package com.atraxo.homework2;

public class Part2ex2 {

	public void firstMethod(){
		
		System.out.println("first method");
		
		Part2ex2 ex = new Part2ex2();
		ex.secondMethod();
	}
	
	public void secondMethod(){
		
		System.out.println("second method");
	}
}

class SecondClass extends Part2ex2{

	@Override
	public void secondMethod() {
		
		System.out.println("overriden method");
	}
}

class StartP2E2{
	
	public static void main(String[] args){
		
		SecondClass sub = new SecondClass();
		Part2ex2 ex = sub;
		
		ex.firstMethod();
	}
}

//	Both of the methods are called from the base class, because
//	even if we initially create a SecondClass object, than it have 
//	been casted to the Part2ex1 type.