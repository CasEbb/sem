package week3.model;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    // Connections
    private List<Employee> employees;
    private List<Flight> flights;

    public Airline(String name){
        this.employees = new ArrayList<Employee>();
        this.flights = new ArrayList<Flight>();
    }

    public void addEmployee(Employee e){ employees.add(e); }
    public void addFlight(Flight f){ flights.add(f); }


}
