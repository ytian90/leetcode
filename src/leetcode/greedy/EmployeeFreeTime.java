package leetcode.greedy;

import java.util.*;

/**
 * 759. Employee Free Time
 */
public class EmployeeFreeTime {

    public static List<Interval> employeeFreeTime2(List<List<Interval>> schedule) {

        List<Interval> free = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (List<Interval> list : schedule) {
            pq.addAll(list);
        }
        Interval curr = pq.poll();
        while (!pq.isEmpty()) {
            Interval next = pq.poll();
            if (curr.end < next.start) {
                free.add(new Interval(curr.end, next.start));
                curr = next;
            } else {
                curr.start = Math.min(curr.start, next.start);
                curr.end = Math.max(curr.end, next.end);
            }
        }

        return free;
    }

    public static void main(String[] args) {
        List<List<Interval>> t = new ArrayList<>();
        List<Interval> t1 = new ArrayList<>();
        t1.add(new Interval(1, 2));
        t1.add(new Interval(5, 6));
        t.add(t1);
        List<Interval> t2 = new ArrayList<>();
        t2.add(new Interval(1, 3));
        t.add(t2);
        List<Interval> t3 = new ArrayList<>();
        t3.add(new Interval(4, 10));
        t.add(t3);
        System.out.println(employeeFreeTime(t));
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> work = new ArrayList<>();
        List<Interval> free = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (List<Interval> list : schedule) {
            pq.addAll(list);
        }
        Interval curr = pq.poll();
        while (!pq.isEmpty()) {
            Interval next = pq.poll();
            if (curr.end < next.start) {
                work.add(curr);
                curr = next;
            } else {
                curr.start = Math.min(curr.start, next.start);
                curr.end = Math.max(curr.end, next.end);
            }
        }
        work.add(curr);
        for (int i = 1; i < work.size(); i++) {
            free.add(new Interval(work.get(i - 1).end, work.get(i).start));
        }
        return free;
    }

    static class Interval {
        public int start;
        public int end;

        public Interval() {}

        public Interval(int _start,int _end) {
            start = _start;
            end = _end;
        }

        @Override
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    };
    public static List<Interval> employeeFreeTime3(List<List<Interval>> schedule) {
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

}
