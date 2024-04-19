package leetcode.array.twodimensions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @autor yud1
 * @date 2024/4/17 15:15
 * https://leetcode.cn/problems/merge-intervals/
 * 56. 合并区间
 */
public class _56_merge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = list.get(list.size() - 1);
            int[] curr = intervals[i];
            if (curr[0] >  last[1]){
                list.add(curr);
            }else{
                last[1] = Math.max(last[1], curr[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
