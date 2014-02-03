package election.terminal;

import election.model.Tally;
import ocsf.server.AbstractServer;
import ocsf.server.ConnectionToClient;

import java.io.IOException;
import java.util.List;

/**
 * TerminalServer class is used to allow
 * printers to connect to the Terminal.
 */
public class TerminalServer extends AbstractServer {

    /** The TUI */
    private TerminalTUI tui;
    /** A list of clients */
    private List<ConnectionToClient> clients;

    /**
     * TerminalServer class is used to create a connection for printers
     * @param port the port to connect on.
     * @param tui the TerminalTUI to maintain.
     */
    public TerminalServer(int port, TerminalTUI tui) {
        super(port);
        this.tui = tui;
    }

    /**
     * Is triggered when a client (a printer) connects.
     * @param client the connection connected to the client.
     */
    @Override
    protected void clientConnected(ConnectionToClient client) {
        clients.add(client);
        tui.setClients(clients);
        try { client.sendToClient(tui.getPoll()); }
        catch (IOException e) {}
    }

    /**
     * Handles message from the client (the printer).
     * @param msg   the message sent.
     * @param client the connection connected to the client that
     */
    @Override
    protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
        if(msg instanceof Tally) {
            tui.setTally((Tally)msg);
        }
    }
}
