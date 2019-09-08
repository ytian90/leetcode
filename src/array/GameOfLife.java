package array;

import java.util.Arrays;

/**
 * 289. Game of Life
 * @author yutian
 * @since Oct 26, 2015
 */
public class GameOfLife {
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

	public static void gameOfLife(int[][] board) {
		if (board.length == 0) {
			return;
		}
		int n = board.length, m = board[0].length;
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = board[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int neighbors = calculate(i, j, copy);
				if (copy[i][j] == 1) {
					if (neighbors < 2 || neighbors > 3) {
						board[i][j] = 0;
					} else {
						board[i][j] = 1;
					}
				} else {
					if (neighbors == 3) {
						board[i][j] = 1;
					}
				}
			}
		}
	}

	public static int calculate(int i, int j, int[][] copy) {
		int res = 0;
		for (int[] d : dirs) {
			int x = i + d[0];
			int y = j + d[1];
			if (onBoard(x, y, copy)) {
				res += copy[x][y];
			}
		}
		return res;
	}

	public static boolean onBoard(int x, int y, int[][] copy) {
		if (x < 0 || x >= copy.length || y < 0 || y >= copy[0].length) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] t = new int[][]{
				{0, 1, 0},
				{0, 0, 1},
				{1, 1, 1},
				{0, 0, 0}
		};
		gameOfLife(t);
		for (int[] n : t) {
			System.out.println(Arrays.toString(n));
		}
	}

	/*
	state transitions:
	0: dead to dead
	1: live to live
	2: live to dead
	3: dead to live
	 */
	public static void gameOfLife2(int[][] board) {
		int n = board.length, m = board[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int live = 0;
				for (int[] d : dirs) {
					int x = d[0] + i, y = d[1] + j;
					if (x < 0 || x >= n || y < 0 || y >= m)
						continue;
					if (board[x][y] == 1 || board[x][y] == 2)
						live++;
				}
				if (board[i][j] == 1 && (live < 2 || live > 3)) board[i][j] = 2;
				if (board[i][j] == 0 && (live == 3)) board[i][j] = 3;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				board[i][j] %= 2;
			}
		}
	}

}
