package k23.k23_4.k23_4_2;

//Synchronisation von Threads mit Klassenobjekten
public class Listing2310
        extends Thread {

    static int cnt = 0;

    public static void main(String[] args) {
        Thread t1 = new Listing2310();
        Thread t2 = new Listing2310();
        t1.start();
        t2.start();
    }

    public void run() {
        while (true) {
            synchronized (getClass()) {
                System.out.println(cnt++);
            }
        }
    }
}
