public class sumOfFives {
    
    public static int printSumOfFives(int[][] arr) {
        
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] % 5 ==0) {
                    sum += arr[i][j]; 
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,2,3,5,88}, {33,513,5004}, {44, 987, 332}, {66, 500, 320}};
        
        printSumOfFives(arr);
    }
    
}

