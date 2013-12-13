package week3.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import week3.controller.ABS;

public class ABSConsole {
    private ABS abs;
	
	public ABSConsole(){
	    abs = new ABS();
	}

    /**
     * This method waits for input from the console.
     */
    public void accept() {
        try {
            BufferedReader fromConsole = new BufferedReader(
                    new InputStreamReader(System.in));
            String message;
            boolean doorgaan = true;
            while (doorgaan) {
                message = fromConsole.readLine();
                if(message.contains("book")){
                    String[] params = message.split(" ");
                    abs.book(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
                }
                if(message.contains("isBooked")){
                    String[] params = message.split(" ");
                    boolean isBooked = abs.isBooked(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
                    System.out.format("isBooked: %b", isBooked);
                }
                if(message.contains("quit")){
                    doorgaan = false;
                }
            }
        } catch (Exception ex) {
            System.out.println("Unexpected error while reading from console!");
        }
    }
	
	public static void main(String[] args){
		ABSConsole absc = new ABSConsole();

        absc.accept();
	}
}
