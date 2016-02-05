package com.atraxo.homework4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {

	void run(String line) {

		Class<?> noparam[] = {};
		int index = line.lastIndexOf(".");

		String className = line.substring(0, index);
		String methodName = line.substring(index + 1);

		try {
			
			Class<?> cls = Class.forName(className);
			Object obj = cls.newInstance();

			Method meth = cls.getDeclaredMethod(methodName, noparam);
			meth.invoke(obj);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		TestReflection test = new TestReflection();
		
		String line = "com.atraxo.homework4.SomeClass.method";
		test.run(line);
	}
}

class SomeClass{
	
	void method(){
		
		System.out.println("it works!");
	}
}
