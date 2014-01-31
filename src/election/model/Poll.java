package election.model;

public class Poll {

	private Integer stationNumber;
	
	private Election election;
	
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

}
