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

    public static void main(String[] args) {

        // countDigits(3000);
        nthDigitBack(1, 1998);
    }
}
