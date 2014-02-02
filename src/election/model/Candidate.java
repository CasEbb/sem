package election.model;

import java.io.Serializable;

public class Candidate implements Serializable {
	
	private Election election;
	
	private Person person;
	
	public Candidate(Election election, Person person) {
		this.election = election;
		this.person = person;
	}
	
	public Election getElection() {
		return this.election;
	}
	
	public Person getPerson() {
		return this.person;
	}

}
