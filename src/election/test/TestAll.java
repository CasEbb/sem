package election.test;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.awtui.TestRunner;

public class TestAll extends TestSuite {
	public static void main(String[] args) {
		TestRunner.run(TestAll.class);
	}
	
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(TestBody.class);
		suite.addTestSuite(TestCandidate.class);
		suite.addTestSuite(TestElection.class);
		suite.addTestSuite(TestPerson.class);
		suite.addTestSuite(TestPoll.class);
		suite.addTestSuite(TestSeat.class);
		suite.addTestSuite(TestSuffrage.class);
		suite.addTestSuite(TestTally.class);
		suite.addTestSuite(TestTerm.class);
		return suite;
	}
}
