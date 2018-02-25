package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 * @author yutian
 * @since Aug 30, 2015
 */
public class N_Queens {
	public static List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		List<List<String>> res = new ArrayList<>();
		helper(board, 0, res);
		return res;
	}

	private static void helper(char[][] board, int col, List<List<String>> result) {
		if (col == board.length) {
			result.add(build(board));
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (isValid(board, i, col)) {
				board[i][col] = 'Q';
				helper(board, col + 1, result);
				board[i][col] = '.';
			}
		}
	}

	private static boolean isValid(char[][] board, int x, int y) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < y; j++) {
				if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
					return false;
			}
		}
		return true;
	}

	private static List<String> build(char[][] board) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}
	
	public static void main(String[] args) {
		for (List<String> l : solveNQueens(5)) {
			System.out.println(l);
		}
	}
}
