package election.printer;

import election.model.*;

import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrinterTUI {
    private boolean isActive;
    private Poll poll;
    private Election election;
    private int pollID;
    private int electionID;

    private PrinterTUI(int pollID, int electionID) {
        this.isActive = false;
        this.poll = poll;
        this.pollID = pollID;

        for(int i = 0; i < this.poll.getElections().size(); i++) {
            if(this.poll.getElections().get(i).getElectionID() == electionID) {
                this.election = this.poll.getElections().get(i);
                break;
            }
        }
    }

    /**
     * Activate the vote printer.
     */
    public void activate() {
        isActive = true;
        viewCandidates();
    }

    /**
     * Deactivate the vote printer. This is done every time a vote is printed
     * or on command (e.g. when the election is over).
     */
    public void deactivate() {
        isActive = false;
    }

    /**
     * After initialization of the system, load the candidates for this election.
     */
    private void loadCandidates() {

    }


    private void viewCandidates() {
        String candidatesList = "";
        int i = 0;
        for(; i < election.getCandidates().size(); i++) {
            String name = election.getCandidates().get(i).getPerson().getName();
            String address = election.getCandidates().get(i).getPerson().getAddress();
            candidatesList += String.format("%i: %s, %s\n", i, name, address);
        }
        candidatesList += String.format("%i: %s\n", i, "No vote");

        System.out.println(candidatesList);
        vote();

    }

    /**
     * Reads the users vote and submits it to the printer.
     */
    private void vote() {

        try{
            System.out.print("Please choose your candidate [id of candidate]: ");
            // Read the choice
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            int candidateID = Integer.parseInt(bufferRead.readLine());

            // Prepare the confirmation
            String name = election.getCandidates().get(candidateID).getPerson().getName();
            String address = election.getCandidates().get(candidateID).getPerson().getAddress();

            boolean notConfirmed = true;
            while(notConfirmed){
                System.out.format("%i: %s, %s", candidateID, name, address);
                System.out.print("Are your sure you want to vote for the following candidate [y/n]: ");

                // Read the confirmation
                bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String choice = bufferRead.readLine();

                if(choice.equals("n")) {
                    notConfirmed = false;
                    viewCandidates();
                }
                else if(choice.equals("y")) {
                    notConfirmed = false;
                    printVote(candidateID);
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Prints the users vote (in this case to a textfile).
     * @param candidateID the ID of the vote
     */
    private void printVote(int candidateID) {
        System.out.format("Election: %i (%s)\n",
                election.getElectionID(),
                election.getElectionDate().toString());
        System.out.format("Poll: %i\n",
                poll.getStationNumber());

        String name = election.getCandidates().get(candidateID).getPerson().getName();
        String address = election.getCandidates().get(candidateID).getPerson().getAddress();

        System.out.format("Candidate of choice: [%i] %s, %s", candidateID, name, address);
    }

    public static void main(String[] args) {
        int pollID = Integer.parseInt(args[0]);
        int electionID = Integer.parseInt(args[1]);

        PrinterTUI t = new PrinterTUI(pollID, electionID);
        t.viewCandidates();
    }

}
