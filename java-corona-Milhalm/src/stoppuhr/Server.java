package stoppuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            final Socket clientSocket = serverSocket.accept();
            if (handlers.size() < 3) {
                final ConnectionHandler handler = new ConnectionHandler(clientSocket);
                new Thread(handler).start();
                handlers.add(handler);
            } else {
                clientSocket.close();
            }
        }
    }

    public boolean isTimerRunning() {
        return startMillis > 0;
    }

    public long getTimerMillis() {
        if (startMillis == 0) {
            return timeOffset;
        } else {
            return timeOffset + (System.currentTimeMillis() - startMillis);
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(8080);
    }

    public class ConnectionHandler implements Runnable {

        private Socket socket;
        private boolean master;

        public void ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        public boolean isClosed() {
            return this.socket.isClosed();
        }

        public boolean isMaster() {
            return master;
        }

        @Override
        public void run() {
            try {

                while (true) {

                }

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                final String line = reader.readLine();

                Gson gson = new Gson();
                gson.toJson(line);

                final Request r = gson.fromJson(line, Request.class);

                if (r.isMaster()) {
                    for (ConnectionHandler c : handlers) {
                        this.master = true;
                        if (c != this && c.isMaster() == true) {
                            master = false;
                            break;
                        }
                    }
                }

                if (master == true) {
                    if (r.isStart()) {
                        startMillis = System.currentTimeMillis();
                    }
                }

                if (r.isClear()) {
                    if (isTimerRunning()) {
                        startMillis = System.currentTimeMillis();
                    }
                    timeOffset = 0;
                }

                if (r.isStop()) {
                    timeOffset = getTimerMillis();
                    startMillis = 0;
                }

                if (r.isEnd()) {
                    // Server Application schließen
                    handlers.remove(this);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
