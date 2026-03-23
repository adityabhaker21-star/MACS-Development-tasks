public class MergeSort {

    public static void sort(int[] arr, int left, int right, long[] metrics) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(arr, left, mid, metrics);
            sort(arr, mid + 1, right, metrics);

            merge(arr, left, mid, right, metrics);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, long[] metrics) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            metrics[0]++;
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k++] = L[i++];
            metrics[0]++;
        }
        while (j < n2) {
            arr[k++] = R[j++];
            metrics[0]++;
        }
    }
}
