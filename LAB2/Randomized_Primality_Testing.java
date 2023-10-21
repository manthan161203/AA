package LAB2;

import java.util.Random;

public class Randomized_Primality_Testing {

    public static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static long power(long b, long e, long m) {
        long res = 1;
        b = b % m;
        while (e > 0) {
            if (e % 2 != 0) {
                res = (res * b) % m;
            }
            e = e / 2;
            b = (b * b) % m;
        }
        return res;
    }

    public static boolean isPrime(long n) {
        if (n <= 1 && n == 4) {
            return false;
        }
        if (n <= 3) {
            return true;
        }

        int k = 100;
        Random rand = new Random();
        while (k > 0) {
            long a = 2 + rand.nextLong() % (n - 4);
            if (gcd(n, a) != 1) {
                return false;
            }
            if (power(a, n - 1, n) != 1) {
                return false;
            }
            k--;
        }
        return true;
    }

    public static void main(String[] args) {
        long n = 561;
        // n = input from the user
        Random rand = new Random();
        int cn = 0;
        for (int i = 2; i <= n - 2; i++) {
            if (power(i, n - 1, n) == 1) {
                cn++;
            }
        }
        System.out.println(cn);
        System.out.println((float) cn / (n - 3));

        if (isPrime(n)) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }
}
