package company.uuba;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 78. Subsets
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int pos) {
        res.add(new ArrayList<>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
    /**
     * Time: O(N * 2 ^ N), N is the length of nums
     * Space: O(N)
     */
}
