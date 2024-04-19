package leetcode.array.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @autor yud1
 * @date 2024/4/16 15:03
 *
 * https://leetcode.cn/problems/combinations/
 */
public class Combine {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path =  new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(0,n,k);
        return res;
    }

    private void backtrack(int start, int n,  int k){
      if (path.size() == k){
          res.add(new LinkedList<>(path));
          return;
      }
      for (int i = start; i <  n; i++) {
            path.addLast(i);
            backtrack(i+1,n,k);
            path.removeLast();
      }
    }
}
