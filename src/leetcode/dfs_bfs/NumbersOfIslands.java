package leetcode.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. Number of Islands
 * @author yutian
 * @since Aug 24, 2015
 */
public class NumbersOfIslands {
	
	// Solution 3: DFS (discussion)
	// time: O(M * N), space: O(M * N)
	public int numIslands(char[][] grid) {
		if (grid == null) return 0;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		// recover the grid
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '#') {
					grid[i][j] = '1';
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != '1') 
			return;
		grid[i][j] = '#';
		dfs(grid, i, j + 1);
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j - 1);
	}
	
	public static void main(String[] args) {
		NumbersOfIslands t = new NumbersOfIslands();
		System.out.println(t.numIslands(new char[][]{{'1', '1', '1', '1', '0'},
								   {'1', '1', '0', '1', '0'},
								   {'1', '1', '0', '0', '0'},
								   {'0', '0', '0', '0', '0'}}));
		System.out.println();
	}
	
	
	// Solution 1: BFS
	public int numIslands3(char[][] grid) {
		int m = grid.length;
		if (m == 0) return 0;
		int n = grid[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					bfs(grid, i, j);
					count++;
				}
			}
		}
		// recover the grid
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '$') {
					grid[i][j] = '1';
				}
			}
		}
		return count;
	}

	private void bfs(char[][] grid, int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		visit(grid, i, j, q);
		while (!q.isEmpty()) {
			int pos = q.poll();
			int x = pos / grid[0].length;
			int y = pos % grid[0].length;
			visit(grid, x - 1, y, q);
			visit(grid, x + 1, y, q);
			visit(grid, x, y - 1, q);
			visit(grid, x, y + 1, q);
		}
	}

	private void visit(char[][] grid, int i, int j, Queue<Integer> q) {
		if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] != '1')
			return;
		grid[i][j] = '$';
		q.add(i * grid[0].length + j);
	}
	
	// Solution 2: DFS
	public int numIslands2(char[][] grid) {
		if (grid.length == 0) return 0;
		int m = grid.length, n = grid[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					dfs3(grid, i, j);
					count++;
				}
			}
		}
		// recover the grid
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '#') {
					grid[i][j] = '1';
				}
			}
		}
		return count;
	}

	private void dfs3(char[][] grid, int i, int j) {
		if (grid[i][j] == '0') return;
		if (grid[i][j] == '1') {
			grid[i][j] = '#';
			int m = grid.length, n = grid[0].length;
			if (i - 1 >= 0) dfs(grid, i - 1, j);
			if (i + 1 < m) dfs(grid, i + 1, j);
			if (j - 1 >= 0) dfs(grid, i, j - 1);
			if (j + 1 < n) dfs(grid, i, j + 1);
		}
	}
	
	
}
