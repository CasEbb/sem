package election.model;

import java.io.Serializable;

public class Tally implements Serializable {

    private int votes;

    private Poll poll;

    private Candidate candidate;

    public Tally(Poll poll, Candidate candidate) {
        this.poll = poll;
        this.candidate = candidate;
    }

    public Poll getPoll() {
        return this.poll;
    }

    public Candidate getCandidate() {
        return this.candidate;
    }

    public int getVotes() {
        return this.votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
