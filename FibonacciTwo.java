public class FibonacciTwo {

    public static long fib(int n) {
        if (n <= 1) {

            return n;
        } 
        
        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        int n = 47;
        System.out.println(
            n + "th Fibonacci Number: " + fib(n));
        
    }
}
