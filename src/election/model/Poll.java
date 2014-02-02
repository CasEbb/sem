package election.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Poll implements Serializable {

	private Integer stationNumber;
	
	private Election election;

    private List<Suffrage> suffrages;

    private List<Tally> tallies;
	
    /**
     * Maakt een nieuw stembureau aan
     * @param stationNumber volgnummer van het stembureau
     * @param election verkiezing waarvoor het stembureau wordt ingericht
     */
	public Poll(Integer stationNumber, Election election) {
		this.stationNumber = stationNumber;
		this.election = election;
		this.tallies = new ArrayList<Tally>();
		this.suffrages = new ArrayList<Suffrage>();
	}
	
	/**
	 * Geeft het volgnummer van het stembureau
	 * @return volgnummer
	 */
	public Integer getStationNumber() {
		return this.stationNumber;
	}
	
	/**
	 * Geeft de verkiezing waarvoor het stembureau is
	 * @return verkiezing
	 */
	public Election getElection() {
		return this.election;
	}

	/**
	 * Geeft de lijst met tussenstanden voor dit bureau
	 * @return lijst met tellers
	 */
    public List<Tally> getTallies() {
        return this.tallies;
    }

    /**
     * Geeft de lijst met personen met stemrecht
     * @return lijst van mensen met stemrecht
     */
    public List<Suffrage> getSuffrages() {
        return this.suffrages;
    }

}
