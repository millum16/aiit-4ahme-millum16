package k23.k23_4.k23_4_5;

import java.io.*;

class Producer2315
        extends Thread {

    private PipedOutputStream pipe;

    public Producer2315(PipedOutputStream pipe) {
        this.pipe = pipe;
    }

    public void run() {
        while (true) {
            byte b = (byte) (Math.random() * 128);
            try {
                pipe.write(b);
                System.out.println("Produzent erzeugte " + b);
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
