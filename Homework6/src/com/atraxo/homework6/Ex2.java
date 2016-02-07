package com.atraxo.homework6;

import java.util.ArrayList;

interface Collection<T> {
	public boolean containsAll(Collection<? extends java.util.Collection<?>> c);

	public boolean addAll(Collection<? extends java.util.Collection<?>> c);
}

class CCollection<T> implements Collection<T> {

	@Override
	public boolean containsAll(Collection<? extends java.util.Collection<?>> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends java.util.Collection<?>> c) {
		return false;
	}

}

public class Ex2 {

	public static void main(String[] args) {
		CCollection<ArrayList<String>> CLString = new CCollection<>();
	}

}
