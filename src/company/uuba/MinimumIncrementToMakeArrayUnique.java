package company.uuba;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * LC 945. Minimum Increment to Make Array Unique
 */
public class MinimumIncrementToMakeArrayUnique {
    public int minIncrementForUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0, need = 0;
        Arrays.sort(nums);
        for (int i : nums) {
            res += Math.max(need - i, 0);
            need = Math.max(i, need) + 1;
        }
        return res;
    }
    /**
     * Time: O(NlogN)
     * Space: O(1)
     */

    public int minIncrementForUnique2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0, need = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            int val = map.get(key);
            res += val * Math.max(need - key, 0) + val * (val - 1) / 2;
            need = Math.max(need, key) + val;
        }
        return res;
    }
    /**
     * Time: O(NlogK)
     * Space: O(K)
     */

}
