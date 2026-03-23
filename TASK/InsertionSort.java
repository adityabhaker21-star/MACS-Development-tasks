public class InsertionSort {
    public static void sort(int[] arr, long[] metrics) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                metrics[0]++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            metrics[0]++;
            arr[j + 1] = key;
        }
    }
}
