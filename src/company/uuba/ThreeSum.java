package company.uuba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 15. 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i = increase(nums, i)) {
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                if (nums[i] + nums[lo] + nums[hi] == 0) {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    lo = increase(nums, lo);
                    hi = decrease(nums, hi);
                } else if (nums[i] + nums[lo] + nums[hi] < 0) {
                    lo = increase(nums, lo);
                } else {
                    hi = decrease(nums, hi);
                }
            }
        }
        return res;
    }

    public int increase(int[] n, int i) {
        do {
            i++;
        } while (i < n.length - 1 && n[i] == n[i - 1]);
        return i;
    }

    public int decrease(int[] n, int i) {
        do {
            i--;
        } while (i > 0 && n[i] == n[i + 1]);
        return i;
    }
    /**
     * Time: O(N *logN + N ^ 2) ~= O(N ^ 2)
     * Space: O(logN) to O(N), depending on the implementation of the sorting algorithm
     */
}
