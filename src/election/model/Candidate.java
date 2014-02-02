package election.model;

import java.io.Serializable;

public class Candidate implements Serializable {
	
	private Election election;
	
	private Person person;
	
	/**
	 * Maakt een kandidaat aan voor een gegeven verkiezing
	 * @param election de verkiezing waarvoor het kandidaatschep geldt
	 * @param person persoon die kandidaat is
	 */
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
