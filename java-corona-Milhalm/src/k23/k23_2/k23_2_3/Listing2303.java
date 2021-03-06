package k23.k23_2.k23_2_3;

//Anwendung der Methoden interrupt und isInterrupted
public class Listing2303 extends Thread {

    int cnt = 0;

    public void run() {
        while (true) {
            if (isInterrupted()) {
                break;
            }
            printLine(++cnt);
        }
    }

    private void printLine(int cnt) {

        //Zeile ausgeben
        System.out.println(cnt + ": ");
        for (int i = 0; i < 30; i++) {
            System.out.println(i == cnt % 30 ? "* " : ". ");
        }
        System.out.println();
        //100 ms warten
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            interrupt();
        }
    }

    public static void main(String[] args) {
        Listing2303 th = new Listing2303();
        {

            //Thread starten
            th.start();
            //2 Sekunden warten
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            //Thread unterbrechen
            th.interrupt();
        }
    }
}
