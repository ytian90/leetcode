package leetcode.array;
/**
 * Search a 2D Matrix
 * @author yutian
 * @since Aug 19, 2015
 */
public class SearchA2DMatrix {
	// Binary Search: Time ~O(log(MN)), Space ~O(1)
	public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int r = mid / n, c = mid % n;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (matrix[lo / n][lo % n] == target) return true;
        return false;
	}
	
	public static void main(String[] args) {
		int[][] t = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		int[][] t2 = new int[][]{{1}};
		System.out.println(searchMatrix(t, 3));
		System.out.println(searchMatrix(t2, 0));
	}
	
	// Solution 2, basically same as solution 1
	public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            int start = 0, rows = matrix.length, cols = matrix[0].length;
            int end = rows * cols - 1;
            while (start <= end) { // diff from solution 1
                int mid = (start + end) / 2;
                if (matrix[mid / cols][mid % cols] == target) {
                    return true;
                } // diff from solution 1: use if instead of else if
                if (matrix[mid / cols][mid % cols] < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
    }
}
