public class array2Times10Equals20 {

    public static boolean array220(int[] nums, int index) {
        if (index >= nums.length-1) {
            return false;
        }
        if (nums[index + 1] == nums[index] * 10) {
            return true;
        }
        return array220(nums, index + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 10 };

        System.out.println(array220(nums, 0));
    }

}
