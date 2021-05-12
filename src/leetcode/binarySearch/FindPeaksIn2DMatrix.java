package leetcode.binarySearch;

import java.util.Arrays;

/**
 * LC 162. extension question
 */
public class FindPeaksIn2DMatrix {
    // Time: O(NlogM)
    // Space: O(1)
    public static int[] findPeak(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int lo = 0, hi = m - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int[] max = findMax(matrix, mid);
            if (matrix[max[0]][max[1] - 1] > matrix[max[0]][max[1]]) {
                hi = mid;
            } else if (matrix[max[0]][max[1] + 1] > matrix[max[0]][max[1]]) {
                lo = mid + 1;
            } else {
                return max;
            }
        }
        return findMax(matrix, lo);
    }

    private static int[] findMax(int[][] matrix, int col) {
        int max = matrix[0][col];
        int[] res = new int[2];
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][col] > max) {
                max = matrix[i][col];
                res = new int[]{i, col};
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findPeak(new int[][]{
                {1, 5, 10, 12},
                {14, 13, 12, 9},
                {15, 9, 11, 17},
                {16, 17, 19, 20}
        })));
    }
}
