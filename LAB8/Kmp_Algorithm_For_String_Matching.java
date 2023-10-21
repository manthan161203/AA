package LAB8;

import java.util.Scanner;
import java.util.Vector;

public class Kmp_Algorithm_For_String_Matching {
    public static void createPieTable(String pat, Vector<Integer> pie) {
        int k = 0;
        pie.set(1, 0);
        int count = 0;
        int m = pat.length();

        for (int q = 2; q < m; q++) {
            boolean t = pat.charAt(k + 1) != pat.charAt(q);
            count++;

            while (k > 0 && t) {
                k = pie.get(k);
                t = pat.charAt(k + 1) != pat.charAt(q);
                count++;
            }

            if (!t) {
                k++;
            }

            pie.set(q, k);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.next();
        int n = text.length();

        System.out.print("Enter pattern: ");
        String pat = scanner.next();
        int m = pat.length();

        pat = "0" + pat;

        Vector<Integer> pie = new Vector<>(m + 1);
        for (int i = 0; i <= m; i++) {
            pie.add(-1);
        }

        createPieTable(pat, pie);

        int q = 0; // Number of matched characters.

        for (int i = 0; i < n; i++) {
            while (q > 0 && pat.charAt(q + 1) != text.charAt(i)) {
                q = pie.get(q);
            }
            if (pat.charAt(q + 1) == text.charAt(i)) {
                q++;
            }
            if (q == m) {
                System.out.println("Pattern occurs at index " + (i - m + 1));
                q = pie.get(q);
            }
        }

        System.out.println("Execution end");
    }
}

