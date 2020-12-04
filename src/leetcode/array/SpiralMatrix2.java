package leetcode.array;

import java.util.Arrays;

/**
 * 59. Spiral Matrix II
 * @author yutian
 * @since Jul 28, 2015
 */
public class SpiralMatrix2 {
	// Time ~O(N), Space ~O(n)
	public static int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int colStart = 0, rowStart = 0;
		int colEnd = n - 1, rowEnd = n - 1;
		int count = 1;
		while (colStart <= colEnd) {
			for (int j = colStart; j <= colEnd; j++) {
				result[rowStart][j] = count++;
			}
			rowStart++;
			for (int i = rowStart; i <= rowEnd; i++) {
				result[i][colEnd] = count++;
			}
			colEnd--;
			for (int j = colEnd; j >= colStart; j--) {
				result[rowEnd][j] = count++;
			}
			rowEnd--;
			for (int i = rowEnd; i >= rowStart; i--) {
				result[i][colStart] = count++;
			}
			colStart++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(generateMatrix(3)));
	}
	
	public static int[][] generateMatrix2(int n) {
		int[][] matrix = new int[n][n];
		int total = n * n;
		
		int x = 0;
		int y = 0;
		int step = 0;
		
		for (int i = 0; i < total; ) {
			while (y + step < n) {
				i++;
				matrix[x][y] = i;
				y++;
			} // x = 0, y = n for iteration 1
			y--;
			x++; // move from [0, n] to [1, n-1]
			while (x + step < n) {
				i++;
				matrix[x][y] = i;
				x++;
			}
			x--;
			y--;
			while (y >= 0 + step) {
				i++;
				matrix[x][y] = i;
				y--;
			}
			y++;
			x--;
			step++; // because x can't go back to 0
			
			while (x >= 0 + step) {
				i++;
				matrix[x][y] = i;
				x--;
			}
			x++;
			y++;
		}
		return matrix;
	}
}
