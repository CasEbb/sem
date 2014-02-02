package election.model;

import java.util.Date;
import java.util.List;

public class Body {

	private String name;
	
	private List<Seat> seats;
	
	private Election election;
	
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
	
	public Election getElection() {
		return this.election;
	}
	
	public String toString() {
		return this.name;
	}
	
	public boolean inElection() {
		return (this.election != null);
	}

	public Election startElection(Date date, List<Seat> seats) {
		if(this.election == null) {
			Election e = new Election(this, date);
			e.setSeats(seats);
			this.election = e;
			return e;
		} else {
			return null;
		}
	}
	
	public boolean endElection() {
		if(this.election != null) {
			this.election = null;
			return true;
		} else {
			return false;
		}
	}
	
}
