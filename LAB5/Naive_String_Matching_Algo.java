import java.util.Scanner;

public class Naive_String_Matching_Algo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your text: ");
        String text = scanner.nextLine();

        System.out.print("Enter your pattern to find in text: ");
        String pattern = scanner.nextLine();

        int n = text.length();
        int m = pattern.length();
        boolean matchFound = false;

        for (int i = 0; i < n - m + 1; i++) {
            int p = 0;
            for (int j = i; j < i + m; j++) {
                if (text.charAt(j) == pattern.charAt(p)) {
                    p++;
                } else {
                    break;
                }
            }

            if (p == m) {
                System.out.println("Match is found at: " + i);
                matchFound = true;
            }
        }

        if (!matchFound) {
            System.out.println("No match is found");
        }

        System.out.println("Computation is done");

        scanner.close();
    }
}
