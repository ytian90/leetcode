package company.uuba.mj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 1743. Restore the Array From Adjacent Pairs
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 *
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 *
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 *
 * Return the original array nums. If there are multiple solutions, return any of them.
 *
 * Example 1:
 *
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 *
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 *
 * Input: adjacentPairs = [[100000,-100000]]
 * Output: [100000,-100000]
 */
public class RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : adjacentPairs) {
            if (!map.containsKey(e[0])) {
                map.put(e[0], new ArrayList<>());
            }
            map.get(e[0]).add(e[1]);
            if (!map.containsKey(e[1])) {
                map.put(e[1], new ArrayList<>());
            }
            map.get(e[1]).add(e[0]);
        }
        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        for (int i : map.keySet()) {
            if (map.get(i).size() == 1) {
                res[0] = i;
                break;
            }
        }
        int p = 1;
        Integer prev = null;
        while (p < res.length) {
            for (int next : map.get(res[p - 1])) {
                if (prev == null || prev != next) {
                    res[p] = next;
                    prev = res[p - 1];
                    p++;
                    break;
                }
            }
        }
        return res;
    }
}
