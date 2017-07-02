package hashtable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * 356. Line Reflection
 * @author yutian
 * @since Jul 16, 2016
 */
public class LineReflection {
	
	public static boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for (int[] p : points) {
        	max = Math.max(max, p[0]);
        	min = Math.min(min, p[0]);
        	String str = p[0] + "|" + p[1];
        	set.add(str);
        }
        int sum = max + min;
        for (int[] p : points) {
        	String str = (sum - p[0]) + "|" + p[1];
        	if (!set.contains(str)) {
        		return false;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[][] t1 = new int[][]{{1, 1}, {-1, 1}};
		int[][] t2 = new int[][]{{1, 1}, {-1, -1}};
		System.out.println(isReflected(t1));
		System.out.println(isReflected(t2));
	}
	
	static int mid = 0;
	public static boolean isReflected2(int[][] points) {
		if (points.length <= 1) return true;
		int min = points[0][0];
		int max = points[0][0];
		for (int[] p : points) {
			min = Math.min(min, p[0]);
			max = Math.max(max, p[0]);
		}
		mid = (min + max) / 2;
		Arrays.sort(points, new myComparator());
		
		int left = 0, right = points.length - 1;
		while (left <= right) {
			if ((points[left][0] - min) != (max - points[right][0]))
				return false;
			if (points[left][0] == points[right][0])
				return true;
			if (points[left][1] != points[right][1])
				return false;
			++left;
			--right;
		}
		
		return true;
	}
	
	public static class myComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] p1, int[] p2) {
			if (p1[0] != p2[0]) {
				return Integer.compare(p1[0], p2[0]);
			}
			if (p1[0] <= mid) {
				return Integer.compare(p1[1], p2[1]);
			}
			return Integer.compare(p2[1], p1[1]);
		}
	}
}
