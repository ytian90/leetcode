package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 62. Unique Paths
 * @author yutian
 * @since Jul 31, 2015
 */
public class UniquePaths {

	// 1-d DP（滚动数组）: Time ~ O(M*N), Space ~ O(min{M, N})
	public int uniquePaths4(int m, int n) {
		int min = Math.min(m, n), max = Math.max(m, n);
		int[] d = new int[min];
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < min; j++) {
				if (i == 0 && j == 0) {
					d[j] = 1;
				} else {
					d[j] = ((i > 0) ? d[j] : 0) + ((j > 0) ? d[j - 1]: 0);
				}
			}
		}
		return d[min - 1];
	}
	
	//  2-d DP: Time ~ O(M*N), Space ~ O(M*N) 
	public static int uniquePaths2(int m, int n) {
		int[][] d = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					d[i][j] = 1;
				} else {
					d[i][j] = ((i > 0) ? d[i - 1][j] : 0)
								+ ((j > 0) ? d[i][j - 1] : 0);
				}
			}
		}
		return d[m - 1][n - 1];
	}

	// Solution 3: Bottom-incr dynamic programming
	// 2-d DP: Time ~ O(M*N), Space ~ O(M*N) 
	public int uniquePaths3(int m, int n) {
		int[][] d = new int[m + 1][n + 1];
		d[m - 1][n] = 1;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				d[i][j] = d[i + 1][j] + d[i][j + 1];
			}
		}
		return d[0][0];
	}
	
	// Solution 0: DP
	public static int uniquePaths0(int m, int n) {
		if (m == 0 || n == 0) return 0;
		if (m == 1 || n == 1) return 1;
		int[][] dp = new int[m][n];
		// only one col, each box has only one path
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		// only one row, each box has only one path
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		// for each body node, number of path = paths from top + paths from left
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
	
	// Solution 1: Backtracking
	public static int uniquePaths(int m, int n) {
		return backtrack(0, 0, m, n);
	}
	private static int backtrack(int r, int c, int m, int n) {
		if (r == m - 1 && c == n - 1) 
			return 1;
		if (r >= m || c >= n)
			return 0;
		return backtrack(r + 1, c, m, n) + backtrack(r, c + 1, m, n);
	}
	
	public static void main(String[] args) {
		UniquePaths t = new UniquePaths();
		System.out.println(t.uniquePaths4(3, 2));
		
	}
	
}
