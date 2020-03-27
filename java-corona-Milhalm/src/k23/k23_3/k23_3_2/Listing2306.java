package k23.k23_3.k23_3_2;

//Verwendung der Klasse zur Primfaktorzerlegung
import java.io.*;

public class Listing2306 {

    public static void main(String[] args) throws IOException {
        PrimeNumberTools pt = new PrimeNumberTools();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new DataInputStream(System.in)));
        int num;

        try {
            while (true) {
                System.out.println("Bitte eine Zahl eingeben: ");
                System.out.flush();
                num = (new Integer(in.readLine())).intValue();
                if (num == -1) {
                    break;
                }
                pt.printPrimeFactors(num);
            }catch (IOException e) {
                //nichts
            }
        }
    }
}
