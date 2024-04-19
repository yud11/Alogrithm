package leetcode.array.prefix;

/**
 * @autor yud1
 * @date 2024/4/16 12:10
 */
public class NumArray {

    private int[] prev;

    public NumArray(int[] nums) {
        prev = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            prev[i] = prev[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prev[right+1] - prev[left];
    }
}
