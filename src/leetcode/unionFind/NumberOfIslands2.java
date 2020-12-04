package leetcode.unionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 305. Number of Islands 2
 * @author yutian
 * @since Jan 28, 2016
 */
public class NumberOfIslands2 {
	
	static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (m <= 0 || n <= 0) return result;
        int count = 0; // number of islands
        int[] set = new int[m * n]; // one island = one tree
        Arrays.fill(set, -1);
        for (int[] p : positions) {
        	int i = n * p[0] + p[1]; // assume new point is isolated island
        	set[i] = i; // add new islands
        	count++; 
        	for (int[] d: dirs) {
        		int x = p[0] + d[0];
        		int y = p[1] + d[1];
        		int pos = n * x + y;
        		if (x < 0 || x >= m || y < 0 || y >= n || set[pos] == -1) continue;
        		int is = find(set, pos);
        		if (i != is) { // if neighbor is in another island
        			set[i] = is; // union two islands
        			i = is; // current tree i = joined tree i
        			count--;
        		}
        	}
        	result.add(count);
        }
        return result;
    }

	private static int find(int[] set, int p) {
		while (p != set[p]) {
			set[p] = set[set[p]];
			p = set[p];
		}
		return p;
	}

	public static void main(String[] args) {
		int[][] p = new int[][]{{0, 0}, {0, 1}, {1, 2}, {1, 1}};
		System.out.println(numIslands2(3, 3, p));
	}

}
