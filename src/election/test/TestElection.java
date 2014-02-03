package election.test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import election.model.Body;
import election.model.Candidate;
import election.model.Election;
import election.model.Person;
import election.model.Seat;

public class TestElection extends TestCase {
	
	Election e;
	Body b;
	Seat s;
	Person p;

	@Override
	protected void setUp() throws Exception {
		s = new Seat("voorzitter");
		b = new Body("gemeenteraad", Arrays.asList(s));
		p = new Person("Freek", "Stationsweg");
		e = new Election(b, new Date(), Arrays.asList(s), Arrays.asList(p), Arrays.asList(p), 1, 1);
	}
	
	public void testCreation() {
		assertEquals(1, e.getPolls().size());
		assertEquals(p, e.getCandidates().get(0).getPerson());
		assertEquals(p, e.getPolls().get(0).getSuffrages().get(0).getPerson());
		assertEquals(1, e.getPolls().get(0).getStationNumber());
	}
	
	public void testFinalize() {
		Map<Seat, Candidate> result = new HashMap<Seat, Candidate>();
		result.put(s, e.getCandidates().get(0));
		e.finalize(result);
		
		assertNull(b.getElection());
		assertEquals(s, b.getSeats().get(0));
		assertEquals(p, b.getSeats().get(0).getCurrentTerm().getPerson());
	}
}
