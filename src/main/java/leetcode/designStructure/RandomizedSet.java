package leetcode.designStructure;

import structure.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @autor yud1
 * @date 2024/4/19 14:10
 */
public class RandomizedSet {

    List<Integer> list; 

    Map<Integer, Integer> valToIndex;

    public RandomizedSet() {
       list = new ArrayList<>();
       valToIndex = new HashMap<>();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)){
            return false;
        }
        list.add(val);
        valToIndex.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)){
            return false;
        }
        Integer index = valToIndex.get(val);
        Integer lastValue = list.get(list.size() - 1);
        list.set(index, lastValue);
        valToIndex.put(lastValue,index);
        list.remove(list.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}
