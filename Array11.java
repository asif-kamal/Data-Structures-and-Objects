public class Array11 {

    public static int array11(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        } else if (nums[index] != 11) {
            return 0 + array11(nums, index + 1);
        } else {
            return 1 + array11(nums, index + 1);
        }
    }

    public static void main(String[] args) {
        int nums [] = new int[5];
        nums[0] = 11;
        nums[1] = 29;
        nums[2] = 11;
        nums[3] = 13;
        nums[4] = 94;
        System.out.println(array11(nums, 0));
    }
}
