package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle
 * @author yutian
 * @since Aug 12, 2015
 */
public class Triangle {

	public static int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] dp = new int[n];
		for (int r = n - 1; r >= 0; r--) {
			for (int c = 0; c <= r; c++) {
				if (c == n - 1) {
					dp[c] = triangle.get(r).get(c);
				} else {
					dp[c] = Math.min(dp[c], dp[c + 1]) + triangle.get(r).get(c);
				}
			}
		}
		return dp[0];
	}


	public static void main(String[] args) {
		List<Integer> l1 = Arrays.asList(2);
		List<Integer> l2 = Arrays.asList(3, 4);
		List<Integer> l3 = Arrays.asList(6, 5, 7);
		List<Integer> l4 = Arrays.asList(4, 1, 8, 3);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(l1);
		result.add(l2);
		result.add(l3);
		result.add(l4);
		System.out.println(result);

		System.out.println(minimumTotal(result));
//		System.out.println(minimumTotal2(result));

	}

	// Solution 1: Bottom-incr approach
	public static int minimumTotal1(List<List<Integer>> triangle) {
		int N = triangle.size();
		int[][] sum = new int[N][N];
		for (int r = N - 1; r >= 0; r--) {
			for (int c = 0; c <= r; c++) {
				if (r == N - 1) {
					sum[r][c] = triangle.get(r).get(c);
				} else {
					sum[r][c] = Math.min(sum[r + 1][c], sum[r + 1][c + 1]) + triangle.get(r).get(c);
				}
			}
		}
		return sum[0][0];
	}
	// Solution 2: 1-d DP
	public static int minimumTotal2(List<List<Integer>> triangle) {
		int N = triangle.size();
		int[] sum = new int[N];
		for (int r = N - 1; r >= 0; r--) {
			for (int c = 0; c <= r; c++) {
				if (r == N - 1) {
					sum[c] = triangle.get(r).get(c);
				} else {
					sum[c] = Math.min(sum[c], sum[c + 1]) + triangle.get(r).get(c);
				}
			}
		}
		return sum[0];
	}

}
