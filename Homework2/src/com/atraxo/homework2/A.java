package com.atraxo.homework2;

public class A{

	public void print(){
		
		System.out.println("from a");
	}
}

class B extends A{

	@Override
	public void print() {
		
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

//	the basis of polymorphism does not work in the way this exercise asks 