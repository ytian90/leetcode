package hashtable;
/**
 * Sudoku Solver
 * @author yutian
 * @since Aug 10, 2015
 */
public class SudokuSolver {
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
					return false; // ???
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
