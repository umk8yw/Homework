package tests;

public class Circle {
}

class Shape extends Circle {
}

class Test {
	public static void main(String[] args) {
		Circle c = new Circle();
		
//		System.out.println(c.isInstance(Circle));
		System.out.println(c instanceof Shape);
		System.out.println(c.getClass() == Shape.class);
//		System.out.println(c.isInstance(Shape));
		System.out.println(c.getClass() == Circle.class);
	}
}