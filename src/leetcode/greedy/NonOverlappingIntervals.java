package leetcode.greedy;

import java.util.Arrays;

/**
 * 435. Non-overlapping Intervals
 * @author yutian
 *
 */
public class NonOverlappingIntervals {
	
	public static int eraseOverlapIntervals(Interval[] intervals) {
		Arrays.sort(intervals, (a, b) -> (a.end != b.end) ? 
				(a.end - b.end) : (b.start - a.start)); // end incr, start decr
		int end = Integer.MIN_VALUE;
		int count = 0;
		for (Interval interval : intervals) {
			if (interval.start >= end) end = interval.end;
			else count++;
		}
		return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(2, 3);
		Interval i3 = new Interval(3, 4);
		Interval i4 = new Interval(1, 3);
		
		Interval[] t1 = new Interval[4];
		t1[0] = i1; t1[1] = i2; t1[2] = i3; t1[3] = i4;
		System.out.println(eraseOverlapIntervals(t1));
		
		Interval[] t2 = new Interval[3];
		t2[0] = i1; t2[1] = i1; t2[2] = i1;
		System.out.println(eraseOverlapIntervals(t2));
		
		Interval[] t3 = new Interval[2];
		t3[0] = i1; t3[1] = i2;
		System.out.print(eraseOverlapIntervals(t3));
	}
	
	public static class Interval {
		public int start;
		public int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	} 

}
