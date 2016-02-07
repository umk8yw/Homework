package tests;

class MyObject implements Cloneable {
	int i;

	MyObject(int ii) {
		i = ii;
	}

	public Object clone() throws CloneNotSupportedException {
		Object o = (MyObject) super.clone();
		return o;
	}

	public String toString() {
		return Integer.toString(i);
	}
}
