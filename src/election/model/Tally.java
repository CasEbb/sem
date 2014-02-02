package election.model;

import java.io.Serializable;

public class Tally implements Serializable {

    private int votes;

    private Poll poll;

    private Candidate candidate;

    /**
     * Tussenstand voor een kandidaat bij een stembureau
     * @param poll stembureau
     * @param candidate kandidaat
     */
    public Tally(Poll poll, Candidate candidate) {
        this.poll = poll;
        this.candidate = candidate;
    }

    /**
     * Geeft het stembureau terug waarvoor deze teller is
     * @return stembureau
     */
    public Poll getPoll() {
        return this.poll;
    }

    /**
     * Geeft de kandidaat terug waarvoor deze teller geldt
     * @return kandidaat
     */
    public Candidate getCandidate() {
        return this.candidate;
    }

    /**
     * Geeft het aantal stemmen voor de kandidaat bij dit stembureau
     * @return aantal stemmen
     */
    public int getVotes() {
        return this.votes;
    }

    /**
     * Stelt een nieuw aantal stemmen in voor de kandidaat bij dit stembureau
     * @param votes nieuw aantal stemmen
     */
    public void setVotes(int votes) {
        this.votes = votes;
    }
}
