package company.uuba.mj;

import java.util.*;

/**
 * LC 787. Cheapest Flights Within K Stops (Time)
 * https://www.1point3acres.com/bbs/thread-752430-1-1.html
 *
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 *
 * Example 1:
 *
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation: The graph is shown.
 * The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 * Example 2:
 *
 *
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation: The graph is shown.
 * The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.
 */
public class CheapestFlightsWithinKStops {
    static class Pair {
        int city, cost;
        public Pair(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    static class City {
        int city, time, cost;
        public City(int city, int time, int cost) {
            this.city = city;
            this.time = time;
            this.cost = cost;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        for (int[] flight : flights) {
            int start = flight[0], end = flight[1], cost = flight[2];
            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(new Pair(end, cost));
        }
        PriorityQueue<City> pq = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
        pq.add(new City(src, 0, 0));
        HashMap<Integer, Integer> visited = new HashMap<>();
        while (!pq.isEmpty()) {
            City curr = pq.poll();
            if (visited.containsKey(curr.city) && visited.get(curr.city) <= curr.time) {
                continue;
            }
            visited.put(curr.city, curr.time);
            if (curr.city == dst) {
                return curr.cost;
            }
            if (curr.time > k || !map.containsKey(curr.city)) {
                continue;
            }
            for (Pair next : map.get(curr.city)) {
                pq.offer(new City(next.city, curr.time + 1, curr.cost + next.cost));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(5, new int[][]{
                {4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10},
                {3, 1, 1}, {1, 4, 3}
        }, 2, 1, 1));
    }
}
