package leetcode.array;

import java.util.Arrays;

/**
 * 73. Set Matrix Zeroes
 * @author yutian
 * @since Aug 19, 2015
 */
public class SetMatrixZeroes {
	public static void setZerose(int[][] matrix) {
		int col0 = 1, rows = matrix.length, cols = matrix[0].length;

		for (int i = 0; i < rows; i++) {
			if (matrix[i][0] == 0) col0 = 0;
			for (int j = 1; j < cols; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}

		for (int i =rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (col0 == 0) matrix[i][0] = 0;
		}
	}

	public static void setZeroes(int[][] matrix) {
		if (matrix == null) return;
		int m = matrix.length, n = matrix[0].length;
		boolean isFirstRowZero = false, isFirstColZero = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					if (i == 0) isFirstRowZero = true;
					if (j == 0) isFirstColZero = true;
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		// zero rows (except the first row)
		for (int i = 1; i < m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		// zero cols (except the first col)
		for (int j = 1; j < n; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 0; i < m; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		// zero first row if necessary
		if (isFirstRowZero) {
			for (int j = 0; j < n; j++) {
				matrix[0][j] = 0;
			}
		}
		
		// zero first col if necessary
		if (isFirstColZero) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] m = new int[][] {
			{1, 1, 0, 1},
			{1, 1, 1, 1},
			{1, 0, 1, 1},
			{1, 1, 1, 1},
		};
		setZeroes(m);
		System.out.println(Arrays.deepToString(m));
		
		int[][] m2 = new int[][] {
			{1},
			{0}
		};
		setZeroes(m2);
		System.out.println(Arrays.deepToString(m2));
	}
}
