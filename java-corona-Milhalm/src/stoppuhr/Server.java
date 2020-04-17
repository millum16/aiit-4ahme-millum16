package stoppuhr;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lukasmilhalm
 */
public class Server {

    private ServerSocket serverSocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    private long timeOffset;
    private long startMillis;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);

        while (true) {
            final Socket clientSocket = serverSocket.accept();
            final ConnectionHandler handler = new ConnectionHandler(clientSocket);
            new Thread(handler).start();
            handlers.add(handler);

        }
    }

    public void isTimerRunning() {

    }

    public long getTimerMillis() {

        return 0;
    }

    public static void main(String[] args) {
        new Server();
    }
}
