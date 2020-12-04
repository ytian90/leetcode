package leetcode.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 296. Best Meeting Point
 * @author yutian
 * @since Dec 31, 2015
 */
public class BestMeetingPoint {
	public static int minTotalDistance(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		return getMin(rows) + getMin(cols);
	}

	private static int getMin(List<Integer> list) {
		int res = 0;
		Collections.sort(list);
		int i = 0, j = list.size() - 1;
		while (i < j) {
			res += list.get(j) - list.get(i);
			i++;
			j--;
		}
		return res;
	}

	// help to understand: http://www.cnblogs.com/grandyang/p/5291058.html
	// time complexity: O(mn), space complexity: O(mn)
	public static int minTotalDistance0(int[][] grid) {
		int n = grid.length, m = grid[0].length;
		List<Integer> r = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					r.add(i);
				}
			}
		}
		for (int j = 0; j < m; j++) {
			for (int i = 0; i < n; i++) {
				if (grid[i][j] == 1) {
					c.add(j);
				}
			}
		}
		return helper(r) + helper(c);
	}
	
	private static int helper(List<Integer> l) {
		int i = 0, j = l.size() - 1, sum = 0;
		while (i < j) {
			sum += l.get(j--) - l.get(i++);
		}
		return sum;
	}
	
	// Time complexity : O(mn*log(mn)) space: O(mn)
	public static int minTotalDistance1(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		List<Integer> r = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					r.add(i);
					c.add(j);
				}
			}
		}
		int row = r.get(r.size() / 2);
		Collections.sort(c);
		int col = c.get(c.size() / 2);
		return help(r, row) + help(c, col);
	}
	
	private static int help(List<Integer> l, int start) {
		int sum = 0;
		for (int i : l) {
			sum += Math.abs(i - start);
		}
		return sum;
	}
	
	public static int minTotalDistance2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] A = new int[m], B = new int[n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			++A[i];
        			++B[j];
        		}
        	}
        }
        int total = 0;
        for (int[] K: new int[][]{A, B}) {
        	int i = 0, j = K.length - 1;
        	while (i < j) {
        		int k = Math.min(K[i], K[j]);
        		total += k * (j - i);
        		if ((K[i] -= k) == 0) ++i;
        		if ((K[j] -= k) == 0) --j;
        	}
        }
        return total;
    }

	public static void main(String[] args) {
		int[][] test = new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
		System.out.println(minTotalDistance(test));
	}

}
