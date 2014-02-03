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
	
	private Date electionDate;
	
	/**
	 * Maakt een nieuwe verkiezing aan
	 * @param body orgaan waarvoor de verkiezing is
	 * @param electionDate dag van de verkiezing
	 * @param seats zetels die verdeeld mogen worden
	 * @param candidates kandidaten voor de zetels
	 * @param voters personen die mogen stemmen
	 * @param numPollOffset doorloopnummer van het eerste stembureau
	 * @param numPolls het aantal stembureaus
	 */
	public Election(Body body, Date electionDate, List<Seat> seats, List<Person> candidates, List<Person> voters, int numPollOffset, int numPolls) {
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
				// stemmers voor een bureau
				for(Person voter : voters) {
					p.getSuffrages().add(new Suffrage(voter, p));
				}
			}
		}
	}
	
	/**
	 * Geeft de lijst met zetels terug voor deze verkiezing
	 * @return zetels
	 */
	public List<Seat> getSeats() {
		return this.seats;
	}
	
	/**
	 * Geeft de stembureaus terug van deze verkiezing
	 * @return lijst met stembureaus
	 */
	public List<Poll> getPolls() {
		return this.polls;
	}
	
	/**
	 * Geeft de kandidaten terug voor deze verkiezing
	 * @return lijst met kandidaten
	 */
	public List<Candidate> getCandidates() {
		return this.candidates;
	}
	
	/**
	 * Geeft de datum van de verkiezing
	 * @return de verkiezingsdatum
	 */
	public Date getElectionDate() {
		return this.electionDate;
	}
	
	/**
	 * Sluit een verkiezing af en past de nieuwe zetel verdeling toe
	 * @param result een map met welke zetel voor welke kandidaat is
	 */
	public void finalize(Map<Seat, Candidate> result) {
		// Process result set
		for(Map.Entry<Seat, Candidate> entry : result.entrySet()) {
			Seat s = entry.getKey();
			Candidate c = entry.getValue();
			
			if(s.getCurrentTerm() != null) s.getCurrentTerm().endTerm();
			s.getSeatHolders().add(new Term(c.getPerson(), s, new Date()));
		}
		
		// Unlock election
		body.endElection();
	}

}
