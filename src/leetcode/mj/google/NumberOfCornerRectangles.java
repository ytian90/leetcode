package leetcode.mj.google;

/**
 * 12. lc 750
 */
public class NumberOfCornerRectangles {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int p = i - 1; p >= 0; p--) {
                        if (grid[p][j] == 1) {
                            for (int q = j - 1; q >= 0; q--) {
                                if (grid[i][q] == 1) {
                                    if (grid[p][q] == 1) {
                                        res++;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        return res;
    }

    public int countCornerRectangles2(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int counter = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) {
                        counter++;
                    }
                }
                if (counter > 0) {
                    res += counter * (counter - 1) / 2;
                }
            }
        }
        return res;
    }
}
