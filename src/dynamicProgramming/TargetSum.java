package dynamicProgramming;
/**
 * 494. Target Sum
 * @author ytian
 *
 */
public class TargetSum {

	// DP
	public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int n : nums) sum += n;
        return sum < S || (S + sum) % 2 > 0 ? 0 : helper(nums, (S + sum) >>> 1);
    }
	
	private static int helper(int[] nums, int s) {
		int[] dp = new int[s + 1];
		dp[0] = 1;
		for (int n : nums) {
			for (int i = s; i >= n; i--) {
				dp[i] += dp[i - n];
			}
		}
		return dp[s];
	}

	// DFS
	static int res = 0;

	public static int findTargetSumWays2(int[] nums, int S) {
		if (nums == null || nums.length == 0)
			return res;
		int n = nums.length;
		int[] sum = new int[n];
		sum[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			sum[i] = sum[i + 1] + nums[i];
		}
		helper(nums, sum, S, 0);
		return res;
	}

	private static void helper(int[] nums, int[] sum, int target, int pos) {
		if (pos == nums.length) {
			if (target == 0) res++;
			return;
		}
		if (sum[pos] < Math.abs(target)) return;

		helper(nums, sum, target + nums[pos], pos + 1);
		helper(nums, sum, target - nums[pos], pos + 1);
	}

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[]{1, 2, 3, 4, 5}, 1));
		System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
		System.out.println(findTargetSumWays2(new int[]{1}, 1
		));
	}
}
