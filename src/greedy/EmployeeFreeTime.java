package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 759. Employee Free Time
 */
public class EmployeeFreeTime {
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();
        schedule.forEach(e -> intervals.addAll(e));
        Collections.sort(intervals, ((a, b) -> a.start - b.start));

        Interval curr = intervals.get(0);
        for (Interval i : intervals) {
            if (curr.end < i.start) {
                res.add(new Interval(curr.end, i.start));
                curr = i;
            } else {
                curr.end = (curr.end < i.end) ? i.end : curr.end;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Interval>> t = new ArrayList<>();
        List<Interval> tt = new ArrayList<>();
        tt.add(new Interval(1, 2));
        tt.add(new Interval(5, 6));
        t.add(tt);
        List<Interval> t2 = new ArrayList<>();
        t2.add(new Interval(1, 3));
        t.add(t2);
        List<Interval> t3 = new ArrayList<>();
        t3.add(new Interval(4, 10));
        t.add(t3);
        List<Interval> res = employeeFreeTime(t);
        for (Interval i : res) {
            System.out.println(i.start + "->" + i.end);
        }
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
