package mj.google;

/**
 * 给你一个m*n大小数组，只有0和1，问一共有多少个只包含1的正方形，比如3*3的数组，都是1，那就有9+4+1=14个
 */
public class NumOfSquare {
    public static int numOfSquare(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 1 + Math.min(Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numOfSquare(new int[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        }));
    }
}
