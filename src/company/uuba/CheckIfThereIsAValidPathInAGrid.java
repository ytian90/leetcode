package company.uuba;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 1391. Check if There is a Valid Path in a Grid
 *
 * Given a m x n grid. Each cell of the grid represents a street. The street of grid[i][j] can be:
 * 1 which means a street connecting the left cell and the right cell.
 * 2 which means a street connecting the upper cell and the lower cell.
 * 3 which means a street connecting the left cell and the lower cell.
 * 4 which means a street connecting the right cell and the lower cell.
 * 5 which means a street connecting the left cell and the upper cell.
 * 6 which means a street connecting the right cell and the upper cell.
 *
 *
 * You will initially start at the street of the upper-left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1). The path should only follow the streets.
 *
 * Notice that you are not allowed to change any street.
 *
 * Return true if there is a valid path in the grid or false otherwise.
 *
 * Example 1:
 *
 * Input: grid = [[2,4,3],[6,5,2]]
 * Output: true
 * Explanation: As shown you can start at cell (0, 0) and visit all the cells of the grid to reach (m - 1, n - 1).
 * Example 2:
 *
 * Input: grid = [[1,2,1],[1,2,1]]
 * Output: false
 * Explanation: As shown you the street at cell (0, 0) is not connected with any street of any other cell and you will get stuck at cell (0, 0)
 * Example 3:
 *
 * Input: grid = [[1,1,2]]
 * Output: false
 * Explanation: You will get stuck at cell (0, 1) and you cannot reach cell (0, 2).
 * Example 4:
 *
 * Input: grid = [[1,1,1,1,1,1,3]]
 * Output: true
 * Example 5:
 *
 * Input: grid = [[2],[2],[2],[2],[2],[2],[6]]
 * Output: true
 */
public class CheckIfThereIsAValidPathInAGrid {
    int[][][] dirs = {{}, {{0, 1}, {0, -1}}, {{1, 0}, {-1, 0}}, {{0, -1}, {1, 0}},
            {{0, 1}, {1, 0}}, {{0, -1}, {-1, 0}}, {{0, 1}, {-1, 0}}};

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];
            for (int[] d : dirs[grid[i][j]]) {
                int x = i + d[0], y = j + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) {
                    continue;
                }
                for (int[] back : dirs[grid[x][y]]) { // you can go to next cell and check whether you can come back.
                    if (x + back[0] == i && y + back[1] == j) {
                        q.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
        }
        return visited[n - 1][m - 1];
    }

    /**
     * Time: O(N * M)
     * Space: O(N * M)
     */
}
