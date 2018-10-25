package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 846. Hand of Straights
 */
public class HandOfStraights {

    public static boolean isNStraightHand(int[] hand, int W) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : hand) {
            minHeap.add(i);
        }
        while (minHeap.size() != 0) {
            int start = minHeap.poll();
            for (int j = 1; j < W; j++) {
                if (minHeap.remove(start + j)) {
                    continue;
                } else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
        System.out.println(isNStraightHand(new int[]{1,2,3,4, 5, 6}, 2));
        System.out.println(isNStraightHand(new int[]{1,2,3,4, 5}, 4));
    }

    public boolean isNStraightHand2(int[] hand, int W) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                for (int i = W - 1; i >= 0; i--) {
                    if (map.getOrDefault(key + i, 0) < map.get(key)) return false;
                    map.put(key + i, map.get(key + i) - map.get(key));
                }
            }
        }
        return true;
    }
}
