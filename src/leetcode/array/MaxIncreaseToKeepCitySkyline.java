package leetcode.array;

/**
 * 807. Max Increase to Keep City Skyline
 */
public class MaxIncreaseToKeepCitySkyline {
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int res = 0;
        int n = grid.length, m = grid[0].length;
        int[] r = new int[n], c = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                r[i] = Math.max(r[i], grid[i][j]);
                c[j] = Math.max(c[j], grid[i][j]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += Math.min(r[i], c[j]) - grid[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        };

        System.out.println(maxIncreaseKeepingSkyline(grid));
    }
}
