package election.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Poll implements Serializable {

	private Integer stationNumber;
	
	private Election election;

    private List<Suffrage> suffrages;

    private List<Tally> tallies;
	
	public Poll(Integer stationNumber, Election election) {
		this.stationNumber = stationNumber;
		this.election = election;
		this.tallies = new ArrayList<Tally>();
		this.suffrages = new ArrayList<Suffrage>();
	}
	
	public Integer getStationNumber() {
		return this.stationNumber;
	}
	
	public Election getElection() {
		return this.election;
	}

    public List<Tally> getTallies() {
        return this.tallies;
    }

    public List<Suffrage> getSuffrages() {
        return this.suffrages;
    }

}
