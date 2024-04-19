package leetcode.array.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @autor yud1
 * @date 2024/4/16 14:46
 * https://leetcode.cn/problems/subsets/?envType=study-plan-v2&envId=top-100-liked
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return res;
    }

    private  void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(nums,start+1);
            path.removeLast();
        }
    }
}
