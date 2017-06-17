package divideAndConquer;
/**
 * Search a 2D Matrix II
 * @author yutian
 * @since Aug 14, 2015
 */
public class SearchA2DMatrix2 {
	// Binary Search
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m-1][n-1])
            return false;
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (target > matrix[i][j]) {
                i++;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                return true;
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
