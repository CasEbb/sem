package election.model;

import java.util.Date;
import java.util.List;

public class Body {

	private String name;
	
	private List<Seat> seats;
	
	private boolean inElection;
	
	public Body(String name, List<Seat> seats) {
		this.name = name;
		this.seats = seats;
	}
	
	public String getName() {
		return this.name;
	}
	
	public List<Seat> getSeats() {
		return this.seats;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.name;
	}

	public Election startElection(Date date, List<Seat> seats) {
		if(!inElection) {
			Election e = new Election(date);
			e.setSeats(seats);
			return e;
		} else {
			return null;
		}
	}
	
}
