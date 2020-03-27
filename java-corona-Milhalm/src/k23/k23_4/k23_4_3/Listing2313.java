package k23.k23_4.k23_4_3;

import java.util.Vector;

public class Listing2313 {

    public static void main(String[] args) {
        Vector<String> v = new Vector<String>();

        Producer2313 p = new Producer2313(v);
        Consumer2313 c = new Consumer2313(v);
        p.start();
        c.start();
    }

}
