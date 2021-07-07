package company.uuba.mj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Similar to LC 317.
 * 给定一个二维数组当做地图，数字1代表障碍，数字0代表路，数字-1代表目标点，求出每个数字0对应的点到目标点的最短路线。就一个bfs就行了。
 */
public class ShortestDistanceFromTarget {
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int[][] shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return grid;
        }
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == -1) {
                    bfs(grid, i, j);
                }
            }
        }
        return grid;
    }

    private static void bfs(int[][] grid, int a, int b) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    int x = curr[0] + d[0], y = curr[1] + d[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || grid[x][y] != 0) {
                        continue;
                    }
                    visited[x][y] = true;
                    grid[x][y] = depth;
                    q.add(new int[]{x, y});
                }
            }
            depth++;
        }
    }

    public static void main(String[] args) {
        for (int[] a : shortestDistance(new int[][]{
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, -1}
        })) {
            System.out.println(Arrays.toString(a));
        }
    }
}
