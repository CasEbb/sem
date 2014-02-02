package election.printer;

import ocsf.client.AbstractClient;

public class PrinterClient extends AbstractClient {

    PrinterTUI tui;

    public PrinterClient(String host, int port, PrinterTUI tui) {
        super(host, port);
        this.tui = tui;

    }

    @Override
    protected void handleMessageFromServer(Object msg) {
        String message = (String)msg;
        if(message.equals("activate")) {
            tui.activate();
        }
    }
}
