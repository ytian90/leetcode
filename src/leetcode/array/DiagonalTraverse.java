package leetcode.array;

import java.util.Arrays;

/**
 * 498. Diagonal Traverse
 * @author ytian
 *
 */
public class DiagonalTraverse {

	public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) 
        	return new int[0];
        int n = matrix.length, m = matrix[0].length;
        int[] res = new int[n * m];
        int row = 0, col = 0, d = 1;
        for (int i = 0; i < n * m; i++) {
        	res[i] = matrix[row][col];
        	row -= d;
        	col += d;
        	
        	if (row >= n) {row = n - 1; col += 2; d = -d;}
        	if (col >= m) {col = m - 1; row += 2; d = -d;}
        	if (row < 0) {row = 0; d = -d;}
        	if (col < 0) {col = 0; d = -d;}
        }
        return res;
    }
	
	/*
	 * If out of bottom border (row >= m) then row = m - 1; col += 2; change walk direction.
	 * if out of right border (col >= n) then col = n - 1; row += 2; change walk direction.
	 * if out of top border (row < 0) then row = 0; change walk direction.
	 * if out of left border (col < 0) then col = 0; change walk direction.
	 * Otherwise, just go along with the current direction.
	 */
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
			{1},
			{4},
			{7}
		})));
		
		System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
			{1, 2, 3},
		})));
		
		System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
			{1, 2},
			{4, 5},
			{7, 8}
		})));
		
		System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
			{1, 2, 3},
			{4, 5, 6}
		})));
		
		System.out.println(Arrays.toString(findDiagonalOrder(new int[][]{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		})));
		
	}
}
