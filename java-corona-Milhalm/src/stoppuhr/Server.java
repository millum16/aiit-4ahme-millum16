package stoppuhr;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lukasmilhalm
 */
public class Server {

    private ServerSocket serverSocket;
    private final List<ConnectionHandler> handlers;
    private long timeOffset;
    private long startMillis;

    public Server() {
        this.handlers = new LinkedList<>();
    }

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        timeOffset = 0;

        while (true) {
            Socket clientSocket = serverSocket.accept();
            ConnectionHandler h = new ConnectionHandler(clientSocket);
            handlers.add(h);
        }
    }

    public boolean isTimerRunning() {
        synchronized (this.handlers) {
            return startMillis > 0;
        }
    }

    public long getTimerMillis() {
        return timeOffset;

    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(8080);
    }

    public class ConnectionHandler implements Runnable {

        private Socket socket;
        private boolean master;

        private ConnectionHandler(Socket clientSocket) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public void ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        public boolean isClosed() {
            return this.socket.isClosed();
        }

        public boolean isMaster() {
            return this.master;
        }

        public void run() {

        }

    }
}
