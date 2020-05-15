package stoppuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
            final Socket socket = serverSocket.accept();
            for (ConnectionHandler h : handlers) {
                if (h.isClosed()) {
                    handlers.remove(h);
                }
            }

            if (handlers.size() == 3) {
                socket.close();
                continue;
            }

            final ConnectionHandler handler = new ConnectionHandler(socket);
            new Thread(handler).start();
            handlers.add(handler);
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

        private ConnectionHandler(Socket socket) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

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
            int count = 0;

            while (true) {
                try {
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                    final String line = reader.readLine();
                    count++;
                    final Gson gson = new Gson();
                    gson.toJson(line);
                    final Request r = gson.fromJson(line, Request.class);

                    if (r.isMaster()) {
                        boolean setMasterTrue = true;
                        for (ConnectionHandler c : handlers) {
                            if (!c.equals(this) && c.isMaster() == true) {
                                setMasterTrue = false;
                                break;
                            }
                        }

                        master = setMasterTrue;
                    }

                    if (r.isMaster()) {
                        if (r.isStart()) {
                            startMillis = System.currentTimeMillis();
                        }

                        if (r.isStop()) {
                            startMillis = 0;
                        } else {
                            timeOffset = System.currentTimeMillis() - startMillis + timeOffset;
                        }

                        if (r.isClear()) {
                            timeOffset = 0;
                            if (isTimerRunning()) {
                                startMillis = System.currentTimeMillis();
                            } else {
                                startMillis = 0;
                            }
                        }

                        if (r.isEnd()) {
                            serverSocket.close();
                            socket.close();
                            synchronized (socket) {

                            }

                            handlers.remove(this);
                            return;
                        }
                    }

                    final Response resp = new Response(master, count, isTimerRunning(), getTimerMillis());
                    final String respString = gson.toJson(resp);
                    writer.write(respString);
                    writer.flush();

                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }
        }
    }
}
