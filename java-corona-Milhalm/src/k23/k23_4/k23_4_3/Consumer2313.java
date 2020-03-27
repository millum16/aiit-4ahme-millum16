package k23.k23_4.k23_4_3;

import java.util.Vector;

class Consumer2313
        extends Thread {

    private Vector<String> v;

    public Consumer2313(Vector<String> v) {
        this.v = v;
    }

    public void run() {
        while (true) {
            synchronized (v) {
                if (v.size() < 1) {
                    try {
                        v.wait();
                    } catch (InterruptedException e) {
                        //nichts
                    }
                    System.out.print(
                            " Konsument fand " + v.elementAt(0)
                    );
                    v.removeElementAt(0);
                    System.out.println(" (verbleiben: " + v.size() + ")");
                }
                try {
                    Thread.sleep((int) (100 * Math.random()));
                } catch (InterruptedException e) {
                    //nichts
                }
            }
        }
    }
}
