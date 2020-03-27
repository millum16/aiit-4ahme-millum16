package k23.k23_4.k23_4_2;

//Eine unzureichend synchronisierte Zählerklasse
class Counter2311 {

    int cnt;

    public Counter2311(int cnt) {
        this.cnt = cnt;
    }

    public int nextNumber() {
        int ret = cnt;
        //Hier erfolgen ein paar zeitaufwändige Berechnungen, um
        //so zu tun, als sei das Errechnen des Nachfolgezählers
        //eine langwierige Operation, die leicht durch den
        //Scheduler unterbrochen werden kann.
        double x = 1.0, y, z;
        for (int i = 0; i < 1000000; ++i) {
            x = Math.sin((x * i % 35) * 1.13);
            y = Math.log(x + 10.0);
            z = Math.sqrt(x + y);
        }
        //Jetzt ist der Wert gefunden
        cnt++;
        return ret;
    }
}
