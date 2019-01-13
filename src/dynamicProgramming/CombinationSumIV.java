package dynamicProgramming;

import java.util.Arrays;

/**
 * 377. Combination Sum IV
 * @author yutian
 * @since Aug 10, 2016
 */
public class CombinationSumIV {
	
	public static int combinationSum41(int[] nums, int target) {
        Arrays.sort(nums);
        int[] dp = new int[target + 1];
        for (int i = 1; i < dp.length; i++) {
        	for (int n : nums) {
        		if (i > n)
        			dp[i] += dp[i - n];
        		else if (i == n)
        			dp[i]++;
        		else break;
        	}
        }
        return dp[target];
    }

	// top - decr DP table
	public static int combinationSum42(int[] nums, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		return helper(nums, target, dp);
	}

	private static int helper(int[] nums, int target, int[] dp) {
		if (dp[target] != -1) {
			return dp[target];
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				res += helper(nums, target - nums[i], dp);
			}
		}
		dp[target] = res;
		return res;
	}
	
	// bottom - incr
	public static int combinationSum43(int[] nums, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i >= nums[j]) {
					dp[i] += dp[i - nums[j]];
				}
			}
		}
		return dp[target];
	}
	
	public static void main(String[] args) {
//		System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
		System.out.println(combinationSum43(new int[]{3, 1, 2, 4}, 4));
	}

	// recursive method, too slow, time limit exceeded
	public static int combinationSum4(int[] nums, int target) {
		if (target == 0) return 1;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				res += combinationSum4(nums, target - nums[i]);
			}
		}
		return res;
	}

	
}
