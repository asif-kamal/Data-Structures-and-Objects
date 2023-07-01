public class Helper {

    private static <E> void printArray(int[] arr, int index) {
        if (index == arr.length) {

        } else {
            System.out.println(arr[index]);
            printArray(arr, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        printArray(arr, 5);
    }
    
}
