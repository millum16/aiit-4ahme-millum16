package k23.k23_4.k23_4_5;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Listing2315 {

    public static void main(String[] args)
            throws Exception {
        PipedInputStream inPipe = new PipedInputStream();
        PipedOutputStream outPipe = new PipedOutputStream(inPipe);
        Producer2315 p = new Producer2315(outPipe);
        Consumer2315 c = new Consumer2315(inPipe);
        p.start();
        c.start();
    }
}
