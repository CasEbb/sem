package election.model;

import java.util.HashSet;
import java.util.Set;

public class Body {

	private String name;
	
	private Set<Seat> seats;
	
	public Body(String name) {
		this.name = name;
		this.seats = new HashSet<Seat>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public Set<Seat> getSeats() {
		return this.seats;
	}

}
