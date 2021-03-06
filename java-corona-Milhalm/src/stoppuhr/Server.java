package stoppuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
    private final List<ConnectionHandler> handlers = new LinkedList<ConnectionHandler>();
    private long timeOffset;
    private long startMillis;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server auf Port " + port + "gestartet!");

        while (true) {
            Socket socket = serverSocket.accept();

            synchronized (handlers) {
                for (int i = 0; i < handlers.size(); i++) {
                    ConnectionHandler h = handlers.get(i);
                    if (h.isClosed()) {
                        handlers.remove(i--);
                    }
                }

                if (handlers.size() < 3) {
                    ConnectionHandler h = new ConnectionHandler(socket);
                    handlers.add(h);
                    new Thread(h).start();
                } else {
                    System.out.println("Connection refused (" + socket.toString() + ")");
                    socket.close();
                }
            }
        }
    }

    public boolean isTimeRunning() {
        synchronized (handlers) {
            return startMillis > 0;
        }
    }

    public long getTimeMillis() {
        synchronized (handlers) {
            if (startMillis == 0) {
                return timeOffset;
            } else {
                return (System.currentTimeMillis() - startMillis) + timeOffset;
            }
        }
    }

    //---------------------------------------------------------------------------
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.start(8080);
    }

    //---------------------------------------------------------------------------
    private class ConnectionHandler extends Thread {

        private Socket socket;
        private boolean master;

        public ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        public boolean isClosed() {
            return socket.isClosed();
        }

        public boolean isMaster() {
            return master;
        }

        @Override
        public void run() { //für die Hintergrundthreads
            long count = 0;

            try {
                System.out.println("ServerHandler Thread gestartet, Socket: " + socket);
                final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                final BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                final Gson gson = new Gson();
                count++;

                while (true) {
                    final String line = in.readLine(); //Zeichen werden in line gespeichert
                    if (line == null) {
                        socket.close();
                        return;
                    }

                    gson.toJson(line);//die neuen Zeilen werden in ein Objekt gespeichert
                    System.out.println(line);
                    final Request req = gson.fromJson(line, Request.class); //neues Request Objekt, welches die Zeichen beinhaltet
                    System.out.println(req);

                    if (req.master != null) {
                        if (req.master) {
                            ConnectionHandler currentMaster = null;

                            synchronized (handlers) {
                                for (ConnectionHandler c : handlers) {
                                    if (c.isMaster() && !c.isClosed()) {
                                        currentMaster = c;

                                        break;
                                    }
                                }
                                if (currentMaster == null) {
                                    master = true;
                                }
                            }
                        } else {
                            master = false;
                        }
                    }

                    synchronized (handlers) {
                        if (master) {
                            if (req.isStart()) {
                                startMillis = System.currentTimeMillis();
                            }

                            if (req.isClear()) {
                                if (isTimeRunning()) {
                                    startMillis = System.currentTimeMillis();
                                }
                                timeOffset = 0;
                            }

                            if (req.isStop()) {
                                timeOffset = getTimeMillis();
                                startMillis = 0;
                            }

                            if (req.isEnd()) {

                                handlers.remove(this);
                                //Server schließen-----------------------------
                                serverSocket.close();
                                socket.close();
                                return;
                            }
                        }
                    }

                    //Response
                    final Response resp = new Response(master, count, isTimeRunning(), getTimeMillis());
                    System.out.println(resp);
                    final String respString = gson.toJson(resp);
                    System.out.println(respString);
                    out.write(respString);
                    out.flush();

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

//--------------------------------------------------------------------------
    public static class Request {

        public Boolean master;
        public Boolean start;
        public Boolean stop;
        public Boolean clear;
        public Boolean end;

        public boolean isMaster() {
            return master != null && master;
        }

        public boolean isStart() {
            return start != null && start;
        }

        public boolean isStop() {
            return stop != null && stop;
        }

        public boolean isClear() {
            return clear != null && clear;
        }

        public boolean isEnd() {
            return end != null && end;
        }

        @Override
        public String toString() {
            return "Request{" + "master=" + master + ", start=" + start + ", stop=" + stop + ", clear=" + clear + ", end=" + end + '}';
        }

    }

//--------------------------------------------------------------------------
    public class Response {

        public Boolean master;
        public Long count;
        public Boolean running;
        public Long time;

        private Response(boolean master, Long count, boolean timeRunning, long timeMillis) {
            this.master = master;
            this.count = count;
            this.time = timeMillis;
            this.running = timeRunning;

        }

        public Boolean isMaster() {
            return master;
        }

        public Boolean isRunning() {
            return running;
        }

        public Long getCount() {
            return count;
        }

        public Long getTime() {
            return time;
        }

        public void setMaster(Boolean master) {
            this.master = master;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public void setRunning(Boolean running) {
            this.running = running;
        }

        public void setTime(Long time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Response{" + "master=" + master + ", count=" + count + ", running=" + running + ", time=" + time + '}';
        }

    }
}
