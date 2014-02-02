package election.model;

public class Tally {

    private int votes;

    private Poll poll;

    private Candidate candidate;

    public Tally(Poll poll, Candidate candidate) {
        this.poll = poll;
        this.candidate = candidate;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
