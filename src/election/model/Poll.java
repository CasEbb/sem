package election.model;

import java.util.ArrayList;
import java.util.List;

public class Poll {

	private Integer stationNumber;
	
	private Election election;

    private List<Suffrage> suffrages;

    private List<Tally> tallies;
	
	public Poll(Integer stationNumber, Election election) {
		this.stationNumber = stationNumber;
		this.election = election;
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
