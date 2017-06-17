package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * N-Queens
 * @author yutian
 * @since Aug 30, 2015
 */
public class N_Queens {
	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		List<List<String>> result = new ArrayList<List<String>>();
		dfs(board, 0, result);
		return result;
	}

	private void dfs(char[][] board, int col, List<List<String>> result) {
		if (col == board.length) {
			result.add(build(board));
			return;
		}
		for (int i = 0; i < board.length; i++) {
			if (isValid(board, i, col)) {
				board[i][col] = 'Q';
				dfs(board, col + 1, result);
				board[i][col] = '.';
			}
		}
	}

	private boolean isValid(char[][] board, int x, int y) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < y; j++) {
				if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
					return false;
			}
		}
		return true;
	}

	private List<String> build(char[][] board) {
		List<String> result = new LinkedList<String>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			result.add(s);
		}
		return result;
		
	}
}
