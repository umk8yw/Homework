package com.atraxo.homework4;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Part1Ex1 {

	void readFile() {

		Path filePath = Paths.get("Menu.txt");

		if (Files.exists(filePath)) {

			try {

				List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);

				for (String line : lines) {

					System.out.println(line);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	String getChoice() {

		readFile();

		try (Scanner scanner = new Scanner(System.in);) {

			System.out.println("Which shape would you like to draw? ");
			String choice = scanner.nextLine();

			if(choice != null){
				
				if(!Character.isUpperCase(choice.charAt(0))){
					
					 StringBuilder output = new StringBuilder().append(choice.substring(0, 1).toUpperCase()).append(choice.substring(1));
					return output.toString();
				}
			}else {
				System.out.println("you schould enter a shape");
			}
			return choice;
		} catch (InputMismatchException e) {
			e.printStackTrace();
		}
		return null;
	}

	void draw() {

		String choise = getChoice();
		Class<?> noparam[] = {};

		try {
			String clsName = new StringBuilder().append("com.atraxo.homework4.").append(choise).toString();
						
			Class<?> cls = Class.forName(clsName);
			Object obj = cls.newInstance();

			Method draw = cls.getDeclaredMethod("draw", noparam);
			Method getName = cls.getDeclaredMethod("getName", noparam);
			
			System.out.print(draw.invoke(obj));
			System.out.print(getName.invoke(obj));
		} catch (ClassNotFoundException | NoClassDefFoundError e) {
			System.out.println("This type of shape does not exist.");
		} catch (InstantiationException | IllegalAccessException | SecurityException | NoSuchMethodException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Part1Ex1 ex = new Part1Ex1();
		ex.draw();

	}
}

interface Shape {

	String draw();
	String getName();
}

class Square implements Shape {

	@Override
	public String draw() {
		return "you have drawn a ";
	}

	@Override
	public String getName() {
		return "Square";
	}
}

class Triangle implements Shape {

	@Override
	public String draw() {
		return "you have drawn a ";
	}
	@Override
	public String getName() {
		return "Triangle";
	}
}

class Circle implements Shape {

	@Override
	public String draw() {
		return "you have drawn a ";
	}

	@Override
	public String getName() {
		return "Circle";
	}
}