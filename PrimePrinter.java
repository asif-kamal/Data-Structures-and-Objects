public class PrimePrinter {

    public static boolean isPrime(int number) {
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                //System.out.println("false");
                return false;
            }
        }
        return true;
        //System.out.println("True");
    }

    public static void printPrimes(int n){
        for(int i = 0; i < n; i++) {
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }
    
    public static void main(String[] args) {
        printPrimes(10);
    }
    
}
