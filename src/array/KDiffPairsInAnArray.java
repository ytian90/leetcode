package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 532. K-diff Pairs in an Array
 */
public class KDiffPairsInAnArray {

    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0));

    }
}
