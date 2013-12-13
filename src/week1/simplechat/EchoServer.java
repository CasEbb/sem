package week1.simplechat;

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com

import java.io.IOException;

import week1.ocsf.server.AbstractServer;
import week1.ocsf.server.ConnectionToClient;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 * 
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer {
	// Class variables *************************************************

	/** The default port to listen on. */
	final public static int DEFAULT_PORT = 5555;
	/** Message which is received when a client quits properly. */
	final public static String QUIT_MESSAGE = "quit";
	/** 
	 * Message to be sent to ask for the password.
	 */
	final public static String PASSWORD_MESSAGE = "?password?";
	/**
	 * Message to be sent to ask for preferred username.
	 */
	final public static String USERNAME_MESSAGE = "?username?";
	
	// Instance variables **********************************************
	/** Password required to connect to the server. */
	private String password;
	private String motd;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the echo server.
	 * 
	 * @param port
	 *            The port number to connect on.
	 */
	public EchoServer(int port, String password, String motd) {
		super(port);
		this.password = password;
		this.motd = motd;
	}

	// Instance methods ************************************************

	/**
	 * This method handles any messages received from the client.
	 * 
	 * @param msg
	 *            The message received from the client.
	 * @param client
	 *            The connection from which the message originated.
	 */
	public void handleMessageFromClient(Object msg, ConnectionToClient client) {
		int msgCount = (int)client.getInfo("messageCount");
		String message = msg.toString();
		// 2.1.1 R1
		if(message.indexOf("ww ") == 0 && msgCount == 0){
			String wachtwoord = message.split(" ")[1];
			if(wachtwoord.equals(password)){
				client.setInfo("messageCount", msgCount+1);
				try{ client.sendToClient(USERNAME_MESSAGE); }
				catch (IOException e){ }
			} else {
				try { client.close(); } 
				catch (IOException e) { }
			}
		}
		// 2.1.1 R2
		else if(message.indexOf("un ") == 0 && msgCount == 1){
			String username = message.split(" ")[1];
			client.setInfo("messageCount", msgCount+1);
			client.setInfo("username", username);
		}
		// 2.1.1 R3
		else if(msg.toString().equals(QUIT_MESSAGE)){
			try{ client.close(); }
			catch (IOException e){ }
		}
		else if(msgCount > 1){
			String username = client.getInfo("username").toString();
			client.setInfo("messageCount", msgCount+1);
			System.out.println("Message received: " + msg + " from " + username);
			this.sendToAllClients(username + ": " + msg);
		}
		else {
			try{ client.close(); }
			catch (IOException e){ }
		}
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * starts listening for connections.
	 */
	protected void serverStarted() {
		System.out.println("Server listening for connections on port "
				+ getPort());
	}

	/**
	 * This method overrides the one in the superclass. Called when the server
	 * stops listening for connections.
	 */
	protected void serverStopped() {
		System.out.println("Server has stopped listening for connections.");
	}

	// Class methods ***************************************************

	// 1.2.3
	@Override
	protected void clientConnected(ConnectionToClient client) {
		System.out.println("C: Client (" + client.getInetAddress()
				+ ") has connected.");
		// 2.1.1 R1
		try{
			client.setInfo("messageCount", 0);
			client.setInfo("username", "s"+Math.round(Math.random()*1000));
			client.sendToClient(PASSWORD_MESSAGE);
			
			if(this.motd != null) {
				client.sendToClient("Server MOTD: " + this.motd);
			}
		} catch (IOException e){ }
	}

	@Override
	protected synchronized void clientDisconnected(ConnectionToClient client) {
		System.out.println("D: Client (" + client.getInetAddress()
				+ ") has disconnected.");
	}

	@Override
	protected synchronized void clientException(ConnectionToClient client,
			Throwable exception) {
		System.out.println("E: Client (" + client.getInetAddress()
				+ ") has disconnected.");
	}

	/**
	 * This method is responsible for the creation of the server instance (there
	 * is no UI in this phase).
	 * 
	 * @param args
	 *            [0] The port number to listen on. Defaults to 5555 if no
	 *            argument is entered.
	 *            [1] The password required for clients to send when they 
	 *            connect. Connection is refused when password doesn't match
	 */
	public static void main(String[] args) {
		int port = 0; // Port to listen on
		String password = ""; // Password
		String motd;

		try {
			port = Integer.parseInt(args[0]); // Get port from command line
		} catch (Throwable t) {
			port = DEFAULT_PORT; // Set port to 5555
		}
		// 2.1.1 R1
		try {
			password = args[1]; // Get password from command line
		} catch (Throwable t) {
			password = ""; // Set password to ""
		}
		// 2.1.1 R6
		try {
			motd = args[2];
		} catch (Throwable t) {
			motd = null;
		}

		EchoServer sv = new EchoServer(port, password, motd);

		try {
			sv.listen(); // Start listening for connections
		} catch (Exception ex) {
			System.out.println("ERROR - Could not listen for clients!");
		}
	}

}
// End of EchoServer class
