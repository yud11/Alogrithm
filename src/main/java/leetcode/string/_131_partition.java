package leetcode.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @autor yud1
 * @date 2024/4/17 17:26
 *
 * https://leetcode.cn/problems/palindrome-partitioning/
 * 131. 分割回文串
 * 回溯算法
 */
public class _131_partition {

    List<List<String>> res = new ArrayList<>();

    LinkedList<String> track = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }

    private void backtrack(String s, int start){
        if (start == s.length()){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start,i)){
                continue;
            }
            track.addLast(s.substring(start,i+1));
            backtrack(s, i+1);
            track.removeLast();
        }
    }

    private boolean isPalindrome(String s , int start, int end){
        if (start > end) return false;
        while(start <= end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
