package k23.k23_4.k23_4_1;

//Zwei Zählerthreads
public class Listing2309
        extends Thread {

    static int cnt = 0;

    public static void main(String[] args) {
        Thread t1 = new Listing2309();
        Thread t2 = new Listing2309();
        t1.start();
        t2.start();
    }

    public void run() {
        while (true) {
            System.out.println(cnt++);
        }
    }
}
