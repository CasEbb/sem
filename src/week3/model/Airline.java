package model;

import java.util.*;

public class Airline {
    // Attributes
    private String name;

    // Connections
    private List<Employee> employees;
    private List<Flight> flights;

    public Airline(String name){
        this.name = name;

        this.employees = new ArrayList<Employee>();
        this.flights = new ArrayList<Flight>();
    }

    public void addEmployee(Employee e){ employees.add(e); }
    public void addFlight(Flight f){ flights.add(f); }


}
