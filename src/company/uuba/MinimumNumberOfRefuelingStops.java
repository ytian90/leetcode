package company.uuba;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LC 871. Minimum Number of Refueling Stops
 * A car travels from a starting position to a destination which is target miles east of the starting position.
 *
 * There are gas stations along the way. The gas stations are represented as an array stations where stations[i] = [positioni, fueli] indicates that the ith gas station is positioni miles east of the starting position and has fueli liters of gas.
 *
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it. It uses one liter of gas per one mile that it drives. When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
 *
 * Return the minimum number of refueling stops the car must make in order to reach its destination. If it cannot reach the destination, return -1.
 *
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there. If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 *
 * Example 1:
 *
 * Input: target = 1, startFuel = 1, stations = []
 * Output: 0
 * Explanation: We can reach the target without refueling.
 * Example 2:
 *
 * Input: target = 100, startFuel = 1, stations = [[10,100]]
 * Output: -1
 * Explanation: We can not reach the target (or even the first gas station).
 * Example 3:
 *
 * Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * Output: 2
 * Explanation: We start with 10 liters of fuel.
 * We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
 * Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
 * and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
 * We made 2 refueling stops along the way, so we return 2.
 */
public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0, res = 0;
        for (res = 0; startFuel < target; res++) {
            while (i < stations.length && startFuel >= stations[i][0]) {
                pq.offer(stations[i][1]);
                i++;
            }
            if (pq.isEmpty()) {
                return -1;
            }
            startFuel += pq.poll();
        }
        return res;
    }
    /**
     * Time: O(N * logN)
     * Space: O(N)
     */

    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int t = i; t >= 0 && dp[t] >= stations[i][0]; t--) {
                dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Time: O(N * N)
     * Space: O(N)
     */
}
