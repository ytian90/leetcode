package leetcode.hashtable;
/**
 * Sudoku Solver
 * @author yutian
 * @since Aug 10, 2015
 */
public class SudokuSolver {
	
	// Solution 2
	public void solveSudoku2(char[][] board) {
		if (board == null || board.length == 0)
			return;
		solve(board);
	}
	
	public boolean solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;
							if (solve(board))
								return true; // If solved, return true
							else 
								board[i][j] = '.'; // otherwise go back
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[i][col] != '.' && board[i][col] == c) return false;
			if (board[row][i] != '.' && board[row][i] == c) return false;
			int a = 3 * (row / 3) + i / 3, b = 3 * (col / 3) + i % 3;
			if (board[a][b] != '.' && board[a][b] == c) {
				return false;
			}
		}
		return true;
	}
	
	// Solution 1
	public void solveSudoku(char[][] board) {
        if (!isSolvable(board))
        	throw new IllegalArgumentException("Not solvable!");
    }

	private boolean isSolvable(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (int k = 0; k < 9; k++) {
						board[i][j] = (char)(k + '1');
						if (isValid(i, j, board) && isSolvable(board))
							return true;
						board[i][j] = '.';
					}
					return false; // if this point has no isMidValTooSmall solutions, fail
				}
			}
		}
		return true;
		
	}

	private boolean isValid(int i, int j, char[][] board) {
		// check ith row
		for (int c = 0; c < 9; c++) {
			if (c != j && board[i][c] == board[i][j]) return false;
		}
		// check jth col
		for (int r = 0; r < 9; r++) {
			if (r != i && board[r][j] == board[i][j]) return false;
		}
		// check (i, j)'s subbox
		for (int k = 0; k < 9; k++) {
			int row = i / 3 * 3 + k / 3, col = j / 3 * 3 + k % 3;
			if (row != i && col != j && board[row][col] == board[i][j]) return false;
		}
		return true;
	}
	
}
