package leetcode.util;

import java.util.*;

public class temp {
    static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int shortestPathAllKeys(String[] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int n = grid.length, m = grid[0].length();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(max, c - 'a' + 1);
                }
            }
        }
        Set<Character> visitedKeys = new HashSet<>();
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int i = curr[0], j = curr[1];
                char c = grid[i].charAt(j);
                if (c >= 'a' && c <= 'f') {
                    visitedKeys.add(c);
                }
                if (visitedKeys.size() == max) {
                    return step;
                }
                for (int[] d : dirs) {
                    int x = i + d[0], y = j + d[1];
                    if (x < 0 || x >= n || y < 0 || y >= m) {
                        continue;
                    }
                    char nc = grid[x].charAt(y);
                    if (visited[x][y] || nc == '#' || (nc >= 'A' && nc <= 'F' && !visitedKeys.contains((char) (nc - 'A' + 'a')))) {
                        continue;
                    }
                    if (nc >= 'a' && nc <= 'f') {
                        visitedKeys.add(nc);
                    }
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(shortestPathAllKeys(new String[]{"@.a.#","###.#","b.A.B"}));
        System.out.println(shortestPathAllKeys(new String[]{"@..aA","..B#.","....b"}));

    }
}
