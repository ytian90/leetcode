package leetcode.mj.google;

import java.util.HashMap;
import java.util.Map;

/**
 * 14. lc659
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public static boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendFreq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (freq.get(i) == 0) {
                continue;
            } else if (appendFreq.getOrDefault(i, 0) > 0) {
                appendFreq.put(i, appendFreq.get(i) - 1);
                appendFreq.put(i + 1, appendFreq.getOrDefault(i, 0) + 1);
            } else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                appendFreq.put(i + 3, appendFreq.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPossible(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(isPossible(new int[]{1, 2, 3, 4, 4, 5}));
        System.out.println(isPossible(new int[]{1,2,3,3,4,4,5,5}));
    }
}
