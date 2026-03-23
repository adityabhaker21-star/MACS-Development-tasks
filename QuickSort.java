public class QuickSort {

    public static void sort(int[] arr, int low, int high, long[] metrics) {
        if (low < high) {
            int pi = partition(arr, low, high, metrics);

            sort(arr, low, pi - 1, metrics);
            sort(arr, pi + 1, high, metrics);
        }
    }

    private static int partition(int[] arr, int low, int high, long[] metrics) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            metrics[0]++;

            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}