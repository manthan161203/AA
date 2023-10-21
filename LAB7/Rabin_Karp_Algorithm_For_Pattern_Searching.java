package LAB7;

import java.util.Scanner;

public class Rabin_Karp_Algorithm_For_Pattern_Searching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number in which you want to find a pattern: ");
        String t = scanner.next();

        System.out.print("Enter a pattern which you want to find in the main string: ");
        String p = scanner.next();

        System.out.print("Enter a value of q: ");
        int q = scanner.nextInt();

        int n = t.length();
        int m = p.length();

        int numt = 0;
        int nump = 0;

        for (int i = 0; i < m; i++) {
            numt = numt * 10 + t.charAt(i) - '0';
            nump = nump * 10 + p.charAt(i) - '0';
        }

        int modTemp = (int) Math.pow(10, m - 1);

        for (int i = 0; i < n - m - 1; i++) {
            if (numt % q == nump % q) {
                if (numt == nump) {
                    System.out.println("Pattern is matched at: " + i);
                }
            }

            numt = (numt % modTemp) * 10 + t.charAt(i + m) - '0';
        }
    }
}
