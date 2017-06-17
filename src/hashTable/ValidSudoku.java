package hashTable;

import java.util.Arrays;

/**
 * 36. Valid Sudoku
 * @author yutian
 * @since Aug 10, 2015
 */
public class ValidSudoku {
	
	// Solution 1 Time ~ O(3N^2), Space ~ O(N) 
	public static boolean isValidSudoku(char[][] board) {
		boolean[] visited = new boolean[9];
		// check 9 rows
		for (int i = 0; i < 9; i++) {
			Arrays.fill(visited, false);
			for (int j = 0; j < 9; j++) {
				if (!isValid(i, j, board, visited)) return false;
			}
		}
		// check 9 columns
		for (int i = 0; i < 9; i++) {
			Arrays.fill(visited, false);
			for (int j = 0; j < 9; j++) {
				if (!isValid(j, i, board, visited)) return false;
			}
		}
		// check 9 sub-boxes
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Arrays.fill(visited, false);
				for (int k = 0; k < 9; k++) {
					if (!isValid(i * 3 + k / 3, j * 3 + k % 3, board, visited))
						return false;
				}
			}
		}
		return true;
	}

	private static boolean isValid(int i, int j, char[][] board, boolean[] visited) {
		if (board[i][j] != '.') {
			if (visited[board[i][j] - '1']) {
				return false;
			} else {
				visited[board[i][j] - '1'] = true;
			}
		}
		return true;
	}
	
	// Solution 2
	public static boolean isValidSudoku2(char[][] board) {
		boolean[][] row = new boolean[9][9];
		// i - row index, j - index of '1' to '9'
		boolean[][] col = new boolean[9][9];
		boolean[][] box = new boolean[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char cell = board[i][j];
				if (cell != '.') {
					cell -= '1';
					// check row
					if (row[i][cell]) return false;
					else row[i][cell] = true;
					// check col
					if (col[j][cell]) return false;
					else col[j][cell] = true;
					// check subbox
					if (box[i / 3 * 3 + j / 3][cell]) return false;
					else box[i / 3 * 3 + j / 3][cell] = true;
				}
			}
		}
		return true;
	}
	

	public static void main(String[] args) {
		char[][] board = new char[9][9];
		for (int r = 0; r < 9; r++) {
			Arrays.fill(board[r], '.');
			System.out.println(board[r]);
		}
		board[0][0] = '5';
		board[0][1] = '3';
		board[0][4] = '7';
		board[1][0] = '6';
		board[1][3] = '1';
		board[1][4] = '9';
		board[1][5] = '5';
		board[2][1] = '9';
		board[2][2] = '8';
		board[2][7] = '6';
		board[3][0] = '8';
		board[3][4] = '6';
		board[3][8] = '3';
		board[4][0] = '4';
		board[4][3] = '8';
		board[4][5] = '3';
		board[4][8] = '1';
		board[5][0] = '7';
		board[5][4] = '2';
		board[5][8] = '6';
		board[6][1] = '6';
		board[6][6] = '2';
		board[6][7] = '8';
		board[7][3] = '4';
		board[7][4] = '1';
		board[7][5] = '9';
		board[7][8] = '5';
		board[8][4] = '8';
		board[8][7] = '7';
		board[8][8] = '9';
		for (int r = 0; r < 9; r++) {
			System.out.println(board[r]);
		}
		
		System.out.println(isValidSudoku(board));
	}
	
}
