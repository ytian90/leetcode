package leetcode.hashtable;

import java.util.*;

/**
 * 1429. First Unique Number
 */
public class FirstUniqueNumber {
    Map<Integer, Integer> freq = new HashMap<>();
    Queue<Integer> q = new LinkedList<>();

    public FirstUniqueNumber(int[] nums) {
        for (int n : nums) {
            add(n);
        }
    }

    public int showFirstUnique() {
        while (!q.isEmpty() && freq.get(q.peek()) > 1) {
            q.poll();
        }
        return q.isEmpty() ? -1 : q.peek();
    }

    public void add(int value) {
        freq.put(value, freq.getOrDefault(value, 0) + 1);
        q.offer(value);
    }

    public static void main(String[] args) {
        FirstUniqueNumber firstUniqueNumber = new FirstUniqueNumber(new int[]{2, 3, 5});
        firstUniqueNumber.showFirstUnique();
        firstUniqueNumber.add(5);
        firstUniqueNumber.showFirstUnique();
        firstUniqueNumber.add(2);
        firstUniqueNumber.showFirstUnique();
        firstUniqueNumber.add(3);
        firstUniqueNumber.showFirstUnique();
    }
}
