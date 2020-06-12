package stoppuhr;

import java.net.Socket;
import javax.swing.SwingWorker;

/**
 *
 * @author lukasmilhalm
 */
public abstract class ConnectionWorker extends SwingWorker<String, Integer> {

    private Socket socket;

    public ConnectionWorker(int port, String hostName) {

    }

    @Override
    protected String doInBackground() throws Exception {
        System.out.println("Do in Background" + Thread.currentThread().getId());
        Thread.sleep(1000);

        publish(1);

        Thread.sleep(1000);

        publish(2);

        Thread.sleep(1000);
        return "OK";
    }
}
