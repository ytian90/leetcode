package mj.houzz;

import java.util.*;

/**
 * 一道题，给列车时刻表
 * A B 10:00 11:00 -> 1 2 : 600 - 660
 * B C 11:20 12:15 -> 2 3 : 680 - 735
 * A C 10:15 12:50 -> 1 3 : 615 - 770
 *
 * 给初始点A和目的地C，求最早能到C的时间。要是多条同时到，求最晚出发时间和最早到的那条线。
 *
 * https://www.1point3acres.com/bbs/thread-452158-1-1.html
 */
public class TrainDijsktra {

    // times[i] = (start, end, startTime, endTime)

    public int find(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] e : times) {
            if (!graph.containsKey(e[0])) {
                graph.put(e[0], new ArrayList<>());
            }
            graph.get(e[0]).add(new int[]{e[1], e[2], e[3]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, K});
        Map<Integer, Integer> dist = new HashMap<>();
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int target = curr[0], startTime = curr[1], endTime = curr[2];
            if (dist.containsKey(target)) continue;
//            dist.put(target, )
        }
        return 0;
    }

}
