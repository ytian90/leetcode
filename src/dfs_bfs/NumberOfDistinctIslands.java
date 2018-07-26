package dfs_bfs;

import java.util.*;

/**
 * 694. Number of Distinct Islands
 */
public class NumberOfDistinctIslands {
    public static int numDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Set<List<List<Integer>>> islands = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                List<List<Integer>> island = new ArrayList<>();
                if (dfs(i, j, i, j, grid, island)) {
                    islands.add(island);
                }
            }
        }
        return islands.size();
    }

    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static boolean dfs(int i0, int j0, int i, int j, int[][] grid, List<List<Integer>> island) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] <= 0)
            return false;
        island.add(Arrays.asList(i - i0, j - j0));
        grid[i][j] *= -1;
        for (int[] d : dirs) {
            dfs(i0, j0, i + d[0], j + d[1], grid, island);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(numDistinctIslands(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        }));
    }
}
