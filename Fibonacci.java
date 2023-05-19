public class Fibonacci {
    
    /* 
     * Add every previous 2 numbers to get Fibonacci number
     * then filter through if statement to check if even or not
     */


    public static void main(String[] args) {
        int previous=0, current=1;
        int sum = 0;
        while(current <= 4000000) {
            if(current%2 == 0) {
                sum += current;
                //System.out.println(sum);
            }
            int next = previous + current;
            previous = current;
            current = next;
            
        }
        System.out.println("The sum of the even-valued terms of the Fibonacci sequence whose values do not exceed 4 million is " + sum);
    }
}

//Why do I need to pass in the current value and not the previous or next?
