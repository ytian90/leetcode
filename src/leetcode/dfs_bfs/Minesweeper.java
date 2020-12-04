package leetcode.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 529. Minesweeper
 * GG MJ
 * https://instant.1point3acres.com/thread/204403
 * @author ytian
 *
 */
public class Minesweeper {

	/*
	 * This is a typical Search problem, either by using DFS or BFS. Search rules:
	 * If click on a mine ('M'), mark it as 'X', stop further search.
	 * If click on an empty cell ('E'), depends on how many surrounding mine:
	 * 2.1 Has surrounding mine(s), mark it with number of surrounding mine(s), stop further search.
	 * 2.2 No surrounding mine, mark it as 'B', continue search its 8 neighbors.
	 */
	
	/**
	 * DFS
	 * @param board
	 * @param click
	 * @return
	 */
	public static char[][] updateBoard(char[][] board, int[] click) {
		int n = board.length, m = board[0].length;
		int row = click[0], col = click[1];
		if (board[row][col] == 'M') {
			board[row][col] = 'X';
			return board;
		}
		int count = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i == 0 && j == 0) continue;
				int r = row + i, c = col + j;
				if (r < 0 || r >= n || c < 0 || c >= m) continue;
				if (board[r][c] == 'M' || board[r][c] == 'X') count++;
			}
		}
		if (count > 0) {
			board[row][col] = (char)(count + '0');
		} else {
			board[row][col] = 'B';
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i == 0 && j == 0) continue;
					int r = row + i, c = col + j;
					if (r < 0 || r >= n || c < 0 || c >= m) continue;
					if (board[r][c] == 'E') updateBoard(board, new int[]{r, c});
				}
			}
		}
		return board;
    }
	
	public static void main(String[] args) {
		
		// create a new board
		char[][] board = new char[5][5];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (Math.random() < 0.3) board[i][j] = 'M';
				else board[i][j] = 'E';
			}
		}
		
		print(board);
		
		// update the board based on click
		board = updateBoard(board, new int[]{0, 1});
		
		print(board);
	}
	
	public static void print(char[][] board) {
		System.out.println();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	
	/**
	 * BFS
	 * @param board
	 * @param click
	 * @return
	 */
	public char[][] updateBoard2(char[][] board, int[] click) {
		int m = board.length, n = board[0].length;
		Queue<int[]> q = new LinkedList<>();
		q.add(click);
		
		while (!q.isEmpty()) {
			int[] cell = q.poll();
			int row = cell[0], col = cell[1];
			if (board[row][col] == 'M') {
				board[row][col] = 'X';
			} else {
				int count = 0;
				for (int i = -1; i < 2; i++) {
					for (int j = -1; j < 2; j++) {
						if (i == 0 && j == 0)
							continue;
						int r = row + i, c = col + j;
						if (r < 0 || r >= m || c < 0 || c >= n)
							continue;
						if (board[r][c] == 'M' || board[r][c] == 'X')
							count++;
					}
				}
				if (count > 0) { // If it is not a 'B', stop further BFS
					board[row][col] = (char) (count + '0');
				} else { // Continue DFS to adjacent cells
					board[row][col] = 'B';
					for (int i = -1; i < 2; i++) {
						for (int j = -1; j < 2; j++) {
							if (i == 0 && j == 0)
								continue;
							int r = row + i, c = col + j;
							if (r < 0 || r >= m || c < 0 || c >= n)
								continue;
							if (board[r][c] == 'E') {
								updateBoard(board, new int[] { r, c });
								board[r][c] = 'B';
							}
						}
					}
				}
			}
		}
		return board;
    }
	
	public static void methodFromPrinceton(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		double p = Double.parseDouble(args[2]);
		
		// game grid is [1..m][1..n], border is used to handle boundary cases
        boolean[][] bombs = new boolean[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                bombs[i][j] = (Math.random() < p);

        // print game
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (bombs[i][j]) System.out.print("* ");
                else             System.out.print(". ");
            System.out.println();
        }

        // sol[i][j] = # bombs adjacent to cell (i, j)
        int[][] sol = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                // (ii, jj) indexes neighboring cells
                for (int ii = i - 1; ii <= i + 1; ii++)
                    for (int jj = j - 1; jj <= j + 1; jj++) {
                    	if (ii < 0 || ii >= m || jj < 0 || jj >=n) continue;
                        if (bombs[ii][jj]) sol[i][j]++;
                    }

        // print solution
        System.out.println();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bombs[i][j]) System.out.print("* ");
                else             System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
	}

	
}
