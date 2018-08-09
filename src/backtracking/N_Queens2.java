package backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 52. N-Queens II
 * @author yutian
 * @since Aug 30, 2015
 */
public class N_Queens2 {
	// method 1
	static int count = 0;

	public static int totalNQueenss(int n) {
		boolean[] cols = new boolean[n];
		boolean[] d1 = new boolean[2 * n];
		boolean[] d2 = new boolean[2 * n];
		helper(0, cols, d1, d2, n);
		return count;
	}

	public static void helper(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
		if (row == n) count++;
		for (int col = 0; col < n; col++) {
			int id1 = col - row + n;
			int id2 = col + row;
			if (cols[col] || d1[id1] || d2[id2]) continue;
			cols[col] = d1[id1] = d2[id2] = true;
			helper(row + 1, cols, d1, d2, n);
			cols[col] = d1[id1] = d2[id2] = false;
		}
	}

	public static void main(String[] args) {
		System.out.println(totalNQueenss(4));
	}

	// method 2
	private final Set<Integer> occupiedCols = new HashSet<>();
	private final Set<Integer> occupiedDiag1s = new HashSet<>();
	private final Set<Integer> occupiedDiag2s = new HashSet<>();
	
	public int totalNQueens(int n) {
		return totalNQueensHelper(0, 0, n);
	}

	private int totalNQueensHelper(int row, int count, int n) {
		for (int col = 0; col < n; col++) {
			if (occupiedCols.contains(col))
				continue;
			int diag1 = row - col;
			if (occupiedDiag1s.contains(diag1))
				continue;
			int diag2 = row + col;
			if (occupiedDiag2s.contains(diag2))
				continue;
			if (row == n - 1)
				count++;
			else {
				occupiedCols.add(col);
				occupiedDiag1s.add(diag1);
				occupiedDiag2s.add(diag2);
				count = totalNQueensHelper(row + 1, count, n);
				occupiedCols.remove(col);
				occupiedDiag1s.remove(diag1);
				occupiedDiag2s.remove(diag2);
			}
		}
		return count;
	}
}
