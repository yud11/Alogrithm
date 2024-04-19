package leetcode.array.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @autor yud1
 * @date 2024/4/17 17:47
 *
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 *
 * 3. 无重复字符的最长子串
 * 滑动窗口
 */
public class _3_lengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int start = 0;
        int end = 0;
        int res= 0;
        while(end < s.length()){
            char c = s.charAt(end);
            end++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while(window.get(c) > 1){
                char d = s.charAt(start);
                window.put(d, window.get(d) - 1);
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
