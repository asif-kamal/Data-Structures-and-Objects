public class splitBy3And5 {
    public boolean split53(int[] nums) {
        return splitHelper(nums, 0, 0, 0);
    }

    private boolean splitHelper(int[] nums, int index, int sum1, int sum2) {
        if (index == nums.length) {
            return sum1 == sum2;
        }
        int num = nums[index];

        if (num % 5 == 0) {
            return splitHelper(nums, index + 1, sum1 + num, sum2);
        } else if (num % 3 == 0) {
            return splitHelper(nums, index + 1, sum1, sum2 + num);
        } else {
            return splitHelper(nums, index + 1, sum1 + num, sum2) || splitHelper(nums, index + 1, sum1, sum2 + num);
        }
    }

}
