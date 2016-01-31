package com.atraxo.homework2;

public class Amphibian {

	static void jump(Amphibian a) {

		System.out.println(a.getClass().getSimpleName() + " is jumping");
	}

	static void eat(Amphibian a) {

		System.out.println(a.getClass().getSimpleName() + " is eating");
	}
}

class Frog extends Amphibian {
	
}

class Main {

	public static void main(String[] args) {

		Frog frog = new Frog();
		
		Amphibian.eat((Amphibian) frog);		// upcast
		Amphibian.jump((Amphibian) frog);		// upcast
		
		Amphibian amphibian = (Amphibian) frog;		// upcast
		
		Amphibian.eat(amphibian);
		Amphibian.jump(amphibian);
		
		System.out.println("------------------");
		
		Amphibian onlyAmphibian = new Amphibian();
		
		Amphibian.eat(onlyAmphibian);
		Amphibian.jump(onlyAmphibian);
	}
}