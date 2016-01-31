package com.atraxo.homework2;

public class Graphic {

	public static void draw(Graphic graphic){
		
		if(graphic.getClass().toString().equals(Circle.class.toString()))
			System.out.println("you have drown a CIRCLE");
		else if(graphic.getClass().toString().equals(Line.class.toString()))
			System.out.println("you have drown a LINE");
		else if(graphic.getClass().toString().equals(Point.class.toString()))
			System.out.println("you have drown a POINT");
		else  System.out.println("NOTHING");
	}
}

class Point extends Graphic{
	
	int x,y;

	public Point(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
}

class Circle extends Graphic{
	
	Point center;
	Line radius;

	public Circle(Point center, Line radius) {
		
		this.center = center;
		this.radius = radius;
	}
}

class Line extends Graphic{
	
	Point leftPoint, rightPoint;

	public Line(Point leftPoint, Point rightPoint) {
		
		this.leftPoint = leftPoint;
		this.rightPoint = rightPoint;
	}
}

class Start{
	
	public static void main(String[] args){
		
		Point point = new Point(10, 7);
		Graphic.draw(point);
		
		Line line = new Line(point, new Point(43, 10));
		Graphic.draw(line);
		
		Circle circle = new Circle(point, line);
		Graphic.draw(circle);
		
		Graphic.draw(new Graphic());
	}
}