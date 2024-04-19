package leetcode.array.prefix;

import java.util.HashMap;

/**
 * @autor yud1
 * @date 2024/4/16 13:57
 * https://leetcode.cn/problems/subarray-sum-equals-k/
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int[] prev = new int[nums.length + 1];
        for (int i = 1; i < prev.length; i++) {
            prev[i] = prev[i - 1] + nums[i - 1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < prev.length; i++) {
            int need = prev[i] - k;
            if (map.containsKey(need)) {
                res += map.get(need);
            }
            if (!map.containsKey(prev[i])){
                map.put(prev[i], 1);
            } else {
                map.put(prev[i], map.get(prev[i]) + 1);
            }
        }
        return res;
    }
}
