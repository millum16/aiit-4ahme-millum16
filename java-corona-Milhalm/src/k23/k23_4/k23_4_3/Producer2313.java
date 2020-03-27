package k23.k23_4.k23_4_3;

import java.util.*;

class Producer2313
        extends Thread {

    private Vector<String> v;

    public Producer2313(Vector<String> v) {
        this.v = v;
    }

    public void run() {
        String s;

        while (true) {
            synchronized (v) {
                s = "Wert " + Math.random();
                v.addElement(s);
                System.out.println("Produzent erzeugte " + s);
                v.notify();
            }
            try {
                Thread.sleep((int) (100 * Math.random()));
            } catch (InterruptedException e) {
                //nichts
            }
        }
    }
}
