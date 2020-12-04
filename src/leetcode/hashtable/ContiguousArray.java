package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 */
public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int countZero = 0, countOne = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) countZero++;
            if (nums[i] == 1) countOne++;
            int diff = countZero - countOne;
            if (diff == 0) {
                maxLen = i + 1;
            } else {
                if (map.containsKey(diff)) {
                    maxLen = Math.max(maxLen, i - map.get(diff));
                } else {
                    map.put(diff, i);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 0}));
    }
}
