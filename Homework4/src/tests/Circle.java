package tests;

public class Circle {
}

class Shape extends Circle {
}

class Test {
	public static void main(String[] args) {
		Circle c = new Circle();
		Shape s = new Shape();

		System.out.println(c.getClass().isInstance(c));
		System.out.println(c instanceof Shape);
		System.out.println(c.getClass() == Shape.class);
		System.out.println(c.getClass().isInstance(s));
		System.out.println(c.getClass() == Circle.class);
	}
}

