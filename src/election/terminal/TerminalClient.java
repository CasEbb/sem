package election.terminal;

import election.model.*;
import ocsf.client.AbstractClient;

import java.io.IOException;

/**
 * TerminalClient is a class to connect
 * to the Backend and fetch Polling Info.
 */
public class TerminalClient extends AbstractClient {

    private TerminalTUI tui;

    /**
     * Initializes a new TerminalClient object.
     * @param host the host to connect to.
     * @param port the port to connect on.
     * @param tui the TerminalTUI to maintain.
     */
    public TerminalClient(String host, int port, TerminalTUI tui) {
        super(host, port);
        this.tui = tui;
    }

    @Override
    protected void connectionEstablished() {
        try {
            sendToServer("gps " + tui.getPollID());
        }
        catch (IOException e) { }
    }

    @Override
    protected void handleMessageFromServer(Object msg) {
        if(msg instanceof Poll) {
            tui.setPoll((Poll)msg);
        }
    }
}
