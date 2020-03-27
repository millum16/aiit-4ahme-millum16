package k23.k23_3.k23_3_2;

//Eine Klasse zur Primfaktorenzerlegung
public class PrimeNumberTools {

    public void printPrimeFactors(int num) {

        int whichprime = 1;
        int prime;
        String prefix;

        prefix = "primeFactors(" + num + ")= ";
        while (num > 1) {
            prime = getPrime(whichprime);
            if (num % prime == 0) {
                System.out.println(prefix + prime);
                prefix = " ";
                num /= prime;
            } else {
                ++whichprime;
            }
        }
        System.out.println();
    }

    public int getPrime(int cnt) {
        int i = 1;
        int ret = 2;

        while (i < cnt) {
            ++ret;
            if (isPrime(ret)) {
                ++i;
            }
        }
        return ret;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
