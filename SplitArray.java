public class SplitArray {
    public boolean splitArray(int[] nums) {
        return splitHelper(nums, 0, 0, 0);
    }

    private boolean splitHelper(int[] nums, int index, int sum1, int sum2) {
        if (index == nums.length) {
            return sum1 == sum2;
        }

        int num = nums[index];

        return splitHelper(nums, index + 1, sum1 + num, sum2) || splitHelper(nums, index + 1, sum1, sum2 + num);
    }
}
