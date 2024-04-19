package leetcode.DP;

import java.util.Arrays;

/**
 * @autor yud1
 * @date 2023/6/9 14:21
 */
public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        //dp[i]:代表以i结尾的LIS的长度
        //dp[i] =
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
    }
}
