import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

//QuickSort Method from: https://chat.openai.com

public class QuickSort {

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

    public static void quickSort(int[] arr, Data data) {
        quickSort(arr, 0, arr.length - 1, data);
    }

    private static void quickSort(int[] arr, int low, int high, Data data) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high, data);

            quickSort(arr, low, partitionIndex - 1, data);
            quickSort(arr, partitionIndex + 1, high, data);
        }
    }

    private static int partition(int[] arr, int low, int high, Data data) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            data.comparisons++;// even if if block is not triggered a comparison is still being made
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                data.exchanges++;
            }
        }

        swap(arr, i + 1, high);
        data.exchanges++;
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
                quickSort(arr, d);
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
        FileWriter fw = new FileWriter("resultsQS.csv");
        for (String line : outputArr) {
            fw.write(line + "\n");
        }
        fw.close();
    }

}
