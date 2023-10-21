package LAB2;

import java.util.Random;

public class K_Smallest {
    public static int partition(int[] arr, int p, int q) {
        int z = p - 1;
        int pivot = arr[q];
        for (int j = p; j < q; j++) {
            if (arr[j] < pivot) {
                z++;
                swap(arr, z, j);
            }
        }
        swap(arr, z + 1, q);
        return z + 1;
    }

    public static int randomizePartition(int[] arr, int p, int q) {
        Random rand = new Random();
        int t = p + rand.nextInt(q - p + 1);
        swap(arr, t, q);
        return partition(arr, p, q);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int find(int[] arr, int p, int r, int k) {
        if (k > 0 && k <= r - p + 1) {
            int q = randomizePartition(arr, p, r);
            if (k - 1 == q - p) {
                return arr[q];
            }
            if (k - 1 < q - p) {
                return find(arr, p, q - 1, k);
            }
            return find(arr, q + 1, r, k - p + q - 1);
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = { 10, 40, 30, 50, 70, 20, 90, 80, 100, 60, 110, 150, 120, 160, 130, 170, 140, 180, 200, 190 };
        System.out.println(find(arr, 0, arr.length - 1, 11));
    }
}
