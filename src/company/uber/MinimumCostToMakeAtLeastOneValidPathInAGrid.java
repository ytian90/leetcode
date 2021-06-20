package company.uber;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1368. Minimum Cost to Make at Least One Valid Path in a Grid
 *
 * Given a m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:
 * 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
 * 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
 * 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
 * 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
 * Notice that there could be some invalid signs on the cells of the grid which points outside the grid.
 *
 * You will initially start at the upper left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path doesn't have to be the shortest.
 *
 * You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.
 *
 * Return the minimum cost to make the grid have at least one valid path.
 *
 * Example 1:
 *
 * Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
 * Output: 3
 * Explanation: You will start at point (0, 0).
 * The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
 * The total cost = 3.
 * Example 2:
 *
 * Input: grid = [[1,1,3],[3,2,2],[1,1,4]]
 * Output: 0
 * Explanation: You can follow the path from (0, 0) to (2, 2).
 * Example 3:
 *
 *
 * Input: grid = [[1,2],[4,3]]
 * Output: 1
 * Example 4:
 *
 * Input: grid = [[2,2,2],[2,2,2]]
 * Output: 3
 * Example 5:
 *
 * Input: grid = [[4]]
 * Output: 0
 */
public class MinimumCostToMakeAtLeastOneValidPathInAGrid {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int n = grid.length, m = grid[0].length, cost = 0;
        Integer[][] memo = new Integer[n][m];
        Queue<int[]> q = new LinkedList<>();
        dfs(grid, 0, 0, q, memo, cost);
        while (!q.isEmpty()) {
            cost++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    dfs(grid, curr[0] + d[0], curr[1] + d[1], q, memo, cost);
                }
            }
        }
        return memo[n - 1][m - 1];
    }

    private void dfs(int[][] grid, int x, int y, Queue<int[]> q, Integer[][] memo, int cost) {
        int n = grid.length, m = grid[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || memo[x][y] != null) {
            return;
        }
        memo[x][y] = cost;
        q.add(new int[]{x, y});
        int[] d = dirs[grid[x][y] - 1];
        dfs(grid, x + d[0], y + d[1], q, memo, cost);
    }

    /**
     * Time: O(N * M)
     * Space: O(N * M)
     */
}
