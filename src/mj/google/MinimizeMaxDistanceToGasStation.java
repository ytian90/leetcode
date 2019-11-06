package mj.google;

import java.util.PriorityQueue;

/**
 * 774. Minimize Max Distance to Gas Station
 */
public class MinimizeMaxDistanceToGasStation {
    public static double minmaxGasDist(int[] stations, int K) {
        int count = 0, n = stations.length;
        double left = 0, right = stations[n - 1] - stations[0], mid = 0;
        while (left + 1e-6 < right) {
            mid = left + (right - left) / 2;
            count = 0;
            for (int i = 0; i < n - 1; i++) {
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }
            if (count > K) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
        System.out.println(minmaxGasDist(new int[]{10,19,25,27,56,63,70,87,96,97},3));
    }

    // TLE
    public static double minmaxGasDist2(int[] stations, int K) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> (a[0] / a[1] < b[0] / b[1]) ? 1 : -1);
        for (int i = 1; i < stations.length; i++) {
            pq.add(new double[]{stations[i] - stations[i - 1], 1.0});
        }
        while (K > 0) {
            double[] curr = pq.poll();
            curr[1]++;
            pq.add(curr);
            K--;
        }
        double[] res = pq.poll();
        return res[0] / res[1];
    }
}
