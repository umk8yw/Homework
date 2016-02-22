package com.atraxo.homework4;

//[ZP] - where is the mutable companion class technique? String is immutable, he has mutable companion class StringBuilder
//[ZP] - 5
public class Part2Ex2 {

	public static void main(String[] args) {

		Complex complex1 = new Complex(2, 3);
		Complex complex2 = new Complex(4, 5);
		Complex complex3 = new Complex(6, 7);

		Complex firstResult = Complex.multiplicate(complex1, complex2);
		Complex result = Complex.multiplicate(firstResult, complex3);

		System.out.println("(" + complex1.toString() + ")(" + complex2.toString() + ")(" + complex3.toString() + ")= "
				+ result.toString());
	}
}

class Complex {
	public int re;
	public int im;

	public Complex(int re, int im) {

		this.re = re;
		this.im = im;
	}

	public String toString() {

		if (im == 0)
			return re + "";
		if (re == 0)
			return im + "i";
		if (im < 0)
			return re + " - " + (-im) + "i";
		return re + " + " + im + "i";
	}

	public static Complex multiplicate(Complex complex1, Complex complex2) {

		int re = complex1.re * complex2.re - complex1.im * complex1.im;
		int im = complex1.re * complex2.im + complex1.im * complex2.re;
		return new Complex(re, im);
	}
}