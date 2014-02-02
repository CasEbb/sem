package election.terminal;

import election.model.*;
import ocsf.client.AbstractClient;

import java.io.IOException;

public class TerminalClient extends AbstractClient {

    private TerminalTUI tui;

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
