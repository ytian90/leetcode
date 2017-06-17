package sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 56. Merge Intervals
 * @author yutian
 * @since Aug 30, 2015
 */
public class MergeIntervals {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1) return intervals;
		
//		// Sort by ascending starting point using an anonymous Comparator
//		Collections.sort(intervals, new Comparator<Interval>() {
//			@Override
//			public int compare(Interval i1, Interval i2) {
//				return Integer.compare(i1.start, i2.start);
//			}
//		});
		
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		
		List<Interval> result = new LinkedList<Interval>();
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval i: intervals) {
            if (end >= i.start) { // Overlapping intervals, move the end if needed
                end = Math.max(end, i.end);
            } else { // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
		
		// Add the last interval
		result.add(new Interval(start, end));
		return result;
	}
}
