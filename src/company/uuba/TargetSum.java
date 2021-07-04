package company.uuba;

/**
 * LC 494. Target Sum
 * You are given an integer array nums and an integer target.
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * - For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 */
public class TargetSum {
    /**
     * DFS solution
     * Time: O(2 ^ N)
     * Space: O(N)
     */
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, target);
    }

    private int helper(int[] nums, int i, int target) {
        if (i == nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }
        return helper(nums, i + 1, target + nums[i]) + helper(nums, i + 1, target - nums[i]);
    }

    /**
     * DP solution
     * The recursive solution is very slow, because its runtime is exponential
     * The original problem statement is equivalent to:Find a subset of nums that need to be positive,
     * and the rest of them negative, such that the sum is equal to target
     * Let P be the positive subset and N be the negative subsetFor example:
     * Given nums = [1, 2, 3, 4, 5] and target = 3 then one possible solution is +1-2+3-4+5 = 3
     * Here positive subset is P = [1, 3, 5] and negative subset is N = [2, 4]
     * Then let's see how this can be converted to a subset sum problem:
     *                  sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                        2 * sum(P) = target + sum(nums)
     * So the original problem has been converted to a subset sum problem as follows:
     * Find a subset P of nums such that sum(P) = (target + sum(nums)) / 2
     * Note that the above formula has proved that target + sum(nums) must be even
     * We can use that fact to quickly identify inputs that do not have a solution.
     */
    public int findTargetSumWays_dp(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return (sum < S || (sum + S) % 2 == 1) ? 0 : subsetSum(nums, (sum + S) / 2);
    }

    private int subsetSum(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
    /**
     * Time: O(L * N), N is the size of nums array, L is the range of sum.
     * Space: O(L * N)
     */

    public int findTargetSumWays_dp_2(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return (sum < S || (sum + S) % 2 == 1) ? 0 : helper(nums, (sum + S) / 2);
    }

    private int helper(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[sum];
    }
    /**
     * Time: O(L * N), N is the size of nums array, L is the range of sum.
     * Space: O(N)
     */
}
