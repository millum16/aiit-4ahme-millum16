package k23.k23_3.k23_3_2;

import java.io.*;

public class Listing2308 {

    public static void main(String[] args) {
        ThreadedPrimeNumberTools pt;
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new DataInputStream(System.in)));
        int num;

        try {
            while (true) {
                System.out.print("Bitte eine Zahl eingeben: ");
                System.out.flush();
                num = (new Integer(in.readLine())).intValue();
                if (num == -1) {
                    break;
                }
                pt = new ThreadedPrimeNumberTools();
                pt.printPrimeFactors(num);
            }
        } catch (IOException e) {
            //nichts
        }
    }
}
