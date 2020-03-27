package k23.k23_4.k23_4_4;

import java.util.concurrent.LinkedBlockingQueue;

class Consumer2314 extends Thread {

    private final LinkedBlockingQueue<String> v;

    public Consumer2314(LinkedBlockingQueue<String> v) {
        this.v = v;
    }

    public void run() {
        while (true) {
            try {
                String s = v.take();
                System.out.print(" Konsument fand " + s);
                System.out.println(" (verbleiben: " + v.size() + ")");
                Thread.sleep((int) (100 * Math.random()));
            } catch (InterruptedException e) {
                // nichts
            }
        }
    }
}
