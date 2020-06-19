package stoppuhr;

import java.io.IOException;
import java.net.Socket;
import javax.swing.SwingWorker;
import stoppuhr.Server.Response;

/**
 *
 * @author lukasmilhalm
 */
public abstract class ConnectionWorker extends SwingWorker<String, Response> {

    private Response resp;
    public Socket socket;

    public ConnectionWorker(int port, String hostName) throws IOException {
        socket = new Socket(hostName, port);
    }
}
