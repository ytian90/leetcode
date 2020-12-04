package leetcode.mj.google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CampusBike {
    // Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.
    public static int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else if (a[1] != b[1]) {
                return a[1] - b[1];
            } else {
                return a[2] - b[2];
            }
        });
        for (int i = 0; i < workers.length; i++) {
            int[] w = workers[i];
            for (int j = 0; j < bikes.length; j++) {
                int[] b = bikes[j];
                int distance = Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
                pq.add(new int[]{distance, i, j});
            }
        }
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Set<Integer> bikeAssigned = new HashSet<>();
        while (bikeAssigned.size() < n) {
            int[] curr = pq.poll();
            if (res[curr[1]] == -1 && !bikeAssigned.contains(curr[2])) {
                res[curr[1]] = curr[2];
                bikeAssigned.add(curr[2]);
            }
        }
        return res;
    }

    // Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.
    public static int assignBikes2(int[][] workers, int[][] bikes) {
        int[] min = new int[]{Integer.MAX_VALUE};
        helper(0, 0, workers, bikes, new boolean[bikes.length], min);
        return min[0];
    }

    private static void helper(int pos, int distance, int[][] workers, int[][] bikes, boolean[] visited, int[] min) {
        if (pos == workers.length) {
            min[0] = Math.min(min[0], distance);
            return;
        }
        if (distance > min[0]) {
            return;
        }
        for (int i = 0; i < bikes.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            helper(pos + 1, distance + dist(workers[pos], bikes[i]), workers, bikes, visited, min);
            visited[i] = false;
        }
    }

    private static int dist(int[] w, int[] b) {
        return Math.abs(w[0] - b[0]) + Math.abs(w[1] - b[1]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(assignBikes(new int[][]{
                {0, 0},
                {1, 1},
                {2, 0}
        }, new int[][]{
                {1, 0},
                {2, 2},
                {2, 1}
        })));

        System.out.println(Arrays.toString(assignBikes(new int[][]{
                {0, 0},
                {2, 1}
        }, new int[][]{
                {1, 2},
                {3, 3}
        })));

        System.out.println(assignBikes2(new int[][]{
                {0, 0},
                {1, 1},
                {2, 0}
        }, new int[][]{
                {1, 0},
                {2, 2},
                {2, 1}
        }));

        System.out.println(assignBikes2(new int[][]{
                {0, 0},
                {2, 1}
        }, new int[][]{
                {1, 2},
                {3, 3}
        }));
    }
}
