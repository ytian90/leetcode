package leetcode.sort;

import java.util.*;

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
		
		// Add the last intervalzz
		res.add(new Interval(start, end));
		return res;
	}

	// int[][] interface
	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return new int[][]{};
		List<int[]> res = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		int start = intervals[0][0], end = intervals[0][1];
		for (int[] i : intervals) {
			if (end >= i[0]) {
				end = Math.max(end, i[1]);
			} else {
				res.add(new int[]{start, end});
				start = i[0];
				end = i[1];
			}
		}
		res.add(new int[]{start, end});
		int[][] ans = new int[res.size()][2];
		for (int i = 0; i < ans.length; i++) {
			ans[i] = res.get(i);
		}
		return ans;
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
