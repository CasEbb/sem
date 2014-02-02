package election.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;
import election.model.Body;
import election.model.Candidate;
import election.model.Person;
import election.model.Seat;

public class TestBody extends TestCase {
	
	Body b;
	Seat s1;
	Seat s2;

	@Override
	protected void setUp() throws Exception {
		List<Seat> seats = new ArrayList<Seat>();
		seats.add(s1 = new Seat("voorzitter"));
		seats.add(s2 = new Seat("griffier"));
		b = new Body("gemeenteraad", seats);
	}
	
	public void testCreation() {
		Body body = new Body("ouderraad", new ArrayList<Seat>());
		assertEquals("ouderraad", body.getName());
		assertEquals(0, body.getSeats().size());
		Seat seat = new Seat("voorzitter");
		body.getSeats().add(seat);
		assertEquals(1, body.getSeats().size());
	}
	
	public void testElection() {
		b.startElection(new Date(), new ArrayList<Seat>(b.getSeats()), new ArrayList<Person>(), new ArrayList<Person>(), 0, 1);
		assertTrue(b.inElection());
		b.getElection().finalize(new HashMap<Seat, Candidate>());
		assertFalse(b.inElection());
		assertFalse(b.endElection());
		assertNull(b.getElection());
	}

}
