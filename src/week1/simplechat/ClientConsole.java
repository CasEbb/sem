package week1.simplechat;

// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import week1.simplechat.client.ChatClient;
import week1.simplechat.common.ChatIF;

/**
 * This class constructs the UI for a chat client. It implements the chat
 * interface in order to activate the display() method. Warning: Some of the
 * code here is cloned in ServerConsole
 * 
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @version July 2000
 */
public class ClientConsole implements ChatIF {
	// Class variables *************************************************

	/** The default port to connect on. */
	final public static int DEFAULT_PORT = 5555;

	// Instance variables **********************************************

	/** The instance of the client that created this ConsoleChat. */
	ChatClient client;

	// Constructors ****************************************************

	/**
	 * Constructs an instance of the ClientConsole UI.
	 * 
	 * @param host
	 *            The host to connect to.
	 * @param port
	 *            The port to connect on.
	 * @param password
	 * 			  The password required to connect.
	 * @param username
	 * 			  The preferred username. Defaults to "guest{3}[0-9]"
	 */
	public ClientConsole(String host, int port, String password, String username) {
		try {
			client = new ChatClient(host, port, password, username, this);
		} catch (IOException exception) {
			System.out.println("Error: Can't setup connection!"
					+ " Terminating client.");
			System.exit(1);
		}
	}

	// Instance methods ************************************************

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
				client.handleMessageFromClientUI(message);
			}
		} catch (Exception ex) {
			System.out.println("Unexpected error while reading from console!");
		}
	}

	/**
	 * This method overrides the method in the ChatIF interface. It displays a
	 * message onto the screen.
	 * 
	 * @param message
	 *            The string to be displayed.
	 */
	public void display(String message) {
		System.out.println("> " + message);
	}

	// Class methods ***************************************************
	
	/**
	 * This method provides a way to format the command line arguments
	 * according to their function, without referring to their position.
	 * @since 2.1.1 R4
	 * @param args Arguments provided by commandline.
	 * @return options
	 * 					[0] The host to connect to.
	 * 					[1] The port to connect to.
	 * 					[2] The password to connect.
	 * 					[3] The preferred username.
	 */
	private static String[] formatCLOptions(String[] args){
		String[] options = new String[4];
		options[0] = "localhost";
		options[1] = ((Integer)DEFAULT_PORT).toString();
		options[2] = "";
		options[3] = "guest"+Math.round(Math.random()*1000);
		for( int i = 0; i < args.length ; i++ ){
			// check whether next index exists and whether the next
			// index isn't a key
			if(i+1 < args.length && args[i+1].indexOf("-") != 0){
				if(args[i].equals("-h")){ 
					try{
						options[0] = args[i+1]; 
					} catch (ArrayIndexOutOfBoundsException e){ }
				}
				else if(args[i].equals("-p")){ 
					try{
						options[1] = args[i+1]; 
					} catch (ArrayIndexOutOfBoundsException e){ }
				}
				else if(args[i].equals("-w")){ 
					try{
						options[2] = args[i+1]; 
					} catch (ArrayIndexOutOfBoundsException e){ }
				}
				else if(args[i].equals("-u")){ 
					try{
						options[3] = args[i+1]; 
					} catch (ArrayIndexOutOfBoundsException e){ }
				}
			}
		}
		return options;
	}

	/**
	 * This method is responsible for the creation of the Client UI.
	 * 
	 * @param args
	 *            -h The host to connect to.
	 *            -p The port to connect to.
	 *            -w The password to connect.
	 *            -u The preferred username.
	 */
	public static void main(String[] args) {
		// 2.1.1
		if(args.length >= 1 && args[0].equals("--help")) {
			System.out.println();
			System.out.println("SimpleChat client (a SEM project by L.E.F.)");
			System.out.println();
			System.out.println("  command line options:");
			System.out.println("  -h <host>      host to connect to (hostname/ip, default: localhost)");
			System.out.println("  -p <port>      TCP port on host (default: 5555)");
			System.out.println("  -w <password>  server password");
			System.out.println("  -u <username>  preferred chat username (default: guest)");
			System.exit(0);
		}
		
		String[] options = formatCLOptions(args);
		
		ClientConsole chat = new ClientConsole(options[0], Integer.parseInt(options[1]), options[2], options[3]);
		chat.accept(); // Wait for console data
	}
}
// End of ConsoleChat class
