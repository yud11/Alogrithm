package leetcode.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor yud1
 * @date 2024/4/17 16:24
 *
 * https://leetcode.cn/problems/restore-ip-addresses/description/
 *
 * 93. 复原 IP 地址
 *
 * 回溯算法
 */
public class restoreIpAddresses {

    List<String> res = new ArrayList<>();

    LinkedList<String> track = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s,0);
        return res;
    }

    private void backtrack(String s, int start){
        // base case
        if (start ==  s.length() && track.size() == 4){
            res.add(track.stream().collect(Collectors.joining(",")));
        }
        for (int i = start+1; i < s.length(); i++) {
            if (!isValid(s, start, i)){
                continue;
            }
            track.addLast(s.substring(start,i+1));
            backtrack(s, i+1);
            track.removeLast();
        }
    }

    private boolean isValid(String s, int start, int end){
        String substring = s.substring(start, end + 1);
        if (substring.length() > 3 || substring.length() <= 0){
            return false;
        }
        if(substring.length() == 1){
            return true;
        }
        if (substring.charAt(start) == '0'){
            return false;
        }
        if(substring.length() == 3){
            if (Integer.parseInt(s.substring(start,end+1)) > 255 ){
                return false;
            }else{
                return  true;
            }
        }
        return true;
    }


}
