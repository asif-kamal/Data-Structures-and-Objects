import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//Insertion Method from: https://chat.openai.com

public class InsertionSort {

    private static class Data {
        long exchanges;
        long comparisons;
        long elapsedTime;

        public String toString() {
            return comparisons + " " + exchanges + " " + elapsedTime;
        }
    }

    public static int[] makeArray(int length) {
        Random rand = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10001);
        }
        return arr;
    }

    public static void insertionSort(int[] arr, Data data) {
        int n = arr.length;
        long start = System.nanoTime();

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            data.comparisons++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                data.exchanges++;
                data.comparisons++;
            }
            arr[j + 1] = key;
            data.exchanges++;
        }
        long end = System.nanoTime();
        data.elapsedTime = end - start;
    }

    public static void main(String[] args) {
        ArrayList<Data> dataList = new ArrayList<>();
        long sumOfExchanges = 0;
        long sumOfComparisons = 0;
        long sumOfElapsedTime = 0;

        for (int i = 6; i <= 16; i++) {
            int n = (int) Math.pow(2, i);
            for (int j = 0; j < 100; j++) {
                int[] arr = makeArray(n);
                Data d = new Data();
                insertionSort(arr, d);
                dataList.add(d);
                sumOfExchanges += d.exchanges;
                sumOfComparisons += d.comparisons;
                sumOfElapsedTime += d.elapsedTime;
            }
            System.out
                    .println("n (array length): " + n + "\t" + "Average Out of 100" + "\t" + "Exchanges: " + sumOfExchanges/100 + "\t"
                            + "Comparisons: "
                            + sumOfComparisons/100
                            + "\t" + "Elapsed Time(ns): " + sumOfElapsedTime/100);
        }
    }
}
