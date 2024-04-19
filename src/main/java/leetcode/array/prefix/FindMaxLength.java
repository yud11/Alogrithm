package leetcode.array.prefix;

import java.util.HashMap;

/**
 * @autor yud1
 * @date 2024/4/16 13:39
 * https://leetcode.cn/problems/contiguous-array/
 */
public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        // preNums[i] : 前i个元素的前缀和
        int[] preNums = new int[nums.length+1];
        int res = 0 ;
        int prevNum = 0;
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        valToIndex.put(prevNum,0);
        for (int i = 0; i < preNums.length; i++) {
            prevNum = prevNum + (nums[i-1] == 0 ? -1 : 1);
            if (!valToIndex.containsKey(prevNum)){
                valToIndex.put(prevNum, i);
            } else {
                res = Math.max(res, i - valToIndex.get(prevNum));
            }
        }
        return  res;
    }

}
