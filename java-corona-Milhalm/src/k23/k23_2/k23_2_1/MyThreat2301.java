package k23.k23_2.k23_2_1;

//Einfacher Thread mit einem Zähler
class MyThread2301 extends Thread {

    public void run() {

        int i = 0;
        while (true) {
            System.out.println(i++);
        }
    }
}
