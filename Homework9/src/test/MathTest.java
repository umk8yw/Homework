package test;

import junit.framework.TestCase;

public class MathTest extends TestCase {

	protected int v1;
	protected int v2;

	@Override
	protected void setUp() throws Exception {
		v1 = 2;
		v2 = 3;
	}

	public void testAdd() {
		Math math = new Math();
		assertTrue( 5 == math.add(v1, v2));
	}

	@Override
	protected void runTest() throws Throwable {
		testAdd();
	}
}
