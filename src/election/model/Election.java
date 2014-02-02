package election.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Election {
	
	private Body body;
	
	private List<Seat> seats;
	
	private List<Poll> polls;
	
	private List<Candidate> candidates;

    private int electionID;
	
	private Date electionDate;
	
	public Election(Body body, Date electionDate) {
		this.body = body;
		this.seats = new ArrayList<Seat>();
		this.polls = new ArrayList<Poll>();
		this.candidates = new ArrayList<Candidate>();
		this.electionDate = electionDate;
	}
	
	public List<Seat> getSeats() {
		return this.seats;
	}
	
	public List<Poll> getPolls() {
		return this.polls;
	}
	
	public List<Candidate> getCandidates() {
		return this.candidates;
	}

    public int getElectionID() {
        return this.electionID;
    }
	
	public Date getElectionDate() {
		return this.electionDate;
	}
	
	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}
	
	public void finalize(Map<Seat, Candidate> result) {
		// Process result set
		for(Map.Entry<Seat, Candidate> entry : result.entrySet()) {
			Seat s = entry.getKey();
			Candidate c = entry.getValue();
			
			s.getCurrentTerm().endTerm();
			s.getSeatHolders().add(new Term(c.getPerson(), s, new Date()));
		}
		
		// Unlock election
		body.endElection();
	}

}
