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

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> list = new ArrayList<>();
		int start = newInterval[0], end = newInterval[1];
		for (int[] interval : intervals) {
			if (interval[1] < start) {
				list.add(interval);
			} else if (interval[0] > end) {
				list.add(new int[]{start, end});
				start = interval[0];
				end = interval[1];
			} else {
				start = Math.min(start, interval[0]);
				end = Math.max(end, interval[1]);
			}
		}
		list.add(new int[]{start, end});
		int[][] res = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	public static void main(String[] args) {
		for (int[] a : insert(new int[][]{
				{1, 3},
				{6, 9}
		}, new int[]{2, 5})) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		for (int[] a : insert(new int[][]{
				{1, 2},
				{3, 5},
				{6, 7},
				{8, 10},
				{12, 16}
		}, new int[]{4, 8})) {
			System.out.println(Arrays.toString(a));
		}
	}
}
