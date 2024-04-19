package leetcode.array;


/**
 * @autor yud1
 * @date 2023/5/16 20:53
 */
public class _1_26_删除有序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length){
            if (nums[slow] != nums[fast]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow +1;
    }
}
