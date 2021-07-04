package company.uuba;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 *
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        int rowStart = 0, colStart = 0, rowEnd = n - 1, colEnd = m - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                res.add(matrix[rowStart][j]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }
        return res;
    }
    /**
     * Time: O(N * M), N is row numbers, M is col numbers.
     * Space: O(N * M)
     */
}
