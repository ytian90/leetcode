package leetcode.greedy;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals
 */
public class Non_OverlappingIntervals {

    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        int start = intervals[0].start, end = intervals[0].end, res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i].start) {
                res++;
                end = Math.min(end, intervals[i].end);
            } else {
                start = intervals[i].start;
                end = intervals[i].end;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Interval[] t = new Interval[4];
        t[0] = new Interval(1, 100);
        t[1] = new Interval(11, 22);
        t[2] = new Interval(1, 11);
        t[3] = new Interval(2, 12);

        System.out.println(eraseOverlapIntervals(t));
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
