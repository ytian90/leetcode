package dynamicProgramming;

import java.util.Arrays;

/**
 * 416. Partition Equal Subset Sum
 * @author yutian
 *
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1)
            return false;
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1)
            return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= n) {
                    dp[i] = dp[i] || dp[i - n];
                }
            }
        }
        return dp[sum];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = new int[]{1, 5, 11, 5};
		System.out.println(canPartition(test));
	}

}
