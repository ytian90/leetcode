package company.uuba;

/**
 * LC 48. Rotate Image
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: [[1]]
 * Example 4:
 *
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 */
public class RotateImage {
    /**
     * clockwise rotate
     * first reverse incr to decr, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */
    public void rotate(int[][] matrix) {
        int start = 0, end = matrix.length - 1;
        while (start < end) {
            int[] t = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = t;
            start++;
            end--;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    public static void anti_rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols - 1;
        while (i < j) {
            for (int k = 0; k < rows; k++) {
                int t = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = t;
            }
            i++; j--;
        }
        for (i = 0; i < rows; i++) {
            for (j = i + 1; j < cols; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

}
