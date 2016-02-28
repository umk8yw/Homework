package com.atraxo.math.test;

import org.junit.Test;

import com.atraxo.math.geometry.Triangle;

import junit.framework.TestCase;

public class TestTriangle extends TestCase {
	
	private Triangle equilateralTriangle;
	private Triangle isoscelesTriangle;
	private Triangle scaleneTriangle;
	private String string = "This triangle is ";
	
	@Override
	protected void setUp() throws Exception {
		equilateralTriangle = new Triangle(3, 3, 3);
		isoscelesTriangle = new Triangle(3, 3, 4);
		scaleneTriangle = new Triangle(2, 3, 4);	
		
	}

	@Test
	public void testgetType() {
		assertEquals(string + "equilateral", equilateralTriangle.getType());
		assertEquals(string + "isosceles", isoscelesTriangle.getType());
		assertEquals(string + "scalene", scaleneTriangle.getType());
	}

}
