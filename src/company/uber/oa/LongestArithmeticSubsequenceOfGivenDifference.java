package company.uber.oa;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 1218. Longest Arithmetic Subsequence of Given Difference
 */
public class LongestArithmeticSubsequenceOfGivenDifference {

    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for (int i : arr) {
            int prev = map.getOrDefault(i - difference, 0);
            map.put(i, prev + 1);
            res = Math.max(res, prev + 1);
        }
        return res;
    }


}
