public class GroupSum6 {
    public boolean groupSum6(int start, int[] nums, int target) {
        return groupSum6Helper(start, nums, target, 0);
    }

    private boolean groupSum6Helper(int start, int[] nums, int target, int sum) {

        if (start == nums.length) {
            return sum == target;
        }

        int num = nums[start];

        if (num == 6) {
            return groupSum6Helper(start + 1, nums, target, sum + num);
        }
        return groupSum6Helper(start + 1, nums, target, sum + num) || groupSum6Helper(start + 1, nums, target, sum);
    }
}
