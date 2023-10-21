package LAB5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Horsepools_String_Matching_Algo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your text: ");
        String text = scanner.nextLine();

        System.out.print("Enter your pattern to find in text: ");
        String pattern = scanner.nextLine();

        int n = text.length();
        int m = pattern.length();

        Map<Character, Integer> shiftTable = new HashMap<>();
        boolean matchFound = false;

        // Creating Shift Table
        int k = m - 1;
        for (int i = 0; i < m - 1; i++) {
            shiftTable.put(pattern.charAt(i), k);
            k--;
        }

        for (int i = 0; i <= n - m; ) {
            int p = i + m - 1;
            int q = m - 1;

            while (q >= 0 && p >= 0 && pattern.charAt(q) == text.charAt(p)) {
                p--;
                q--;
            }

            if (q == -1) {
                System.out.println("Pattern matched at: " + i);
                i++;
                matchFound = true;
            } else {
                if (shiftTable.containsKey(text.charAt(i + m - 1)) && shiftTable.get(text.charAt(i + m - 1)) > 0) {
                    i += shiftTable.get(text.charAt(i + m - 1));
                } else {
                    i += m;
                }
            }
        }

        if (!matchFound) {
            System.out.println("No match is present");
        }

        System.out.println("Computation is done");

        scanner.close();
    }
}
