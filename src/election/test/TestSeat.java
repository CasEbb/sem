package election.test;

import java.util.Date;

import junit.framework.TestCase;
import election.model.Person;
import election.model.Seat;
import election.model.Term;

public class TestSeat extends TestCase {
	
	Term t;
	Seat s;
	Person p;

	@Override
	protected void setUp() throws Exception {
		s = new Seat("voorzitter");
		p = new Person("Kees", "Stationsweg");
		t = new Term(p, s, new Date());
		s.getSeatHolders().add(t);
	}
	
	public void testTerms() {
		assertEquals(t, s.getCurrentTerm());
		t.endTerm();
		Term t2 = new Term(p, s, new Date());
		s.getSeatHolders().add(t2);
		assertEquals(t, s.getPreviousTerm());
		assertEquals(t2, s.getCurrentTerm());
	}

}
