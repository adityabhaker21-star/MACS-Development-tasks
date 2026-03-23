import java.util.Arrays;
import java.util.Random;

public class MainFile {
    public static void main(String[] args) {

        System.out.println("-------------- SMALL DATA TEST --------------");
        int[] smallArray = generateRandomArray(10);
        System.out.println("Original Input : " + Arrays.toString(smallArray));

        int[] testArr = Arrays.copyOf(smallArray, smallArray.length);
        long[] testMetrics = {0};
        MergeSort.sort(testArr, 0, testArr.length - 1, testMetrics);
        System.out.println("Sorted Output  : " + Arrays.toString(testArr));
        System.out.println();

        System.out.println("----------- LARGE DATA TEST --------------");
        int[] sizes = {10000, 20000};
        for (int size : sizes) {
            System.out.println("\n--- Array Size: " + size + " ---");
            int[] original = generateRandomArray(size);

            int[] mergeArr = Arrays.copyOf(original, original.length);
            long[] mergeMetrics = {0};
            long start = System.nanoTime();
            MergeSort.sort(mergeArr, 0, mergeArr.length - 1, mergeMetrics);
            double mergeTime = (System.nanoTime() - start) / 1e6;
            System.out.printf("%-15s | Time: %8.2f ms | Iterations: %10d%n", "Merge Sort", mergeTime, mergeMetrics[0]);

            int[] quickArr = Arrays.copyOf(original, original.length);
            long[] quickMetrics = {0};
            start = System.nanoTime();
            QuickSort.sort(quickArr, 0, quickArr.length - 1, quickMetrics);
            double quickTime = (System.nanoTime() - start) / 1e6;
            System.out.printf("%-15s | Time: %8.2f ms | Iterations: %10d%n", "Quick Sort", quickTime, quickMetrics[0]);

            int[] insertArr = Arrays.copyOf(original, original.length);
            long[] insertMetrics = {0};
            start = System.nanoTime();
            InsertionSort.sort(insertArr, insertMetrics);
            double insertTime = (System.nanoTime() - start) / 1e6;
            System.out.printf("%-15s | Time: %8.2f ms | Iterations: %10d%n", "Insertion Sort", insertTime, insertMetrics[0]);

            int[] bubbleArr = Arrays.copyOf(original, original.length);
            long[] bubbleMetrics = {0};
            start = System.nanoTime();
            BubbleSort.sort(bubbleArr, bubbleMetrics);
            double bubbleTime = (System.nanoTime() - start) / 1e6;
            System.out.printf("%-15s | Time: %8.2f ms | Iterations: %10d%n", "Bubble Sort", bubbleTime, bubbleMetrics[0]);
        }
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(100000);
        return arr;
    }
}