package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 */
public class FourSum2 {

    // time O(N^2) space O(N^2)
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = -(C[i] + D[j]);
                if (map.containsKey(sum)) {
                    res += map.get(sum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSumCount(
                new int[]{ 1, 2},
                new int[]{-2,-1},
                new int[]{-1, 2},
                new int[]{ 0, 2}));
    }
}
