package dynamicProgramming;
/**
 * 64. Minimum Path Sum
 * @author yutian
 * @since Aug 12, 2015
 */
public class MinimumPathSum {
	
	// Solution 3: top-decr approach if immutable
	public int minPathSum3(int[][] grid) {
		// d(i, j) = min{d(i-1, j) if i > 0, d(i, j-1) if j > 0} + g[i, j]
		int m = grid.length;
		int n = grid[0].length;
		int[][] d = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					d[i][j] = grid[i][j];
				} else {
					d[i][j] = Math.min((i > 0) ? d[i - 1][j] : Integer.MAX_VALUE, 
								         (j > 0) ? d[i][j - 1] : Integer.MAX_VALUE) + grid[i][j];
				}
			}
		}
		return d[m - 1][n - 1];
	}
	
	// Solution: bottom-incr approach if immutable
	public int minPathSum0(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] d = new int[m + 1][n + 1];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) {
					d[i][j] = grid[i][j];
				} else if (j == n - 1 && i != m - 1) {
					d[i][j] = grid[i][j] + d[i + 1][j];
				} else if (j != n - 1 && i == m - 1) {
					d[i][j] = grid[i][j] + d[i][j + 1];
				} else {
					d[i][j] = Math.min(d[i + 1][j], d[i][j + 1]) + grid[i][j];
				}
			}
		}
		return 0;
	}
	
	// Solution 1 if mutable
	public int minPathSum(int[][] grid) {
		if (grid.length == 0) return 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) continue;
				int leftSum = (j > 0) ? grid[i][j-1] : Integer.MAX_VALUE;
				int topSum = (i > 0) ? grid[i-1][j] : Integer.MAX_VALUE;
				grid[i][j] += Math.min(leftSum, topSum);
			}
		}
		return grid[m - 1][n - 1];
	}
		
	// Solution 2
	public int minPathSum2(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 1; i < m; i++) {
			grid[i][0] += grid[i-1][0];
		}
		for (int i = 1; i < n; i++) {
			grid[0][i] += grid[0][i-1];
		}
		int min = 0;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				min = Math.min(grid[i][j-1], grid[i-1][j]);
				grid[i][j] += min;
			}
		}
		return grid[m-1][n-1];
	}
	
	// Solution 4: 1-d DP
	public int minPathSum4(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int min = Math.min(m, n), max = Math.max(m, n);
		int[] sum = new int[min];
		int value;
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < min; j++) {
				if (n == min) {
					value = grid[i][j];
				} else { // m = min
					value = grid[j][i]; // rotate the matrix
				}
				if (i == 0 && j == 0) {
					sum[j] = value;
				} else {
					sum[j] = Math.min((i > 0) ? sum[j] : Integer.MAX_VALUE,
									  (j > 0) ? sum[j - 1] : Integer.MAX_VALUE) + value;
				}
			}
		}
		return sum[min - 1];
	}
}
