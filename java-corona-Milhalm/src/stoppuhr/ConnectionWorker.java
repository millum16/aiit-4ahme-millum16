package stoppuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.swing.SwingWorker;
import stoppuhr.Server.Request;
import stoppuhr.Server.Response;

/**
 *
 * @author lukasmilhalm
 */
public abstract class ConnectionWorker extends SwingWorker<Object, Response> {

    private Response resp;
    public Socket socket;

    public ConnectionWorker(int port, String hostName) throws IOException {
        socket = new Socket(hostName, port);
    }

    @Override
    protected Object doInBackground() throws Exception {
        final Gson g = new Gson();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());

        while (true) {
            try {
                final Request req = new Request();
                req.master = true;
                final String resString = g.toJson(req);
                writer.write(resString);
                writer.flush();

                final String readString = reader.readLine();
                final Response resp = g.fromJson(readString, Response.class);
                publish(resp);

                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
