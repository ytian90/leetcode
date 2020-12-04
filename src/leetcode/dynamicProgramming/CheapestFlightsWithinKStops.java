package leetcode.dynamicProgramming;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops
 */
public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] f : flights) {
            map.putIfAbsent(f[0], new HashMap<>());
            map.get(f[0]).put(f[1], f[2]);
        }
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        pq.add(new int[]{0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int price = curr[0];
            int city = curr[1];
            int stop = curr[2];
            if (city == dst) {
                return price;
            }
            if (stop > 0 && map.containsKey(city)) {
                Map<Integer, Integer> adj = map.get(city);
                for (int next : adj.keySet()) {
                    pq.add(new int[]{price + adj.get(next), next, stop - 1});
                }
            }
        }
        return -1;
    }

    public static int findCheapestPrices(int n, int[][] flights, int src, int dst, int K) {
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 0; i <= K; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] flight : flights) {
                int curr = flight[0], next = flight[1], price = flight[2];
                if (prices[curr] == Integer.MAX_VALUE) {
                    continue;
                }
                temp[next] = Math.min(temp[next], prices[curr] + price);
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(findCheapestPrices(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
        System.out.println(findCheapestPrices(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
    }
}
