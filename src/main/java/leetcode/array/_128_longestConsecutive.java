package leetcode.array;

import java.util.HashSet;

/**
 * @autor yud1
 * @date 2024/4/17 16:13
 *
 * https://leetcode.cn/problems/longest-consecutive-sequence/
 *
 * 128. 最长连续序列
 */
public class _128_longestConsecutive {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int res = 0;
        for(int num: nums){
            if (set.contains(num-1)){
                continue;
            }
            int currLength = 1;
            while(set.contains(num+1)){
                currLength++;
                num +=1;
            }
            res = Math.max(res, currLength);
        }
        return  res;
    }
}
