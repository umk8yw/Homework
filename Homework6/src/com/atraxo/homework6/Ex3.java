package com.atraxo.homework6;

import java.util.ArrayList;

public class Ex3 {

	public <T extends Comparable<? super T>> java.util.Collection<T> bubbleSort(java.util.Collection<T> toSort) {
		for (T elem : toSort) {
			for (T elemRef : toSort) {
				if (elem.compareTo(elemRef) > 0) {
					T aux = elem;
					elem = elemRef;
					elemRef = aux;
				}
			}
		}

		return toSort;
	}

	public static void main(String[] args) {
		Ex3 obj = new Ex3();
		java.util.Collection<String> myColl = new ArrayList<>();
		myColl.add("c");
		myColl.add("b");
		myColl.add("a");
		java.util.Collection<Integer> myIntColl = new ArrayList<>();

		java.util.Collection<String> ret = obj.bubbleSort(myColl);

		System.out.println(ret);
		java.util.Collection<Integer> retInt = obj.bubbleSort(myIntColl);
	}
}
