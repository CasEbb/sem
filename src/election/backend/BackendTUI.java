package election.backend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import election.model.Body;
import election.model.Person;

public class BackendTUI {
	
	private Scanner keyboard = new Scanner(System.in);
	
	private List<Person> people = new ArrayList<Person>();
	private List<Body> bodies = new ArrayList<Body>();
	
	public void mainMenu() {
		while(true) {
			clearScreen();
			System.out.println("1) Manage bodies                   [MAIN MENU]");
			System.out.println("2) Manage people                              ");
			System.out.print("Choice [1-2]: ");
			
			switch(getChoice()) {
			case 1:
				mainMenu();
				break;
			case 2:
				peopleMenu();
				break;
			default:
				break;
			}
		}
	}
	
	private void peopleMenu() {
		while(true) {
			clearScreen();
			System.out.println("1) Add new person              [MANAGE PEOPLE]");
			System.out.println("2) Search for person                          ");
			System.out.println("3) *** Back to main                           ");
			System.out.print("Choice [1-3]: ");
			
			switch(getChoice()) {
			case 1:
				addPersonMenu();
				break;
			case 2:
				searchPersonMenu();
				break;
			case 3:
				return;
			default:
				break;
			}
		}
	}
	
	private void addPersonMenu() {
		try {
			System.out.print("Enter name      > ");
			String name = keyboard.nextLine();
			System.out.print("Enter address   > ");
			String address = keyboard.nextLine();
			System.out.print("Add person [" + name + ", " + address + "]? Enter '1' to confirm: ");
			
			switch(getChoice()) {
			case 1:
				people.add(new Person(name, address));
				return;
			default:
				System.out.println("Not confirmed, aborting insertion.");
				pause();
				return;
			}
		} catch (Exception e) {
			System.out.println("Input error, aborting insertion.");
			pause();
			return;
		}
	}
	
	private void searchPersonMenu() {
		List<Person> results = new ArrayList<Person>();
		
		try {
			System.out.print("Enter search query   > ");
			String query = keyboard.nextLine();
			
			for(Person person : people) {
				if(person.getName().contains(query)) {
					results.add(person);
				}
			}
			
			if(results.size() > 15) {
				System.out.println("Too many results, try a narrower search.");
				pause();
				return;
			} else if(results.size() == 0) {
				System.out.println("No results.");
				pause();
				return;
			}
			
			int counter = 1;
			for(Person person : results) {
				System.out.println("0) *** Cancel");
				System.out.println("" + counter + ") " + person.getName() + ", " + person.getAddress());
			}
			System.out.print("Pick a result: ");
			int result = getChoice();
			
			if(result == 0 || result < 0 || result > results.size()) {
				return;
			}
			
			personMenu(results.get(result - 1));
		} catch(Exception e) {
			
		}
	}
	
	private void personMenu(Person p) {
		clearScreen();
		System.out.println("*** PERSON: [" + p.getName() + ", " + p.getAddress() + "]");
		System.out.println("1) Edit");
		System.out.println("2) Delete");
		System.out.println("3) *** Abort");
		System.out.print("Choice [1-3]: ");
		
		switch(getChoice()) {
		case 1:
			System.out.print("New name? Leave blank for no change      > ");
			String name = keyboard.nextLine();
			if(name.length() > 0)
			return;
		case 2:
			System.out.print("Confirm delete? Enter '1': ");
			if(getChoice() == 1) {
				people.remove(p);
				System.out.println("Person removed! Press a key to continue...");
				pause();
			}
			return;
		case 3:
		default:
			return;
		}
	}

	private void clearScreen() {
		for(int i = 0; i < 25; i++) { System.out.println(); }
		System.out.println("          OOTUMLIA ELECTION MANAGEMENT        ");
		System.out.println("         SERVER ADMINISTRATION TERMINAL       ");
		System.out.println("______________________________________________");
	}
	
	private int getChoice() {
		Scanner line = new Scanner(keyboard.nextLine());
		int result;
		
		if(line.hasNextInt()) {
			result = line.nextInt();
		} else {
			result = -1;
		}
		
		line.close();
		return result;
	}
	
	private void pause() {
		try {
			System.in.read();
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		// boot server
		//Runnable serverThread = new BackendServer(9667);
		//1new Thread(serverThread).start();

		new BackendTUI().mainMenu();
	}

}
