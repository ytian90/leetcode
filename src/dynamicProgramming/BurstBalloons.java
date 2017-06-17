package dynamicProgramming;
/**
 * 312. Burst Balloons
 * @author yutian
 * @since Feb 15, 2016
 */
public class BurstBalloons {
	// Solution 1: DP time O(n^3)
	public int maxCoins(int[] nums) {
        int[] num = new int[nums.length + 2];
        int n = 1;
        for (int i: nums) if (i > 0) num[n++] = i;
        num[0] = num[n++] = 1;
        
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
        	for (int left = 0; left < n - k; left++) {
        		int right = left + k;
        		for (int i = left + 1; i < right; i++) {
        			dp[left][right] = Math.max(dp[left][right], 
        					num[left] * num[i] * num[right] + dp[left][i] + dp[i][right]);
        		}
        	}
        }
        return dp[0][n - 1];
    }
	
	// Solution 2: Divide and conquer time O(n^3)
	public int maxCoins2(int[] nums) {
        int[] num = new int[nums.length + 2];
        int n = 1;
        for (int i: nums) if (i > 0) num[n++] = i;
        num[0] = num[n++] = 1;
        
        int[][] memo = new int[n][n];
        return helper(num, memo, 0, n - 1);
	}

	private int helper(int[] nums, int[][] memo, int left, int right) {
		if (left + 1 == right) return 0;
		if (memo[left][right] > 0) return memo[left][right];
		int ans = 0;
		for (int i = left + 1; i < right; i++) {
			ans = Math.max(ans, nums[left] * nums[i] * nums[right] + helper(nums, memo, left, i) +
					helper(nums, memo, i, right));
		}
		memo[left][right] = ans;
		return ans;
	}

	public static void main(String[] args) {
		BurstBalloons t = new BurstBalloons();
//		System.out.println(t.maxCoins(new int[]{3, 1, 5, 8}));
		System.out.println(t.maxCoins2(new int[]{3, 1, 5, 8}));
	}

}
