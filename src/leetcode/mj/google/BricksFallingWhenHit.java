package leetcode.mj.google;

/**
 * lc803
 */
public class BricksFallingWhenHit {
    private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] res = new int[hits.length];
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]]--;
        }
        for (int j = 0; j < grid[0].length; j++) {
            dfs(grid, 0, j);
        }
        for (int k = hits.length - 1; k >= 0; k--) {
            int[] h = hits[k];
            int i = h[0], j = h[1];
            grid[i][j]++;
            if (grid[i][j] == 1 && isConnected(grid, i, j)) {
                res[k] = dfs(grid, i, j) - 1;
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return 1 + dfs(grid, i + 1, j) + dfs(grid, i - 1, j) + dfs(grid, i, j + 1) + dfs(grid, i, j - 1);
    }

    public boolean isConnected(int[][] g, int i, int j) {
        if (i == 0) return true;
        for (int[] d : dirs) {
            int r = i + d[0], c = j + d[1];
            if (r >= 0 && r < g.length && c >= 0 && c < g[0].length && g[r][c] == 2) {
                return true;
            }
        }
        return false;
    }
}
