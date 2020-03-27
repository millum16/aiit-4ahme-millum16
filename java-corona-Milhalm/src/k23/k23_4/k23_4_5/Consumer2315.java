package k23.k23_4.k23_4_5;

import java.io.IOException;
import java.io.PipedInputStream;

class Consumer2315
        extends Thread {

    private PipedInputStream pipe;

    public Consumer2315(PipedInputStream pipe) {
        this.pipe = pipe;
    }

    public void run() {
        while (true) {
            try {
                byte b = (byte) pipe.read();
                System.out.println(" Konsument fand " + b);
            } catch (IOException e) {
                System.err.println(e.toString());
            }
            try {
                Thread.sleep((int) (100 * Math.random()));
            } catch (InterruptedException e) {
                //nichts
            }
        }
    }
}
