package com.atraxo.homework2;

import static net.mindview.util.Print.*;

class Art {
	Art() {
		print("Art constructor");
	}
}

class Drawing extends Art {
	Drawing() {
		print("Drawing constructor");
	}
}

public class Cartoon extends Drawing {
//	public Cartoon() {
//		print("Cartoon constructor");
//	}

	public static void main(String[] args) {
		Cartoon x = new Cartoon();
	}
}

//The default constructor is appellate and the message 
//from  the constructor declared initially is not 
//print anymore.
//The rest of the constructors are appellate because 
//the only statement from the default constructor is 
//super(), which is also a default statement