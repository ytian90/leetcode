package dfs_bfs;
/**
 * 329. Longest Increasing Path in a Matrix
 * @author yutian
 * @since Jan 23, 2016
 */
public class LongestIncreasingPathInAMatrix {
	// time O(nm)
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix.length == 0) return 0;
		int n = matrix.length, m = matrix[0].length;
		int[][] dp = new int[n][m];
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				res = Math.max(res, dfs(i, j, matrix, dp));
			}
		}
		return res;
	}

	private static int dfs(int i, int j, int[][] matrix, int[][] dp) {
		if (dp[i][j] > 0)
			return dp[i][j];
		int max = 0;
		for (int[] d :dir) {
			int x = d[0] + i, y = d[1] + j;
			if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
					&& matrix[x][y] > matrix[i][j])
				max = Math.max(max, dfs(x, y, matrix, dp));
		}
		dp[i][j] = 1 + max;
		return dp[i][j];
	}

	public static void main(String[] args) {
		int[][] t1 = new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
		int[][] t2 = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
		System.out.println(longestIncreasingPath(t1));
		System.out.println(longestIncreasingPath(t2));
	}

}
