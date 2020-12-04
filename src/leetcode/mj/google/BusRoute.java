package leetcode.mj.google;

import java.util.*;

/**
 * 13. LC815
 */
public class BusRoute {
    public static int numBusesToDestination(int[][] routes, int S, int T) {
        if (routes.length == 0 || S < 0 || T < 0) {
            return -1;
        }
        if (S == T) {
            return 0;
        }
        int res = 1, curr = S;
        List<Set<Integer>> buses = new ArrayList<>();
        boolean[] visited = new boolean[routes.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(S);
        for (int[] route : routes) {
            Set<Integer> set = new HashSet<>();
            for (int r : route) {
                set.add(r);
            }
            buses.add(set);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                curr = q.poll();
                for (int j = 0; j < buses.size(); j++) {
                    if (visited[j] || !buses.get(j).contains(curr)) {
                        continue;
                    }
                    visited[j] = true;
                    for (int n : buses.get(j)) {
                        if (n == curr) continue;
                        if (n == T) return res;
                        q.add(n);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
        System.out.println(numBusesToDestination(new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}},15, 12));
    }
}
