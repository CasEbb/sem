package election.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Election implements Serializable {
	
	private Body body;
	
	private List<Seat> seats;
	
	private List<Poll> polls;
	
	private List<Candidate> candidates;

    private int electionID;
	
	private Date electionDate;
	
	public Election(Body body, Date electionDate, List<Seat> seats, List<Person> candidates, int numPollOffset, int numPolls) {
		this.body = body;
		this.seats = seats;
		this.polls = new ArrayList<Poll>();
		this.candidates = new ArrayList<Candidate>();
		this.electionDate = electionDate;
		
		// stembureau's scheppen
		for(int i = numPollOffset; i < (numPollOffset + numPolls); i++) {
			Poll p = new Poll(i, this);
			this.polls.add(p);
		}
		
		for(Person person : candidates) {
			Candidate c = new Candidate(this, person);
			this.candidates.add(c);
			// stemtellers maken voor elk stembureau
			for(Poll p : this.polls) {
				p.getTallies().add(new Tally(p, c));
			}
		}
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
