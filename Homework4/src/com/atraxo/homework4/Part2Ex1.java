package com.atraxo.homework4;

//[ZP] 7- more attention please. 
public class Part2Ex1 {

	public static void main(String[] args) {

		Point point = new Point();
		point.setX(10);
		point.setY(20);

		Line line = new Line();
		line.setPoint1(point);
		line.setPoint2(point);

		Circle1 circle = new Circle1();
		circle.setCenter(point);
		circle.setRadius(43);

		Shape1 shape = new Shape1(circle, line);
		try {
			System.out.println("Shape line before clone: " + shape.getLine());
			Shape1 cloned = (Shape1) shape.clone();
//			cloned.draw();
			System.out.println("Shape line after clone: " + shape.getLine());
			System.out.println("Cloned line after clone: " + cloned.getLine());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}

class Shape1 implements Cloneable {
	private Circle1 circle;
	private Line line;

	public Shape1(Circle1 circle, Line line) {
		this.circle = circle;
		this.line = line;
	}

	public void draw() {
		System.out.println("you have drawn a shape with: ");
		line.draw();
		circle.draw();
	}

	public Object clone() throws CloneNotSupportedException {

		Shape1 cloned = (Shape1) super.clone();
		line = (Line) line.clone();
		circle = (Circle1) circle.clone();
		return cloned;
	}

	public Circle1 getCircle() {
		return circle;
	}

	public Line getLine() {
		return line;
	}
	
	
}

class Point implements Cloneable {
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void draw() {
		System.out.println("point with x: " + getX() + " and y: " + getY());
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Line implements Cloneable {
	private Point point1;
	private Point point2;

	public Point getPoint1() {
		return point1;
	}

	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	public Point getPoint2() {
		return point2;
	}

	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	public void draw() {
		System.out.println("line with point1: ");
		getPoint1().draw();
		System.out.print(" and point2:");
		getPoint2().draw();
	}

	public Object clone() throws CloneNotSupportedException {

		Line cloned = (Line) super.clone();
		cloned.setPoint1((Point) cloned.getPoint1().clone());
		cloned.setPoint2((Point) cloned.getPoint2().clone());
		return cloned;
	}
}

class Circle1 implements Cloneable {
	private Point center;
	private int radius;

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double area() {
		return 3.14 * radius * radius;
	}

	public void draw() {
		System.out.println("circle with center: ");
		getCenter().draw();
		System.out.print(" and radius: " + getRadius());
	}

	public Object clone() throws CloneNotSupportedException {

		Circle1 cloned = (Circle1) super.clone();
		cloned.setCenter((Point) cloned.getCenter().clone());
		return cloned;
	}
}