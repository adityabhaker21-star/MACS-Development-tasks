import java.util.Arrays;
import java.util.Random;

public class BogoSort {
    public static void main(String[] args) {
        System.out.println("---------- THE BOGO SORT DANGER ZONE ----------");

        int size = 14;

        int[] arr = generateRandomArray(size);
        System.out.println("Original Input : " + Arrays.toString(arr));

        long[] metrics = {0};
        long start = System.nanoTime();

        System.out.println("\nShuffling blindly... please wait...");
        BogoSort.sort(arr, metrics);

        double timeMs = (System.nanoTime() - start) / 1e6;

        System.out.println("\n--- MIRACLE ACHIEVED ---");
        System.out.println("Sorted Output  : " + Arrays.toString(arr));
        System.out.printf("Time Taken     : %.2f ms%n", timeMs);
        System.out.printf("Total Shuffles : %d%n", metrics[0]);
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(100);
        return arr;
    }

    public static void sort(int[] arr, long[] metrics) {
        while (!isSorted(arr, metrics)) {
            shuffle(arr, metrics);
        }
    }

    private static boolean isSorted(int[] arr, long[] metrics) {
        for (int i = 0; i < arr.length - 1; i++) {
            metrics[0]++;
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void shuffle(int[] arr, long[] metrics) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            metrics[0]++;
            int randomIndex = rand.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomIndex];
            arr[randomIndex] = temp;
        }
    }
}
