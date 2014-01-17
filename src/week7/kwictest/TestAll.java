package week7.kwictest;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.swingui.TestRunner;

public class TestAll extends TestSuite {
	public static void main(String[] args) {
		TestRunner.run(TestAll.class);
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestLine.class);
		return suite;
	}
}
