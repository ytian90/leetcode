package array;

import java.util.Arrays;

/**
 * 289. Game of Life
 * @author yutian
 * @since Oct 26, 2015
 */
public class GameOfLife {
	/*
	state transitions:
	0: dead to dead
	1: live to live
	2: live to dead
	3: dead to live
	 */
	public static void main(String[] args) {
		int[][] b = {
				{0, 1, 0},
				{0, 0, 1},
				{1, 1, 1},
				{0, 0, 0}
		};
		for (int[] a : b) {
			System.out.println(Arrays.toString(a));
		}
		gameOfLife(b);
		System.out.println();
		for (int[] a : b) {
			System.out.println(Arrays.toString(a));
		}
	}

	static int[][] dirs = {
			{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
	};

	public static void gameOfLife(int[][] board) {
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
