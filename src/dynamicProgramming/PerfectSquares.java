package dynamicProgramming;

import java.util.Arrays;

/**
 * Perfect Squares
 * @author yutian
 * @since Dec 6, 2015
 */
public class PerfectSquares {
	
	// time complexity is n * sqrt(n), space complexity is O(n)
	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i <= n; i++) {
			// for each i, it must be the sum of some number (i - j * j) and 
			// a perfect square number (j * j).
			for (int j = 1; i + j * j <= n; j++) {
				dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(numSquares(10));
	}

}
