package LAB6;

import java.util.Scanner;

public class Sum_of_Subset_Using_0_1_Knapsack {
    public static boolean knapsack(int[] p, int[] w, int cap, int maxProfit) {
        int n = p.length;
        int[][] dp = new int[n + 1][cap + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= cap; j++) {
                if (j < w[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], p[i - 1] + dp[i - 1][j - w[i - 1]]);
                }
            }
        }

        return dp[n][cap] >= maxProfit;
    }

    public static void sumOfSubset(int[] arr, int sum) {
        if (knapsack(arr, arr, sum, sum)) {
            System.out.println("Subset is present in arr with sum: " + sum);
        } else {
            System.out.println("Subset is not present in arr with sum: " + sum);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of elements present in array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter all elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Required sum: ");
        int sum = scanner.nextInt();

        sumOfSubset(arr, sum);
    }
}
