package dfs_bfs;

import java.util.*;

/**
 * 675. Cut Off for Golf Event
 */
public class CutOffTreesForGolfEvent {

    static int[] d = {0, 1, 0, -1, 0};

    public static int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0)
            return 0;
        int n = forest.size(), m = forest.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // add (row, col, height) in pq
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        // go through points to add up steps
        int[] start = new int[2];
        int res = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int step = minStep(forest, start, curr, n, m);
            if (step < 0) return -1;
            res += step;
            start[0] = curr[0];
            start[1] = curr[1];
        }
        return res;
    }

    public static int minStep(List<List<Integer>> forest, int[] start, int[] target, int n, int m) {
        int step = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == target[0] && curr[1] == target[1])
                    return step;
                for (int k = 0; k < 4; k++) {
                    int x = curr[0] + d[k], y = curr[1] + d[k + 1];
                    if (x < 0 || x >= n || y < 0 || y >= m
                            || forest.get(x).get(y) == 0 || visited[x][y])
                        continue;
                    q.add(new int[] {x, y});
                    visited[x][y] = true;
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        List<List<Integer>> t = new ArrayList<>();
        t.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        t.add(new ArrayList<>(Arrays.asList(0, 0, 4)));
        t.add(new ArrayList<>(Arrays.asList(7, 6, 5)));
        System.out.println(cutOffTree(t));
        List<List<Integer>> t2 = new ArrayList<>();
        t.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        t.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        t.add(new ArrayList<>(Arrays.asList(7, 6, 5)));
        System.out.println(cutOffTree(t));
    }
}
