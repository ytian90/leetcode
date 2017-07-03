package dynamicProgramming;

import java.util.Arrays;

/**
 * 568. Maximum Vacation Days
 * @author ytian
 *
 */
public class MaximumVacationDays {
	
	/*
	 * dp[i][j] stands for the max vacation days we can get in week i staying in city j. 
	 * It's obvious that dp[i][j] = max(dp[i - 1][k] + days[j][i]) (k = 0...N - 1, 
	 * if we can go from city k to city j). Also because values of week i only depends 
	 * on week i - 1, so we can compress two dimensional dp array to one dimension. 
	 * Time complexity O(K * N * N) as we can easily figure out from the 3 level of loops.
	 */
	
	public static int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;
        int K = days[0].length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < K; i++) {
        	int[] t = new int[N];
        	Arrays.fill(t, Integer.MIN_VALUE);
        	for (int j = 0; j < N; j++) {
        		for (int k = 0; k < N; k++) {
        			if (j == k || flights[k][j] == 1) {
        				t[j] = Math.max(t[j], dp[k] + days[j][i]);
        			}
        		}
        	}
        	dp = t;
        }
        
        int max = 0;
        for (int v : dp) {
        	max = Math.max(max, v);
        }
        return max;
    }

	public static void main(String[] args) {
		int[][] f1 = new int[][]{
			{0, 1, 1},
			{1, 0, 1},
			{1, 1, 0}
		};
		
		int[][] d1 = new int[][]{
			{1, 3, 1},
			{6, 0, 3},
			{3, 3, 3}
		};
		
		System.out.println(maxVacationDays(f1, d1));
		
		int[][] f2 = new int[][]{
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0}
		};
		
		int[][] d2 = new int[][]{
			{1, 1, 1},
			{7, 7, 7},
			{7, 7, 7}
		};
		
		System.out.println(maxVacationDays(f2, d2));
		
		int[][] f3 = new int[][]{
			{0, 1, 1},
			{1, 0, 1},
			{1, 1, 0}
		};
		
		int[][] d3 = new int[][]{
			{7, 0, 0},
			{0, 7, 0},
			{0, 0, 7}
		};
		
		System.out.println(maxVacationDays(f3, d3));
		
	}

}
