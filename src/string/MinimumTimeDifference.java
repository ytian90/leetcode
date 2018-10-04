package string;

import java.util.*;

/**
 * 539. Minimum Time Difference
 */
public class MinimumTimeDifference {

    public static int findMinDifference(List<String> timePoints) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String s : timePoints) {
            int h = Integer.valueOf(s.substring(0, 2));
            int m = Integer.valueOf(s.substring(3));
            pq.offer(60 * h + m);
        }
        if (pq.size() < 2) return 0;
        int res = Integer.MAX_VALUE, first = pq.poll();
        int curr = first;
        while (!pq.isEmpty()) {
            int next = pq.poll();
            res = Math.min(res, next - curr);
            curr = next;
        }
        return Math.min(res, 24 * 60 - curr + first);
    }

    public static int findMinDifferencc(List<String> timePoints) {
        int res = Integer.MAX_VALUE;
        Collections.sort(timePoints);
        int n = timePoints.size();
        for (int i = 0; i < n; i++) {
            String[] a = timePoints.get(i).split(":");
            String[] b = timePoints.get((i + 1) % n).split(":");
            int ah = Integer.valueOf(a[0]), am = Integer.valueOf(a[1]);
            int bh = Integer.valueOf(b[0]), bm = Integer.valueOf(b[1]);
            int tmp = helper(ah, bh, am, bm);
            res = Math.min(res, tmp);
        }
        return res;
    }

    public static int helper(int ah, int bh, int am, int bm) {
        int res = Math.abs((bh - ah) * 60 + bm - am);
        return Math.min(res, 24 * 60 - res);
    }

    public static void main(String[] args) {
        System.out.println(findMinDifferencc(new ArrayList<>(Arrays.asList("23:59", "00:00"))));
    }

    public static int findMinDifferencee(List<String> timePoints) {
        boolean[] visited = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] s = time.split(":");
            int h = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            if (visited[60 * h + m]) return 0;
            visited[60 * h + m] = true;
        }
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (visited[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        min = Math.min(min, 24 * 60 - last + first);
        return min;
    }

}
