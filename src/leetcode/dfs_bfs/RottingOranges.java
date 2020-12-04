package leetcode.dfs_bfs;

import java.util.*;

/**
 * 994. Rotting Oranges
 */
public class RottingOranges {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int orangeRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        int[] count = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count[1]++;
                }
            }
        }
        if (count[1] == 0) {
            return 0;
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    int x = d[0] + curr[0];
                    int y = d[1] + curr[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
                        continue;
                    }
                    q.add(new int[]{x, y});
                    count[1]--;
                    grid[x][y] = 2;
                }
            }
            count[0]++;
        }
        return count[1] == 0 ? count[0] - 1 : -1;
    }

    public static void main(String[] args) {
        System.out.println(orangeRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        }));

        System.out.println(orangeRotting(new int[][]{
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        }));

        System.out.println(orangeRotting(new int[][]{
                {0, 2}
        }));
    }

}
