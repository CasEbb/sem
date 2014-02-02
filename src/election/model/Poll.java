package election.model;

import java.util.ArrayList;
import java.util.List;

public class Poll {

	private Integer stationNumber;
	
	private List<Election> elections;

    private List<Suffrage> suffrages;
	
	public Poll(Integer stationNumber) {
		this.stationNumber = stationNumber;
		this.elections = new ArrayList<Election>();
	}
	
	public Integer getStationNumber() {
		return this.stationNumber;
	}
	
	public List<Election> getElections() {
		return this.elections;
	}

    public List<Suffrage> getSuffrages() {
        return this.suffrages;
    }

}
