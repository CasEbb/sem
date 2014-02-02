package election.printer;

import election.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;

public class PrinterTUI {
    private boolean isActive;
    private Poll poll;
    private int pollID;
    private int electionID;

    private int clientPort = 9778;

    public PrinterTUI(String host, int pollID, int electionID) {
        this.isActive = false;
        this.pollID = pollID;

        populate();

        new Thread(new PrinterClient(host, this.clientPort, this));
    }

    /**
     * Activate the vote printer.
     */
    protected void activate() {
        isActive = true;
        viewCandidates();
    }

    /**
     * Deactivate the vote printer. This is done every time a vote is printed
     * or on command (e.g. when the election is over).
     */
    protected void deactivate() {
        isActive = false;
    }

    /**
     * View candidates for this Poll and Election
     */
    private void viewCandidates() {
        String candidatesList = "";
        candidatesList += String.format("%d: %s\n", 0, "No vote");
        for(int i = 1; i <= this.poll.getElection().getCandidates().size(); i++) {
            String name = this.poll.getElection().getCandidates().get(i-1).getPerson().getName();
            String address = this.poll.getElection().getCandidates().get(i-1).getPerson().getAddress();
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
                String name = this.poll.getElection().getCandidates().get(candidateID - 1).getPerson().getName();
                String address = this.poll.getElection().getCandidates().get(candidateID - 1).getPerson().getAddress();
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
                    printVote(candidateID - 1);
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
        try {
            int[] a = new int[5];
            for(int i = 0; i < 6; i++) { a[i] = (int)Math.random()*26; }
            String fileName = String.format("%d%d%d%d%d%d.txt", a[0], a[1], a[2], a[3], a[4], a[5]);

            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            String name = this.poll.getElection().getCandidates().get(candidateID).getPerson().getName();
            String address = this.poll.getElection().getCandidates().get(candidateID).getPerson().getAddress();

            writer.format("Poll: %d\n", this.poll.getStationNumber());
            writer.format("Election: %s\n", this.poll.getElection().getElectionDate().toString());
            writer.format("Candidate of choice: [%d] %s, %s", candidateID, name, address);
            writer.close();

            deactivate();
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (UnsupportedEncodingException e) { e.printStackTrace(); }
    }

    /**
     * Populate the class with test data
     */
    private void populate() {

        // New Date for Election
        Date d1 = new Date(2014, 01, 01);

        // Create Election (ID, Date)
        Election e1 = new Election(500, d1);

        // Instantiate Poll (ID, Election)
        poll = new Poll(5, e1);

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

        // Seats (Name, Body)
        Seat se1 = new Seat("Veurzitter");
        Seat se2 = new Seat("Secretaris");
        Seat se3 = new Seat("Penningmeester");

        // Body (Name)
        Body b1 = new Body("Jaarclub", new ArrayList<Seat>());

        // Candidates (Election, Person)
        Candidate c1 = new Candidate(e1, p1);
        Candidate c2 = new Candidate(e1, p2);
        Candidate c3 = new Candidate(e1, p3);

        // Add Candidates to Elections
        e1.getCandidates().add(c1);
        e1.getCandidates().add(c2);
        e1.getCandidates().add(c3);
    }

    /**
     * Set method to load data
     * @param poll Poll object to get the data from
     */
    protected void setPoll(Poll poll) {
        this.poll = poll;
    }

    public static void main(String[] args) {
        String host = args[0];
        int pollID = Integer.parseInt(args[1]);
        int electionID = Integer.parseInt(args[2]);

        new PrinterTUI(host, pollID, electionID);
    }

}
