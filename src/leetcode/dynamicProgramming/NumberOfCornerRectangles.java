package leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 750. Number of Corner Rectangles
 * @author ytian
 *
 */
public class NumberOfCornerRectangles {
	
	// time O(m * n^2) space O(n^2)
	public static int countCornerRectangles(int[][] grid) {
		int m = grid.length, n = grid[0].length, res = 0;
		int[][] dp = new int[n][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) continue;
				for (int k = j + 1; k < n; k++) {
					if (grid[i][k] == 0) continue;
					res += dp[j][k]++;
				}
			}
		}
		return res;
	}
	
	// Time O(R * C^2), Space O(C^2)
	public static int countCornerRectangles1(int[][] grid) {
		Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int[] row : grid) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0) continue;
                for (int j = i + 1; j < row.length; j++) {
                    if (row[j] == 0) continue;
                    int pos = i * 200 + j;
                    int c = count.getOrDefault(pos, 0);
                    res += c;
                    count.put(pos, c + 1);
                }
            }
        }
        return res;
	}
	
	// time : O(m^2 * n), space : O(1)
	public static int countCornerRectangles2(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 1; i++) {
        		for (int j = i + 1; j < grid.length; j++) {
        			int count = 0;
        			for (int k = 0; k < grid[0].length; k++) {
        				if (grid[i][k] == 1 && grid[j][k] == 1)
        					count++;
        			}
        			if (count > 0) res += count * (count - 1) / 2; 
        		}
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(countCornerRectangles(new int[][] {
			{1, 0, 0, 1, 0},
			{0, 0, 1, 0, 1},
			{0, 0, 0, 1, 0},
			{1, 0, 1, 0, 1},
		}));
		
		System.out.println(countCornerRectangles1(new int[][] {
			{1, 1, 1},
			{1, 1, 1},
			{1, 1, 1},
		}));
		
		System.out.println(countCornerRectangles(new int[][] {
			{1, 1, 1, 1},
		}));
	}

}
