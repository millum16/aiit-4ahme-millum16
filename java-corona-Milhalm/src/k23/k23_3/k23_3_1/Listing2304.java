package k23.k23_3.k23_3_1;

//Implementieren von Runnable
class A2304 {

    int irgendwas;
    // ...
}

class B2304 extends A2304 implements Runnable {

    public void run() {
        int i = 0;
        while (true) {
            if (Thread.interrupted()) {
                break;
            }
            System.out.println(i++);
        }
    }
}

public class Listing2304 {

    public static void main(String[] args) {
        B2304 b = new B2304();
        Thread t = new Thread(b);
        t.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //nichts
        }
        t.interrupt();
    }
}
