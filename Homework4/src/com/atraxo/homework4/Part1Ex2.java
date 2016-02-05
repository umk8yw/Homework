package com.atraxo.homework4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Part1Ex2 {

	public static void main(String[] args) {

		try {

			Class<Unknown> cls = Unknown.class;
			Constructor<?> construct = cls.getDeclaredConstructor(int.class);
			Object instance = construct.newInstance(5);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}

