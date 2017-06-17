package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Insert Interval
 * @author yutian
 * @since Aug 30, 2015
 */
public class InsertInterval {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		// if intervals is not sorted.
//		Collections.sort(intervals, new Comparator<Interval>(){
//			public int compare(Interval a, Interval b) {
//				return a.start - b.start;
//			}
//		});
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
		
	}
}
