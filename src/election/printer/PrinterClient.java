package election.printer;

import election.model.Poll;
import ocsf.client.AbstractClient;

public class PrinterClient extends AbstractClient {

    PrinterTUI tui;

    public PrinterClient(String host, int port, PrinterTUI tui) {
        super(host, port);
        this.tui = tui;

    }

    /**
     * Handles messages sent by the server.
     * E.g.     - activate the printer client
     *          - load Poll data
     * @param msg   the message sent.
     */
    @Override
    protected void handleMessageFromServer(Object msg) {
        if(msg instanceof String) {
            String message = (String)msg;
            if(message.equals("activate")) {
                tui.activate();
            }
        }

        else if(msg instanceof Poll) {
            tui.setPoll((Poll)msg);
        }
    }
}
