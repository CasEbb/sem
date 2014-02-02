package election.backend;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class BackendServer extends AbstractServer {

	public BackendServer(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		// TODO Auto-generated method stub

	}

}
