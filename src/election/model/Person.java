package election.model;

public class Person {
	
	private String name;
	
	private String address;

    private Poll poll;
	
	public Person(String name, String address, Poll poll) {
		this.name = name;
		this.address = address;
        this.poll = poll;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}

    public Poll getPoll() {
        return this.poll;
    }

}
