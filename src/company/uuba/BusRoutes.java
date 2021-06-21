package company.uuba;

import java.util.*;

/**
 * LC 815. Bus Routes
 *
 * You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
 *
 * For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target. You can travel between bus stops by buses only.
 *
 * Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 *
 * Example 1:
 *
 * Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
 * Output: 2
 * Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 * Example 2:
 *
 * Input: routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
 * Output: -1
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (routes == null || routes.length == 0 || routes[0].length == 0) {
            return 0;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>(); // key: stop, value: routes
        int n = routes.length;
        for (int i = 0; i < n; i++) {
            for (int j : routes[i]) {
                if (!map.containsKey(j)) {
                    map.put(j, new HashSet<>());
                }
                map.get(j).add(i);
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{source, 0});
        Set<Integer> seenStop = new HashSet<>();
        seenStop.add(source);
        boolean[] seenRoutes = new boolean[n];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int stop = curr[0], bus = curr[1];
            if (stop == target) {
                return bus;
            }
            for (int i : map.get(stop)) {
                if (seenRoutes[i]) continue;
                for (int j : routes[i]) {
                    if (seenStop.contains(j)) continue;
                    seenStop.add(j);
                    q.add(new int[]{j, bus + 1});
                }
                seenRoutes[i] = true;
            }
        }
        return -1;
    }
}
