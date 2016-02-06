package com.atraxo.homework2;

public class Graphic {

	//[ZP] why static? let polymorphism to work
	
	// stop using static method when you work with inheritance (it might be not needed) !!!
	
	public void draw(Graphic graphic) {

		if (graphic.getClass().toString().equals(Circle.class.toString()))
			System.out.println("you have drown a CIRCLE");
		else if (graphic.getClass().toString().equals(Line.class.toString()))
			System.out.println("you have drown a LINE");
		else if (graphic.getClass().toString().equals(Point.class.toString()))
			System.out.println("you have drown a POINT");
		else
			System.out.println("NOTHING");
	}
}

class Point extends Graphic {

	int x, y;

	public Point(int x, int y) {

		this.x = x;
		this.y = y;
	}
}

class Circle extends Graphic {

	Point center;
	Line radius;

	public Circle(Point center, Line radius) {

		this.center = center;
		this.radius = radius;
	}
}

class Line extends Graphic {

	Point leftPoint, rightPoint;

	public Line(Point leftPoint, Point rightPoint) {

		this.leftPoint = leftPoint;
		this.rightPoint = rightPoint;
	}
}

class Start {

	public static void main(String[] args) {

		Graphic graphic = new Graphic();
		
		Graphic point = new Point(10, 7);
		point.draw(point);

		Graphic line = new Line((Point) point, new Point(43, 10));
		line.draw(line);

		Graphic circle = new Circle((Point) point, (Line) line);
		circle.draw(circle);

		graphic.draw(new Graphic());
	}
}