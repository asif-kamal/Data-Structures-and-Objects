public class SumOfMultiples {

    /*
     * iterate until you hit 1000
     * if (i) is divisible by 3 or 5 cleanly (modulo)
     * add to running sum variable
     */

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println("The sum of all the multiples of 3 and 5 up to 1000 is " + sum);
    }

}
