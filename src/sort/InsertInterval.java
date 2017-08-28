package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 57. Insert Interval
 * @author yutian
 * @since Aug 30, 2015
 */
public class InsertInterval {
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		// if intervals is not sorted.
		Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> res = new ArrayList<>();
        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.end < newInterval.start) {
                res.add(curr);
            } else if (curr.start > newInterval.end) {
                res.add(newInterval);
                newInterval = curr;
            } else {
                newInterval.start = Math.min(newInterval.start, curr.start);
                newInterval.end = Math.max(newInterval.end, curr.end);
            }
        }
        res.add(newInterval);
        return res;
	}
	
	public static void main(String[] args) {
		Interval a = new Interval(1, 3);
		Interval b = new Interval(6, 9);
		Interval c = new Interval(2, 5);
		List<Interval> t = new ArrayList<>(Arrays.asList(a, b));
		for (Interval i : insert(t, c)) {
			System.out.println(i.start + " " + i.end);
		}
		
		System.out.println();
		
		Interval aa = new Interval(1, 2);
		Interval bb = new Interval(3, 5);
		Interval cc = new Interval(6, 7);
		Interval dd = new Interval(8, 10);
		Interval ee = new Interval(12, 16);
		Interval ff = new Interval(4, 9);
		List<Interval> tt = new ArrayList<>(Arrays.asList(aa, bb, cc, dd, ee));
		for (Interval i : insert(tt, ff)) {
			System.out.println(i.start + " " + i.end);
		}
	}
	
	public static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}
