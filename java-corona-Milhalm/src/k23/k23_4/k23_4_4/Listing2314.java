package k23.k23_4.k23_4_4;

import java.util.concurrent.LinkedBlockingQueue;

public class Listing2314 {

    public static void main(String[] args) {
        LinkedBlockingQueue<String> v
                = new LinkedBlockingQueue<String>();

        Producer2314 p = new Producer2314(v);
        Consumer2314 c = new Consumer2314(v);
        p.start();
        c.start();
    }
}
