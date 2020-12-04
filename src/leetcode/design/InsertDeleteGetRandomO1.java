package leetcode.design;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 * @author yutian
 * @since Aug 31, 2016
 */
public class InsertDeleteGetRandomO1 {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        list = new LinkedList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int replaceVal = list.get(list.size() - 1);
        int valIndex = map.get(val);
        if (replaceVal != val) {
            list.set(valIndex, replaceVal);
            map.put(replaceVal, valIndex);
        }

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomO1 randomizedSet = new InsertDeleteGetRandomO1();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }

}
