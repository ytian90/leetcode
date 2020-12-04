package leetcode.divideAndConquer;
/**
 * 240. Search a 2D Matrix II
 * @author yutian
 * @since Aug 14, 2015
 */
public class SearchA2DMatrix2 {
	// Binary Search
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
	}
	
	public static void main(String[] args) {
		int[][] t1 = new int[][]{{1,   4,  7, 11, 15}, 
								 {2,   5,  8, 12, 19}, 
								 {3,   6,  9, 16, 22}, 
								 {10, 13, 14, 17, 24}, 
								 {18, 21, 23, 26, 30}};
		System.out.println(searchMatrix(t1, 5));
		
	}
}
