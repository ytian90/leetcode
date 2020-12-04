package leetcode.mj.google;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 857. Minimum Cost to Hire K Workers
 */
public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int len = quality.length;
        Worker[] workers = new Worker[len];
        for (int i = 0; i < len; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a.ratio, b.ratio));
        Queue<Worker> pq = new PriorityQueue<>((a, b) -> b.quality - a.quality);
        int sum = 0;
        double min = Double.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            if (pq.size() >= K) {
                Worker temp = pq.poll();
                sum -= temp.quality;
            }
            pq.offer(workers[i]);
            sum += workers[i].quality;
            if (pq.size() == K) {
                min = Math.min(min, sum * workers[i].ratio);
            }
        }
        return min;
    }

    private static class Worker {
        int quality;
        int wage;
        double ratio;
        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (wage + 0.0) / quality;
        }
    }
}
