public class SumOfSquares {

    public static void printSumofSq(int n) {

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i * i;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        printSumofSq(5);
    }
}
