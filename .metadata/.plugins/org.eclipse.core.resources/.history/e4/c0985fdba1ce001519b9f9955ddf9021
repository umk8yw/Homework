package com.atraxo.homework5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ex1 {

	public static void main(String[] args) {

		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(3);
		a.add(5);
		List<Integer> b = new ArrayList<>();
		b.add(2);
		b.add(4);
		b.add(6);
		b.add(7);

		for (int index : b)
			a.add(index - 1, index);
		print(a);
		System.out.println("------");

		b.removeIf(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return b.indexOf(t) % 2 != 0;
			}
		});
		print(b);
		System.out.println("------");

		a.removeAll(b);
		print(a);
	}

	public static void print(List<Integer> array) {
		for (Integer index : array)
			System.out.println(index);
	}
}
