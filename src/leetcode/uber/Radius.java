package leetcode.uber;

/**
 * 题库题
 *     给一个 int[][] array, 一个菱形的 radius。返回所有菱形 sum 最大的前三个数
 *         1
 *      1 1  1    radius = 2
 *         1
 * <p>
 *          1
 *       1  1  1
 *    1 1  1   1   1     radius = 3   
 *       1  1  1
 *           1
 */
public class Radius {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5},
                          {1, 2, 3, 4, 5}};
        int k = 3;
        int n = matrix.length, m = matrix[0].length;
        for (int i = k - 1; i <= n - k; i++) {
            for (int j = k - 1; j <= m - k; j++) {
                int s = sum(matrix, i, j, k);
                System.out.println(s);
            }
        }
    }

    public static int sum(int[][] matrix, int i, int j, int k) {
        int total = 0;
        int start = j, end = j;
        for (int row = i - (k - 1); row <= i + (k - 1); row++) {
            for (int col = start; col <= end; col++) {
                total += matrix[row][col];
            }
            if (row < i) {
                start--;
                end++;
            } else {
                start++;
                end--;
            }
        }
        return total;
    }

}
