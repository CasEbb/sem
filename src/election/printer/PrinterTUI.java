package election.printer;

import election.model.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
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

    public PrinterTUI(int pollID, int electionID) {
        this.isActive = false;
        this.pollID = pollID;

        populate();

        for(int i = 0; i < this.poll.getElections().size(); i++) {
            if(this.poll.getElections().get(i).getElectionID() == electionID) {
                this.election = this.poll.getElections().get(i);
                break;
            }
        }

        //viewCandidates();
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

    private void viewCandidates() {
        String candidatesList = "";
        candidatesList += String.format("%d: %s\n", 0, "No vote");
        for(int i = 1; i <= election.getCandidates().size(); i++) {
            String name = election.getCandidates().get(i-1).getPerson().getName();
            String address = election.getCandidates().get(i-1).getPerson().getAddress();
            candidatesList += String.format("%d: %s, %s\n", i, name, address);
        }


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
            String option;
            if(candidateID != 0) {
                String name = election.getCandidates().get(candidateID - 1).getPerson().getName();
                String address = election.getCandidates().get(candidateID - 1).getPerson().getAddress();
                option = String.format("%s, %s", name, address);
            }
            else {
                option = String.format("%s", "No vote");
            }

            boolean notConfirmed = true;
            while(notConfirmed){
                System.out.format("%d: %s\n", candidateID, option);
                System.out.print("Are your sure you want to vote for the following [y/n]: ");

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
        System.out.format("Poll: %d\n",
                poll.getStationNumber());
        System.out.format("Election: %d (%s)\n",
                election.getElectionID(),
                election.getElectionDate().toString());

        String name = election.getCandidates().get(candidateID).getPerson().getName();
        String address = election.getCandidates().get(candidateID).getPerson().getAddress();

        System.out.format("Candidate of choice: [%d] %s, %s", candidateID, name, address);
    }

    /**
     * Populate the class with test data
     */
    private void populate() {

        // Initialize the Poll (ID)
        poll = new Poll(5);

        // Create dates for elections
        Date d1 = new Date(2014, 01, 01);
        Date d2 = new Date(2014, 01, 02);

        // Create elections (ID, Date)
        Election e1 = new Election(500, d1);
        Election e2 = new Election(501, d2);

        // Create persons (Name, Address)
        Person p1 = new Person("Cas", "Deurningerstraat");
        Person p2 = new Person("Mathijs", "Nieuwstraat");
        Person p3 = new Person("Remco", "De Klomp");
        Person p4 = new Person("Libertas", "Audentis");
        Person p5 = new Person("Est", "Audentis");
        Person p6 = new Person("Felicitas", "Audentis");

        // Suffrages (Person, Poll)
        Suffrage su1 = new Suffrage(p1, poll);
        Suffrage su2 = new Suffrage(p2, poll);
        Suffrage su3 = new Suffrage(p3, poll);
        Suffrage su4 = new Suffrage(p4, poll);
        Suffrage su5 = new Suffrage(p5, poll);
        Suffrage su6 = new Suffrage(p6, poll);

        // Body (Name)
        Body b1 = new Body("Jaarclub");

        // Seats (Name, Body)
        Seat se1 = new Seat("Veurzitter", b1);
        Seat se2 = new Seat("Secretaris", b1);
        Seat se3 = new Seat("Penningmeester", b1);

        // Candidates (Election, Person)
        Candidate c1 = new Candidate(e1, p1);
        Candidate c2 = new Candidate(e1, p2);
        Candidate c3 = new Candidate(e1, p3);
        Candidate c4 = new Candidate(e2, p4);

        // Add Candidates to Elections
        e1.getCandidates().add(c1);
        e1.getCandidates().add(c2);
        e1.getCandidates().add(c3);
        e1.getCandidates().add(c4);

        // Add Elections to Poll
        poll.getElections().add(e1);
        poll.getElections().add(e2);
    }

    public static void main(String[] args) {
        int pollID = Integer.parseInt(args[0]);
        int electionID = Integer.parseInt(args[1]);

        PrinterTUI t = new PrinterTUI(pollID, electionID);
        //t.populate();
        t.viewCandidates();
    }

}