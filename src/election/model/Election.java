package election.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Election {
	
	private Set<Seat> seats;
	
	private Set<Poll> polls;
	
	private Set<Candidate> candidates;
	
	private Date electionDate;
	
	public Election(Date electionDate) {
		this.seats = new HashSet<Seat>();
		this.polls = new HashSet<Poll>();
		this.candidates = new HashSet<Candidate>();
		this.electionDate = electionDate;
	}
	
	public Set<Seat> getSeats() {
		return this.seats;
	}
	
	public Set<Poll> getPolls() {
		return this.polls;
	}
	
	public Set<Candidate> getCandidates() {
		return this.candidates;
	}
	
	public Date getElectionDate() {
		return this.electionDate;
	}

}
