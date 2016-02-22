package com.atraxo.homework4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
//[ZP] - 10
public class Part1Ex2 {

	public static void main(String[] args) {

		try {

			Class<Unknown> cls = Unknown.class;
			//[ZP] how do you know that you have a constructor with an input parameter int?
			Constructor<?> construct = cls.getDeclaredConstructor(int.class);
			Object instance = construct.newInstance(5);
			 if (instance instanceof Unknown) {
				Unknown new_name = (Unknown) instance;
				System.out.println("created an instance of Unknown");
			}
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}

