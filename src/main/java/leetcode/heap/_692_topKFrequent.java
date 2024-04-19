package leetcode.heap;

import java.util.*;

/**
 * @autor yud1
 * @date 2024/4/17 19:39
 */
public class _692_topKFrequent {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words){
            map.put(word, map.getOrDefault(word,0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<String>((a ,b) -> {
            if (map.get(a).equals(map.get(b))){
                return a.compareTo(b);
            }else{
                return map.get(a) - map.get(b);
            }
        });
        for (String word: map.keySet()){
            pq.offer(word);
            if (pq.size() > k){
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
