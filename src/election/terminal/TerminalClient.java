package election.terminal;

import ocsf.client.AbstractClient;

import java.io.IOException;

public class TerminalClient extends AbstractClient {

    private TerminalTUI tui;

    public TerminalClient(String host, int port, TerminalTUI tui) {
        super(host, port);
        this.tui = tui;
    }

    @Override
    protected void handleMessageFromServer(Object msg) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
