package dfs_bfs;
/**
 * 329. Longest Increasing Path in a Matrix
 * @author yutian
 * @since Jan 23, 2016
 */
public class LongestIncreasingPathInAMatrix {
	public static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static int longestIncreasingPath(int[][] matrix) {
		int n = matrix.length;
		if (n == 0) {
			return 0;
		}
		int m = matrix[0].length;
		int[][] cached = new int[n][m];
		int max = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int len = dfs(matrix, i, j, cached);
				max = Math.max(len, max);
			}
		}
		return max;
	}

	private static int dfs(int[][] matrix, int i, int j, int[][] cached) {
		if (cached[i][j] != 0) {
			return cached[i][j];
		}
		int max = 1;
		for (int[] d : dirs) {
			int x = i + d[0], y = j + d[1];
			if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
				continue;
			}
			int len = 1 + dfs(matrix, x, y, cached);
			max = Math.max(len, max);
		}
		cached[i][j] = max;
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestIncreasingPath(new int[][]{
				{9, 9, 4},
				{6, 6, 8},
				{2, 1, 1}
		}));

		System.out.println(longestIncreasingPath(new int[][]{
				{3, 4, 5},
				{3, 2, 6},
				{2, 2, 1}
		}));
	}

	// will cause TLE, but logic is right, just miss memo
	private int max = 0;

	public int longestIncreasingPath2(int[][] matrix) {
		int n = matrix.length;
		if (n == 0) {
			return 0;
		}
		int m = matrix[0].length;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(matrix, i, j, 0, matrix[i][j], visited);
			}
		}
		return max;
	}

	private void dfs(int[][] matrix, int i, int j, int count, int prev, boolean[][] visited) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j] || count != 0 && prev >= matrix[i][j]) {
			return;
		}
		count++;
		max = Math.max(max, count);
		visited[i][j] = true;
		dfs(matrix, i - 1, j, count, matrix[i][j], visited);
		dfs(matrix, i + 1, j, count, matrix[i][j], visited);
		dfs(matrix, i, j - 1, count, matrix[i][j], visited);
		dfs(matrix, i, j + 1, count, matrix[i][j], visited);
		visited[i][j] = false;
	}

}
