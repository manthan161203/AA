import java.util.Random;

public class Randomized_Quicksort {
    static int count1 = 0;

    public static int partition(int[] arr, int p, int q) {
        int z = p - 1;
        int pivot = arr[q];
        for (int j = p; j < q; j++) {
            if (arr[j] < pivot) {
                z++;
                swap(arr, z, j);
            }
        }
        count1 = count1 + (q - p);
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

    public static void randomizeQuickSort(int[] arr, int p, int q) {
        if (p < q) {
            int mid = randomizePartition(arr, p, q);
            randomizeQuickSort(arr, p, mid - 1);
            randomizeQuickSort(arr, mid + 1, q);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = 1000 - i;
        }

        randomizeQuickSort(arr, 0, 999);

        System.out.println("no of comparision: " + count1 + " ");
    }
}
