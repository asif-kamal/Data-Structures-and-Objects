import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 12, 1, 6, 3, 9 };

        System.out.println("Before sorting: " + Arrays.toString(arr));

        long startTime = System.currentTimeMillis();
        insertionSort(arr);
        long endTime = System.currentTimeMillis();

        System.out.println("Time elapsed (ms): " + (endTime - startTime));
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
