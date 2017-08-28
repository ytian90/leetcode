package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. Merge Intervals
 * @author yutian
 * @since Aug 30, 2015
 */
public class MergeIntervals {
	
	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1) return intervals;
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		
		List<Interval> res = new LinkedList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval i: intervals) {
            if (end >= i.start) { // Overlapping intervals, move the end if needed
                end = Math.max(end, i.end);
            } else { // Disjoint intervals, add the previous one and reset bounds
                res.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
		
		// Add the last interval
		res.add(new Interval(start, end));
		return res;
	}
	
	public static void main(String[] args) {
		Interval a = new Interval(1, 3);
		Interval b = new Interval(2, 6);
		Interval c = new Interval(8, 10);
		Interval d = new Interval(15, 18);
		List<Interval> t = new ArrayList<>(Arrays.asList(a, b, c, d));
		for (Interval i : merge(t)) {
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
