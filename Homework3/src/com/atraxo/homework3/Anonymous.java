package com.atraxo.homework3;

interface I1{
	void f();
}

public class Anonymous {

	public void method(I1 i){}
	
	public static void main(String[] args){
		
		Anonymous a = new Anonymous();
		a.method(new I1() {
			
			public void f() {

			}
		});
	}
}




