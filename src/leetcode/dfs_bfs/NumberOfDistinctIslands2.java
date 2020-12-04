package leetcode.dfs_bfs;

import java.util.*;

/**
 * 711. Number of Distinct Islands 2
 */
public class NumberOfDistinctIslands2 {

    public static int numDistinctIslands2(int[][] grid) {
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    List<int[]> cells = new LinkedList<>();
                    dfs(i, j, grid, cells);
                    islands.add(norm(cells));
                }
            }
        }
        return islands.size();
    }

    private static void dfs(int i, int j, int[][] grid, List<int[]> cells) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] != 1)
            return;
        cells.add(new int[]{i, j});
        grid[i][j] = -1;
        dfs(i + 1, j, grid, cells);
        dfs(i - 1, j, grid, cells);
        dfs(i, j + 1, grid, cells);
        dfs(i, j - 1, grid, cells);
    }

    private static String norm(List<int[]> cells) {
        TreeSet<String> normShapes = new TreeSet<>();
        for (int i = -1; i <= 1; i += 2) {
            for (int j = -1; j <= 1; j += 2) {
                List<int[]> s1 = new ArrayList<>(), s2 = new ArrayList<>();
                for (int[] cell: cells) {
                    int x = cell[0], y = cell[1];
                    s1.add(new int[]{i * x, j * y});
                    s2.add(new int[]{i * y, j * x});
                }
                for (List<int[]> s : Arrays.asList(s1, s2)) {
                    s.sort(new Comparator<int[]>() {
                        @Override
                        public int compare(int[] o1, int[] o2) {
                            return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
                        }
                    });
                    int x = s.get(0)[0], y = s.get(0)[1];
                    StringBuilder sb = new StringBuilder();
                    for (int[] p : s) {
                        sb.append(p[0] - x).append(":").append(p[1] - y).append(":");
                    }
                    normShapes.add(sb.toString());
                }
            }
        }
        return normShapes.first();
    }

    public static void main(String[] args) {
        System.out.println(numDistinctIslands2(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1}
        }));

        System.out.println(numDistinctIslands2(new int[][]{
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        }));
    }
}
