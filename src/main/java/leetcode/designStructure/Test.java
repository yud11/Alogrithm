package leetcode.designStructure;

/**
 * @autor yud1
 * @date 2024/4/19 14:38
 */
public class Test {

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.getRandom();
    }
}
