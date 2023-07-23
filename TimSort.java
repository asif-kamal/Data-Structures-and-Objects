import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//TimSort Method from: https://chat.openai.com

public class TimSort {

    private static class Data {
        long exchanges;
        long comparisons;
        long elapsedTime;
    }

    public static int[] makeArray(int length) {
        Random rand = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10001);
        }
        return arr;
    }

    private static final int MIN_MERGE = 32;

    public static void timSort(int[] arr, Data data) {
        int n = arr.length;
        long start = System.nanoTime();
        int minRun = minRunLength(MIN_MERGE, n);

        // Perform insertion sort for small subarrays
        for (int i = 0; i < n; i += minRun) {
            insertionSort(arr, i, Math.min(i + minRun - 1, n - 1), data);
        }

        // Merge subarrays in a bottom-up manner
        for (int size = minRun; size < n; size = size * 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, n - 1);
                merge(arr, left, mid, right, data);
            }
        }
        long end = System.nanoTime();
        data.elapsedTime = end - start;
    }

    private static int minRunLength(int minMerge, int n) {
        int r = 0;
        while (n >= minMerge) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    private static void insertionSort(int[] arr, int left, int right, Data data) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;

            data.comparisons++;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                data.exchanges++;
                data.comparisons++;
            }

            arr[j + 1] = key;
            data.exchanges++;
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, Data data) {
        int len1 = mid - left + 1;
        int len2 = right - mid;

        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];

        for (int i = 0; i < len1; i++) {
            leftArr[i] = arr[left + i];
            data.exchanges++;
        }

        for (int i = 0; i < len2; i++) {
            rightArr[i] = arr[mid + 1 + i];
            data.exchanges++;
        }

        int i = 0, j = 0, k = left;

        while (i < len1 && j < len2) {
            data.comparisons++;
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
                data.exchanges++;
            } else {
                arr[k] = rightArr[j];
                j++;
                data.exchanges++;
            }
            k++;
        }

        while (i < len1) {
            arr[k] = leftArr[i];
            i++;
            k++;
            data.exchanges++;
        }

        while (j < len2) {
            arr[k] = rightArr[j];
            j++;
            k++;
            data.exchanges++;
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Data> dataList = new ArrayList<>();
        ArrayList<String> outputArr = new ArrayList<>();
        long sumOfExchanges = 0;
        long sumOfComparisons = 0;
        long sumOfElapsedTime = 0;

        for (int i = 6; i <= 16; i++) {
            int n = (int) Math.pow(2, i);
            for (int j = 0; j < 100; j++) {
                int[] arr = makeArray(n);
                Data d = new Data();
                timSort(arr, d);
                dataList.add(d);
                sumOfExchanges += d.exchanges;
                sumOfComparisons += d.comparisons;
                sumOfElapsedTime += d.elapsedTime;
            }
            System.out
                    .println("n (array length): " + n + "\t" + "Average Out of 100" + "\t" + "Exchanges: "
                            + sumOfExchanges / 100 + "\t"
                            + "Comparisons: "
                            + sumOfComparisons / 100
                            + "\t" + "Elapsed Time(ns): " + sumOfElapsedTime / 100);

            String output = n + ","
                    + sumOfExchanges / 100 + ","
                    + sumOfComparisons / 100
                    + "," + sumOfElapsedTime / 100;

            outputArr.add(output);
        }
        // Write the data to a CSV file
        FileWriter fw = new FileWriter("resultsTS.csv");
        for (String line : outputArr) {
            fw.write(line + "\n");
        }
        fw.close();

    }
}
