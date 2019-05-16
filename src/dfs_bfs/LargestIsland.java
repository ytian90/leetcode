package dfs_bfs;
/**
 * Largest Island (not on LeetCode yet)
 * Given a 2d grid map of '1's (land) and '0's (water), sort the area
 * of the largest island. An island is surrounded by water and is 
 * formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * @author yutian
 * @since Aug 24, 2015
 */
public class LargestIsland {
	public int largestIsland(char[][] grid) {
		if (grid.length == 0) return 0;
		int m = grid.length, n = grid[0].length;
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					max = Math.max(max, dfs(grid, i, j, 0));
				}
			}
		}
		// recover the grid
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '#') grid[i][j] = '1';
			}
		}
		return max;
	}
	
	// DFS
	private int dfs(char[][] grid, int i, int j, int count) {
		if (grid[i][j] == '1') {
			grid[i][j] = '#';
			count++;
			int m = grid.length, n = grid[0].length;
			if (i - 1 >= 0) count = dfs(grid, i - 1, j, count);
			if (i + 1 < m)  count = dfs(grid, i + 1, j, count);
			if (j - 1 >= 0) count = dfs(grid, i, j - 1, count);
			if (j + 1 < n)  count = dfs(grid, i, j + 1, count);
		}
		return count;
	}
}
