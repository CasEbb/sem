package election.test;

import java.util.Date;

import junit.framework.TestCase;
import election.model.Person;
import election.model.Seat;
import election.model.Term;

public class TestTerm extends TestCase {
	
	Person p;
	Seat s;
	Term t;

	@Override
	protected void setUp() throws Exception {
		p = new Person("Freek", "'t Harde");
		s = new Seat("generaal");
		t = new Term(p, s, new Date());
		s.getSeatHolders().add(t);
	}
	
	public void testCreation() {
		assertEquals(p, t.getPerson());
		assertEquals(s, t.getSeat());
		assertEquals(t, s.getCurrentTerm());
	}
	
	public void testTermEnding() {
		t.endTerm();
		assertEquals(t, s.getCurrentTerm());
	}
	
}
