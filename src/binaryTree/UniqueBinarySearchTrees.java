package binaryTree;
/**
 * Unique Binary Search Trees
 * https://leetcode.com/discuss/24282/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
 * @author yutian
 * @since Aug 21, 2015
 */
public class UniqueBinarySearchTrees {
	
	// time ~O(N^2)
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		return dp[n];
	}
	
	public int numTrees2(int n) {
		if (n == 0 || n == 1) return 1;
		int[] d = new int[n + 1];
		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int k = 0; k < i; k++) {
				d[i] += d[k] * d[i - 1 - k];
			}
		}
		return d[n];
	}	
}
