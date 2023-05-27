import java.io.File;
import java.util.Scanner;

public class LookingOutForNumOne {
    public static int countDigits(int num) {

        String digits = Integer.toString(num);
        int count = 0;

        for (int i = 0; i < digits.length(); i++) {

            count++;

        }
        System.out.println(count);
        return count;

    }

    public static String nthDigitBack(int n, int num) {

        String digits = Integer.toString(num);

        if (n >= digits.length()) {
            System.out.println(0);
            return Integer.toString(0);
        } else {
            String result = digits.substring(digits.length() - (1 + n), digits.length() - (1 + n - 1));
            System.out.println(result);
            return result;
        }

    }

    public static int nthDigit(int n, int num) {

        String digits = Integer.toString(num);

        if (n >= digits.length()) {
            // System.out.println(0);
            // return Integer.toString(0);
            return 0;
        } else {
            char[] arr = digits.toCharArray();
            // System.out.println(arr[n]);
            String result = String.valueOf(arr[n]);
            int result2 = Integer.parseInt(result);
            return result2;
        }
    }

    public static void updateTally(int n, int num, int[] tally) {

        // {0,0,1,2,0,0,3,0,9,0}
        int index = nthDigit(n, num);
        tally[index] = tally[index] + 1;

        for (int i = 0; i < tally.length; i++) {
            System.out.println(i + "s: " + tally[i]);
        }

    }

    public static int[] nthDigitTally(int n, int[] nums) {
        int[] tally = new int[10];
        for (int i = 0; i < nums.length; i++) {

            int number = nums[i];
            // updateTally(n, number, tally);
            char[] arr = String.valueOf(number).toCharArray();
            if ((n + 1) > arr.length) {
                int index = nthDigit(n, number);
                tally[index] = tally[index] + 0;
            } else {
                int index = nthDigit(n, number);
                tally[index] = tally[index] + 1;
            }

        }
        for (int i = 0; i < tally.length; i++) {
            System.out.println(i + "s: " + tally[i] + "\n");
        }
        // for (int j = 0; j < nums.length; j++) {
        // System.out.println(nums[j]);
        // }

        return tally;
    }

    public static int[] readMysteriousNumbers(String pathToFileString) {

        int[] arr = new int[0]; // Adjust for length of array input

        File file = new File(pathToFileString);

        try {
            Scanner scanner = new Scanner(file);
            int count = 0;

            while (scanner.hasNextInt()) {

                int num = scanner.nextInt();
                count++;
            }

            System.out.println("Number of lines in file: " + count);
            arr = new int[count];

            Scanner scanner2 = new Scanner(file);
            int index = 0;
            while (scanner2.hasNextInt()) {

                int num = scanner2.nextInt();
                arr[index] = num;
                index++;

            }
            scanner.close();
            scanner2.close();

        } catch (

        Exception e) {
            System.out.println("Bad file path");
        }
        System.out.println("Done");
        // System.out.println(arr.length);
        // for (int element : arr) {
        // System.out.print(element + " ");
        // }
        return arr;
    }

    public static void main(String[] args) {

        // countDigits(3000);
        // nthDigitBack(1, 1998);
        // nthDigit(5, 19998);
        // int[] tally = { 0, 0, 1, 2, 0, 0, 3, 0, 9, 0 };
        // updateTally(4, 1998361, tally);
        // int[] enrollment = { 12176, 5476, 543, 3490, 24892, 28619, 2595, 603, 2527,
        // 1465, 1858 };

        // nthDigitTally(0, enrollment);
        int[] arr = readMysteriousNumbers("cities_pop.txt");

        // for (int i = 0; i < arr.length; i++) {
        // System.out.println(arr[i]);
        // }
        System.out.println("Enter nth index: ");
        try (Scanner keyboard = new Scanner(System.in)) {
            int n = keyboard.nextInt();
            nthDigitTally(n, arr);

        } catch (Exception e) {
            System.out.println("Bad input");
        }
        // // System.out.println("Done.");

    }
}
