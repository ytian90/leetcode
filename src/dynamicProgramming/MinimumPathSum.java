package dynamicProgramming;
/**
 * 64. Minimum Path Sum
 * @author yutian
 * @since Aug 12, 2015
 */
public class MinimumPathSum {
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
	
	// Solution 3: top-down approach if immutable
	public int minPathSum3(int[][] grid) {
		// d(i, j) = min{d(i-1, j) if i > 0, d(i, j-1) if j > 0} + g[i, j]
		int m = grid.length;
		int n = grid[0].length;
		int[][] sum = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					sum[i][j] = grid[i][j];
				} else {
					sum[i][j] = Math.min((i > 0) ? sum[i - 1][j] : Integer.MAX_VALUE, 
								         (j > 0) ? sum[i][j - 1] : Integer.MAX_VALUE) + grid[i][j];
				}
			}
		}
		return sum[m - 1][n - 1];
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
