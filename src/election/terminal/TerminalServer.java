package election.terminal;

import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

public class TerminalServer extends AbstractServer {

    private TerminalTUI tui;

    public TerminalServer(int port, TerminalTUI tui) {
        super(port);
        this.tui = tui;

    }

    @Override
    protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
