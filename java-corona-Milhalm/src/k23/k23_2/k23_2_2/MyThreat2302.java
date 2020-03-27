package k23.k23_2.k23_2_2;

//Beenden des Threads durch Aufruf von stop
class MyThread2302 extends Thread {

    public void run() {

        int i = 0;
        while (true) {
            System.out.println(i++);
        }
    }
}
