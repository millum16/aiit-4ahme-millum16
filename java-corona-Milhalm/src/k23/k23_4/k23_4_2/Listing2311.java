package k23.k23_4.k23_4_2;

public class Listing2311
        extends Thread {

    private String name;
    private Counter2311 counter;

    public Listing2311(String name, Counter2311 counter) {
        this.name = name;
        this.counter = counter;
    }

    public static void main(String[] args) {
        Thread[] t = new Thread[5];
        Counter2311 cnt = new Counter2311(10);
        for (int i = 0; i < 5; ++i) {
            t[i] = new Listing2311("Thread-" + i, cnt);
            t[i].start();
        }
    }

    public void run() {
        while (true) {
            System.out.println(counter.nextNumber() + " for " + name);
        }
    }
}
