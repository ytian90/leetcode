package company.lnkin;

/**
 * LC 698. Partition to K Equal Sum Subsets
 *
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 * Example 1:
 *
 * Input: nums = [4,3,2,3,5,2,1], k = 4
 * Output: true
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Example 2:
 *
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 16
 * 1 <= nums[i] <= 104
 * The frequency of each element is in the range [1, 4].
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (sum % k != 0 || max > sum / k) {
            return false;
        }
        return helper(nums, k, new boolean[nums.length], 0, 0, sum / k);
    }

    private boolean helper(int[] nums, int k, boolean[] visited, int start, int currSum, int targetSum) {
        if (k == 0) return true;
        if (currSum == targetSum) {
            return helper(nums, k - 1, visited, 0, 0, targetSum);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i] || currSum + nums[i] > targetSum) {
                continue;
            }
            visited[i] = true;
            if (helper(nums, k, visited, i + 1, currSum + nums[i], targetSum)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
    // Time: O(K * 2 ^ N)
    // Space: O(N)

    // follow up: negative numbers are allowed
    public static boolean canPartitionKSubsets_negative(int[] nums, int k) {
        int sum = 0, max = 0;
        for (int i : nums) {
            sum += i;
            max = Math.max(max, i);
        }
        if (sum % k != 0) {
            return false;
        }
        return helper_negative(nums, k, new boolean[nums.length], 0, 0, sum / k);
    }

    private static boolean helper_negative(int[] nums, int k, boolean[] visited, int start, int currSum, int targetSum) {
        if (k == 0) return true;
        if (currSum == targetSum) {
            return helper_negative(nums, k - 1, visited, 0, 0, targetSum);
        }
        for (int i = start; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (helper_negative(nums, k, visited, i + 1, currSum + nums[i], targetSum)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets_negative(new int[]{4, -1, 3, 2, 1, -5, 8}, 3));
    }
}
