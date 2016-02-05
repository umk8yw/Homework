package com.atraxo.homework4;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Part1Ex3 {

	public static void main(String[] args) {

		try {

			Class<Unknown> cls = Unknown.class;
			
			Constructor<?> construct = cls.getDeclaredConstructor(int.class);
			Object instance = construct.newInstance(5);
			Field field = cls.getDeclaredField("hidden");
			
			field.setAccessible(true);
			int hidden = (int) field.get(instance);
			
			System.out.println(hidden);
			System.out.println(hidden * 2);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

}
