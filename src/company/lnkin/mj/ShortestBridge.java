package company.lnkin.mj;

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
    public int shortestBridge(int[][] A) {
        if (A == null || A.length < 2 || A[0].length < 2) {
            return 0;
        }
        int n = A.length, m = A[0].length;
        Queue<int[]> id = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, id);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        int res = 0;
        while (!id.isEmpty()) {
            int size = id.size();
            for (int i = 0; i < size; i++) {
                int[] curr = id.poll();
                for (int[] d : dirs) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || A[x][y] == 2) {
                        continue;
                    }
                    if (A[x][y] == 1) {
                        return res;
                    }
                    id.offer(new int[]{x, y});
                    A[x][y] = 2;
                }
            }
            if (!id.isEmpty()) {
                res++;
            }
        }
        return -1;
    }

    private int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(int[][] A, int i, int j, Queue<int[]> list) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] != 1) {
            return;
        }
        A[i][j] = 2;
        list.add(new int[]{i, j});
        for (int[] d : dirs) {
            dfs(A, i + d[0], j + d[1], list);
        }
    }

    private int diff(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]) - 1;
    }

}
