package view;

import controller.*;
import java.io.*;
import java.lang.*;

public class ABSConsole {
    private ABS abs;
	
	public ABSConsole(){
	    abs = new ABS();
	}

    /**
     * This method waits for input from the console. Once it is received, it
     * sends it to the client's message handler.
     */
    public void accept() {
        try {
            BufferedReader fromConsole = new BufferedReader(
                    new InputStreamReader(System.in));
            String message;

            while (true) {
                message = fromConsole.readLine();
                abs.getMessageFromClient(message);
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
