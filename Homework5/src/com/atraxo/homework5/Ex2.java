package com.atraxo.homework5;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {

		List<Country> list = new ArrayList<>();
		list.add(new Country("Romania", "Bucuresti"));
		list.add(new Country("Ungaria", "Budapesta"));
		list.add(new Country("Spania", "Madrid"));
		list.add(new Country("Albania", "Something"));
		list.add(new Country("Uganda", "Botswana"));
		list.add(new Country("France", "Paris"));

		list.sort(Country::compareTo);
		Country.print(list);

		System.out.println("------------------------------------");

		list.sort(Country.comparator);
		Country.print(list);
		
		System.out.println("------------------------------------");
		
		Country paris = new Country(null, "Paris");
		System.out.println(Country.find(list, paris));
	}
}

class Country implements Comparable<Country> {

	public String name;
	public String capital;

	public Country(String name, String capital) {
		this.name = name;
		this.capital = capital;
	}

	@Override
	public int compareTo(Country country) {

		Collator collator = Collator.getInstance();
		return collator.compare(this.name, country.name);
	}

	public static void print(List<Country> list) {
		for (Country c : list)
			System.out.println("country: " + c.name + ", capital: " + c.capital);
	}

	public static Comparator<Country> comparator = new Comparator<Country>() {
		@Override
		public int compare(Country c1, Country c2) {
			Collator collator = Collator.getInstance();
			return collator.compare(c1.capital, c2.capital);
		}
	};

	public static String find(List<Country> countries, Country c2) {
		for (Country c1 : countries)
			if (Country.comparator.compare(c1, c2) == 0)
				return c1.name;
		return null;
	}
}