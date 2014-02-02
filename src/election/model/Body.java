package election.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Body implements Serializable {

	private String name;
	
	private List<Seat> seats;
	
	private Election election = null;
	
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

	public List<Poll> startElection(Date date, List<Seat> seats, List<Person> candidates, List<Person> voters, int numPollOffset, int numPolls) {
		if(this.election == null) {
			Election e = new Election(this, date, seats, candidates, voters, numPollOffset, numPolls);
			this.election = e;
			return e.getPolls();
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
