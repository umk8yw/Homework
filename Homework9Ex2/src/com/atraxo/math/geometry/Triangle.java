package com.atraxo.math.geometry;

import com.atraxo.common.LoggingWrapper;

public class Triangle {
	
	private int lenght1;
	private int lenght2;
	private int lenght3;
	private String type;

	public Triangle(int lenght1, int lenght2, int lenght3) {
		super();
		this.lenght1 = lenght1;
		this.lenght2 = lenght2;
		this.lenght3 = lenght3;

		if ((lenght1 == lenght2) && (lenght2 == lenght3))
			this.type = "equilateral";
		else if ((lenght1 == lenght2) || (lenght2 == lenght3) || (lenght1 == lenght3))
			this.type = "isosceles";
		else
			this.type = "scalene";
	}

	public String getType() {
		LoggingWrapper.log("This triangle is " + type);
		return "This triangle is " + type;
	}
}
