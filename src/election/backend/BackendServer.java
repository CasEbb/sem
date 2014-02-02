package election.backend;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;
import election.model.Poll;

public class BackendServer extends AbstractServer {

	BackendTUI backend;

	public BackendServer(int port, BackendTUI backend) {
		super(port);
		this.backend = backend;
	}

	@Override
	protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		try {
			String msgString = String.valueOf(msg);
	
			if (msgString.substring(0, 3).equals("gps")) {
				Poll result = null;
				int id = Integer.parseInt(msgString.split(" ")[1]);
				for (Poll p : backend.polls) {
					if(p.getStationNumber() == id) {
						result = p;
						break;
					}
				}
				if(result != null) {
					client.sendToClient(result);
				}
			}
		} catch(Exception e) {
		}
	}

}
