public class NinetyNineBottles {
    
    public static void printBottleSong(int N) {
        while(N > 0) {
            System.out.println(N + " bottles of beer on the wall, " + N + " bottles of beer. Take one down, pass it around, " + 
            (N - 1) + " bottles of beer on the wall");
            N--;
        }
    }
    /*
     * Take in a param int N and start the song at that number
     * keep going down until there is 0
     */
    public static void main(String[] args) {
        printBottleSong(50);
    }
}
