package leetcode.dynamicProgramming;
/**
 * 486. Predict the Winner
 * @author ytian
 *
 */
public class PredictTheWinner {
	
	public static boolean PredictTheWinner1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
        	dp[i][i] = nums[i];
        }
        for (int len = 1; len < n; len++) {
        	for (int i = 0; i < n - len; i++) {
        		int j = i + len;
        		dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
        	}
        }
        return dp[0][n - 1] >= 0;
    }

	public static void main(String[] args) {
		System.out.println(PredictTheWinner1(new int[]{1, 5, 2}));
		System.out.println(PredictTheWinner1(new int[]{1, 5, 233, 7}));
	}
	
	public static boolean PredictTheWinner2(int[] nums) {
		if (nums == null) return true;
		int n = nums.length;
		if ((n & 1) == 0) return true;
		int[] dp = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (i == j) {
					dp[i] = nums[i];
				} else {
					dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
				}
			}
		}
		return dp[n - 1] >= 0;
	}

}
