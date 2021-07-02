package company.uuba;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LC 934. Shortest Bridge
 *
 * In a given 2D binary array grid, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 *
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 *
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 *
 * Example 1:
 *
 * Input: grid = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 *
 * Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 */
public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        if (grid == null || grid.length < 2 || grid[0].length < 2) {
            return 0;
        }
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 2) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return res;
                    }
                    q.add(new int[]{x, y});
                    grid[x][y] = 2;
                }
            }
            res++;
        }

        return -1;
    }

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        q.add(new int[]{i, j});
        for (int[] d : dirs) {
            dfs(grid, i + d[0], j + d[1], q);
        }
    }

    private int diff(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]) - 1;
    }
}
