package leetcode.design;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 460. LFU Cache
 */
public class LFUCache {
    Map<Integer, Integer> vals;
    Map<Integer, Integer> counts;
    Map<Integer, LinkedHashSet<Integer>> lists;
    int capacity;
    int min = -1;

    public LFUCache(int capacity) {
        this.vals = new HashMap<>();
        this.counts = new HashMap<>();
        this.lists = new HashMap<>();
        this.lists.put(1, new LinkedHashSet<>());
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }
        update(key);
        return vals.get(key);
    }

    private void update(int key) {
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if (count == min && lists.get(count).size() == 0) {
            min++;
        }
        addToList(count + 1, key);
    }

    private void addToList(int count, int key) {
        lists.putIfAbsent(count, new LinkedHashSet<>());
        lists.get(count).add(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (vals.containsKey(key)) {
            vals.put(key, value);
            update(key);
            return;
        }
        if (vals.size() == capacity) {
            removeMinFreq();
        }
        vals.put(key, value);
        counts.put(key, 1);
        addToList(1, key);
        min = 1;
    }

    private void removeMinFreq() {
        int key = lists.get(min).iterator().next();
        lists.get(min).remove(key);
        vals.remove(key);
        counts.remove(key);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
