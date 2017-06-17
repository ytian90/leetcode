package binarySearch;

import java.util.TreeMap;

/**
 * 436. Find Right Interval
 * @author yutian
 *
 */
public class FindRightInterval {
	
	public static int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
        	map.put(intervals[i].start, i);
        }
        for (int i = 0; i < intervals.length; i++) {
        	Integer key = map.ceilingKey(intervals[i].end);
        	res[i] = key != null ? map.get(key) : -1;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(3, 4);
		Interval i3 = new Interval(2, 3);
		Interval i4 = new Interval(1, 4);
		
		Interval[] t1 = new Interval[1];
		t1[0] = i1;
		for (Integer i : findRightInterval(t1)){
			System.out.print(i + " ");
		}
		System.out.println();
		
		Interval[] t2 = new Interval[3];
		t2[0] = i2; t2[1] = i3; t2[2] = i1;
		for (Integer i : findRightInterval(t2)){
			System.out.print(i + " ");
		}
		System.out.println();
		
		Interval[] t3 = new Interval[3];
		t3[0] = i4; t3[1] = i3; t3[2] = i2;
		for (Integer i : findRightInterval(t3)){
			System.out.print(i + " ");
		}
		
	}
	
	public static class Interval {
		public int start;
		public int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	} 

}
