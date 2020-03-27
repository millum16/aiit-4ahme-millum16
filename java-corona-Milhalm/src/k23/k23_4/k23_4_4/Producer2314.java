package k23.k23_4.k23_4_4;

import java.util.concurrent.LinkedBlockingQueue;

class Producer2314 extends Thread {

    private final LinkedBlockingQueue<String> v;

    public Producer2314(LinkedBlockingQueue<String> v) {
        this.v = v;
    }

    public void run() {
        String s;

        while (true) {
            s = "Wert " + Math.random();
            v.add(s);
            System.out.println("Produzent erzeugte " + s);
            try {
                Thread.sleep((int) (100 * Math.random()));
            } catch (InterruptedException x) {
                // nichts
            }
        }
    }
}
