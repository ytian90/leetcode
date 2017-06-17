package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 447. Number of Boomerangs
 * @author yutian
 *
 */
public class NumberOfBoomerangs {
	
	// Time O(N^2) Space O(N)
	public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
        	for (int j = 0; j < points.length; j++) {
        		if (i == j) continue;
        		int d = helper(points[i], points[j]);
        		map.put(d, map.getOrDefault(d, 0) + 1);
        	}
        	for (int n : map.values()) {
        		res += n * (n - 1);
        	}
        	map.clear();
        }
        return res;
    }
	
	private static int helper(int[] a, int[] b) {
		int dx = a[0] - b[0];
		int dy = a[1] - b[1];
		return dx * dx + dy * dy;
	}

	public static void main(String[] args) {
		int[][] test = new int[][]{{0, 0}, {1, 0}, {2, 0}};
		System.out.println(numberOfBoomerangs(test));
		
	}

}
