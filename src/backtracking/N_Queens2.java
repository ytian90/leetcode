package backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * N-Queens II
 * @author yutian
 * @since Aug 30, 2015
 */
public class N_Queens2 {
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
