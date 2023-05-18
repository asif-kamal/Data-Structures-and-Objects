public class PrimeChecker {

    public static boolean isPrime(int number) {
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                System.out.println("false");
                return false;
            }
        }
        System.out.println("True");
        return true;
    }

    public static void main(String[] args) {
        isPrime(49);
    }
    
}
