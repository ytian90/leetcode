package leetcode.greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 1057. Campus Bikes
 */
public class CampusBikes {

    public static int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
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
    }
}
