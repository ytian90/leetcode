package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * @author yutian
 * @since Jul 28, 2015
 */
public class SpiralMatrix {
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
        		return res;
        }
        int rowStart = 0, colStart = 0;
        int rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
        		// traverse right
        		for (int j = colStart; j <= colEnd; j++) {
        			res.add(matrix[rowStart][j]);
        		}
        		rowStart++;
        		// traverse down
        		for (int i = rowStart; i <= rowEnd; i++) {
        			res.add(matrix[i][colEnd]);
        		}
        		colEnd--;
        		// traverse left
        		if (rowStart <= rowEnd) { // use case 2
        			for (int j = colEnd; j >= colStart; j--) {
        				res.add(matrix[rowEnd][j]);
        			}
        		}
        		rowEnd--;
        		// traverse up
        		if (colStart <= colEnd) {
        			for (int i = rowEnd; i >= rowStart; i--) {
        				res.add(matrix[i][colStart]);
        			}
        		}
        		colStart++;
        }
        
        return res;
    }
	
	public List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> elements = new ArrayList<>();
		if (matrix.length == 0) return elements;
		int m = matrix.length, n = matrix[0].length;
		int row = 0, col = -1;
		while (true) {
			for (int i = 0; i < n; i++) {
				elements.add(matrix[row][++col]);
			}
			if (--m == 0) break;
			for (int i = 0; i < m; i++) {
				elements.add(matrix[++row][col]);
			}
			if (--n == 0) break;
			for (int i = 0; i < n; i++) {
				elements.add(matrix[row][--col]);
			}
			if (--m == 0) break;
			for (int i = 0; i < m; i++) {
				elements.add(matrix[--row][col]);
			}
			if (--n == 0) break;
		}
		return elements;
	}
	
	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][] {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		}));
		System.out.println(spiralOrder(new int[][] {
			{2, 3},
		}));
	}
}
