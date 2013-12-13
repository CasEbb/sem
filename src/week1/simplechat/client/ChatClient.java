// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com

package week1.simplechat.client;

import java.io.IOException;

import week1.ocsf.client.AbstractClient;
import week1.simplechat.common.ChatIF;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 * 
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient {
	// Class variables *************************************************
	
	/** Message to be sent when a user wants to quit. */
	final public static String QUIT_MESSAGE = "quit";
	/** 
	 * Message which is received from the server, requesting
	 * the password to connect.
	 */
	final public static String PASSWORD_MESSAGE = "?password?";
	/**
	 * Message received from the server, requesting preferred
	 * username.
	 */
	final public static String USERNAME_MESSAGE = "?username?";
	
	// Instance variables **********************************************

	/**
	 * The interface type variable. It allows the implementation of the display
	 * method in the client.
	 */
	ChatIF clientUI;
	/** Password required to connect to the server. */
	private String password;
	/** The preferred username. Defaults to "guest{3}[0-9]" */
	private String username;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the chat client.
	 * 
	 * @param host
	 *            The server to connect to.
	 * @param port
	 *            The port number to connect on.
	 * @param password
	 * 			  The password required to connect.
	 * @param username
	 * 			  The preferred username. Defaults to "guest{3}[0-9]"
	 * @param clientUI
	 *            The interface type variable.
	 */

	public ChatClient(String host, int port, String password, String username, ChatIF clientUI)
			throws IOException {
		super(host, port); // Call the superclass constructor
		this.clientUI = clientUI;
		this.password = password; // 2.1.1 R1
		this.username = username; // 2.1.1 R2
		openConnection();
	}

	// Instance methods ************************************************

	/**
	 * This method handles all data that comes in from the server.
	 * 
	 * @param msg
	 *            The message from the server.
	 */
	public void handleMessageFromServer(Object msg) {
		String message = msg.toString();
		// 2.1.1 R1
		if(message.equals(PASSWORD_MESSAGE)){
			try { sendToServer("ww "+password); } 
			catch (IOException e) { quit(); }
		}
		// 2.1.1 R2
		else if(message.equals(USERNAME_MESSAGE)){
			try { sendToServer("un "+username); }
			catch (IOException e) { quit(); }
		}
		else{ 
			clientUI.display(msg.toString());
		}
	}

	/**
	 * This method handles all data coming from the UI
	 * 
	 * @param message
	 *            The message from the UI.
	 */
	public void handleMessageFromClientUI(String message) {
		try { 
			sendToServer(message);
		} catch (IOException e) {
			clientUI.display("Could not send message to server.  Terminating client.");
			quit();
		}
		// 2.1.1 R3
		if(message.equals(QUIT_MESSAGE)) {
			System.out.println("Terminating client.");
			quit();
		}
	}

	// 1.2.1
	public void connectionClosed() {
		System.out.println("Connection closed.");
	}

	public void connectionException(Exception e) {
		quit();
	}

	/**
	 * This method terminates the client.
	 */
	public void quit() {
		try {
			closeConnection();
		} catch (IOException e) {
		} 
		System.exit(0);
	}
}
// End of ChatClient class
