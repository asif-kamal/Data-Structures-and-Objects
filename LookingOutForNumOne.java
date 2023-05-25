import java.util.Arrays;

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

    public static String nthDigit(int n, int num) {

        String digits = Integer.toString(num);

        if (n >= digits.length()) {
            // System.out.println(0);
            return Integer.toString(0);
        } else {
            char[] arr = digits.toCharArray();
            // System.out.println(arr[n]);
            String result = String.valueOf(arr[n]);
            return result;
        }
    }

    public static void updateTally(int n, int num, int[] tally) {

        // {0,0,1,2,0,0,3,0,9,0}
        int index = Integer.parseInt(nthDigit(n, num));
        tally[index] = tally[index] + 1;

        for (int element : tally) {
            System.out.println(element);
        }

    }

    public static void main(String[] args) {

        // countDigits(3000);
        // nthDigitBack(1, 1998);
        // nthDigit(5, 19998);
        int[] tally = { 0, 0, 1, 2, 0, 0, 3, 0, 9, 0 };
        updateTally(4, 1998361, tally);
    }
}
