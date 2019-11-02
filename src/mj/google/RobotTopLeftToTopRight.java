package mj.google;

import java.util.*;

/**
 * lc62 and lc63
 */
public class RobotTopLeftToTopRight {

    public int uniquePaths_lc62(int m, int n) {
        int min = Math.min(m, n), max = Math.max(m, n);
        int[] d = new int[min];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < min; j++) {
                if (i == 0 && j == 0) {
                    d[j] = 1;
                } else {
                    d[j] = ((i > 0) ? d[j] : 0) + ((j > 0) ? d[j - 1]: 0);
                }
            }
        }
        return d[min - 1];
    }

    // lc 63
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        if (obstacleGrid[0][0] != 1) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < m; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // lc 63 1D dp
    public int uniquePathsWithObstacles_1D(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] dp = new int[m];
        int val;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                val = obstacleGrid[i][j];
                if (i == 0 && j == 0) {
                    dp[j] = (val == 1) ? 0 : 1;
                } else {
                    dp[j] = (val == 1) ? 0 : ((i > 0) ? dp[j] : 0) + ((j > 0) ? dp[j - 1] : 0);
                }
            }
        }
        return dp[m - 1];
    }

    // follow up 1 Space O(n)
    public static int uniquePaths(int rows, int cols) {
        int[] dp = new int[rows];
        int[] temp = new int[rows];
        dp[0] = 1;
        for (int j = 1; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                int val1 = (i > 0) ? dp[i - 1] : 0;
                int val2 = dp[i];
                int val3 = (i < rows - 1) ? dp[i + 1] : 0;
                temp[i] = val1 + val2 + val3;
            }
            System.arraycopy(temp, 0, dp, 0, temp.length);
        }
        return dp[0];
    }

    // Given 3 points, check if those are reachable
    public static boolean canReach(int[][] points) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0, 0});
        for (int[] point : points) {
            list.add(point);
        }
        Collections.sort(list, (a, b) -> a[1] - b[1]);
        for (int i = 1; i < list.size(); i++) {
            int[] curr = list.get(i);
            int[] prev = list.get(i - 1);
            // same points continue
            if (curr[0] == prev[0] && curr[1] == prev[1]) {
                continue;
            }
            // two points on same Y-axis, can't make it
            if (curr[1] == prev[1]) {
                return false;
            }
            int len = curr[1] - prev[1];
            int upper = prev[0] - len;
            int lower = prev[0] + len;
            if (curr[0] < upper || curr[0] > lower) {
                return false;
            }
        }
        return true;
    }

    // Given 3 points, return number of paths pass these 3 points
    public static int countAllUniquePaths(int rows, int cols, int[][] points) {
        int[] dp = new int[rows];
        int[] temp = new int[rows];
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] point : points) {
            if (map.containsKey(point[1])) {
                return 0;
            }
            map.put(point[1], point[0]);
        }
        int res = 0;
        dp[0] = 1;
        for (int j = 1; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                int val1 = (i > 0) ? dp[i - 1] : 0;
                int val2 = dp[i];
                int val3 = (i < rows - 1) ? dp[i + 1] : 0;
                temp[i] = val1 + val2 + val3;
            }
            System.arraycopy(temp, 0, dp, 0, temp.length);
            if (map.containsKey(j)) {
                int row = map.get(j);
                for (int i = 0; i < rows; i++) {
                    if (i == row) {
                        res = dp[i];
                    }
                    dp[i] = 0;
                }
            }
        }
        return res;
    }

    // follow up 4
    // (x == H)，找到能经过给定下界的所有从左上到右上的路径数量 (x >= H)
    public static int uniquePath4(int rows, int cols, int H) {
        return uniquePaths(rows, cols) - uniquePaths(H, cols);
    }

    // follow up 5
    // 起点和终点改成从左上到左下，每一步只能 ↓↘↙，求所有可能的路径数量
    public static int uniquePath5(int rows, int cols) {
        int[] dp = new int[cols];
        int[] temp = new int[cols];
        dp[0] = 1;
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int val1 = (j > 0) ? dp[j - 1] : 0;
                int val2 = dp[j];
                int val3 = (j < cols - 1) ? dp[j + 1] : 0;
                temp[i] = val1 + val2 + val3;
            }
            System.arraycopy(temp, 0, dp, 0, temp.length);
        }
        return dp[0];
    }

    // LC64
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static int minPathSum_1D(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] minSum = new int[m];
        minSum[0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j > 0) {
                    minSum[j] = minSum[j - 1] + grid[i][j];
                } else if (i > 0 && j == 0) {
                    minSum[j] = minSum[j] + grid[i][j];
                } else if (i > 0 && j > 0) {
                    minSum[j] = Math.min(minSum[j - 1], minSum[j]) + grid[i][j];
                }
            }
        }
        return minSum[m - 1];
    }

    public static int collectMaxCoins(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.max(((i > 0) ? dp[i - 1][j] : 0), (j > 0) ? dp[i][j - 1] : 0);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // follow up 2: 现在要求空间复杂度为O（1），dp且重建路径
    public static List<List<Integer>> maxMoney(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (n == 0) {
            return new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            grid[0][j] = -(Math.abs(grid[0][j - 1]) + grid[0][j]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int top = Math.abs(grid[i - 1][j]) + grid[i][j];
                int left = Math.abs(grid[i][j - 1]) + grid[i][j];
                if (top >= left) {
                    grid[i][j] = top;
                } else {
                    grid[i][j] = -left;
                }
            }
        }
        System.out.println("Max sum: " + Math.abs(grid[n - 1][m - 1]));
        List<List<Integer>> res = new ArrayList<>();
        int i = n - 1, j = n - 1;
        while (i > 0 || j > 0) {
            res.add(Arrays.asList(i, j));
            if (grid[i][j] < 0) {
                j--;
            } else {
                i--;
            }
        }
        res.add(Arrays.asList(0, 0));
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(collectMaxCoins(new int[][]{
                {5, 15, 20},
                {10, 15, 5},
                {30, 5, 5}
        }));

        System.out.println(maxMoney(new int[][]{
                {5, 15, 20},
                {10, 15, 5},
                {30, 5, 5}
        }));
    }
}
