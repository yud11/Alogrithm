package leetcode.array.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @autor yud1
 * @date 2024/4/16 15:16
 *
 * https://leetcode.cn/problems/combination-sum/?envType=study-plan-v2&envId=top-100-liked
 */
public class CombinationSum {


    List<List<Integer>> res = new ArrayList<>();

    LinkedList<Integer> path =  new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int sum, int start){
        // base case
        if (sum > target){
            return;
        } else if (sum == target) {
            res.add(new LinkedList<>(path));
        }else{
            for (int i = start; i < candidates.length; i++) {
                path.add(candidates[i]);
                backtrack(candidates, target,  sum+ candidates[i],i);
                path.removeLast();
            }
        }
    }
}
