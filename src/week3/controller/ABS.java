package controller;

import model.*;
import view.*;
import java.util.*;

public class ABS {
    private int msgCount;
    private boolean d;
    private HashMap save;

    private List<Person> persons;
    private List<Flight> flights;

    public ABS(){
        msgCount = -1;
        d = false;
        save = new HashMap(20);
        persons = new ArrayList<Person>();
        flights = new ArrayList<Flight>();
    }

    public void getMessageFromClient(String message){
        if(msgCount == -1){
            if (message.equals("np")){
                msgCount = 0;
                createPerson();
            }
            else if (message.equals("nf")){
                msgCount = 0;
                createFlight();
            }
            else if (message.equals("nl")){
                msgCount = 0;
                createLocation();
            }
            else if (message.equals("na")){
                msgCount = 0;
                createAirplane();
            }
            else if (message.equals("nb")){
                msgCount = 0;
                createBooking();
            }
        }
        else {
            d = false;
            save.put(msgCount, message);
            msgCount++;
        }
    }

    public String gets(int msgCount){
        return (String)save.get(msgCount);
    }

    public void createPerson(){
        boolean create = true;
        while(create){
            if(d == false) {
                switch(msgCount){
                    case 0: p("Initials?"); d = true; break;
                    case 1: p("Last name?"); d = true; break;
                    case 2: p("Gender? [m/f]"); d = true; break;
                    case 3: p("Address?"); d = true; break;
                    case 4: p("House number?"); d = true; break;
                    case 5: p("Postal code?"); d = true; break;
                    case 6: p("Country?"); d = true; break;
                    case 7: p("Passport ID?"); d = true; break;
                    case 8: create = false;
                }
            }
        }
        persons.add(new Passenger(persons.size(), gets(0), gets(1), gets(2).charAt(0), gets(3), Integer.parseInt(gets(4)), gets(5), gets(6), gets(7)));
        p("Person added.");
    }

    public void createFlight(){}

    public void createLocation(){}

    public void createAirplane(){}

    public void createBooking(){}

    public void p(String msg){
        System.out.println(msg);
    }

}
