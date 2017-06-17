package dynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
/**
 * 354. Russian Doll Envelopes
 * @author yutian
 * @since Jul 17, 2016
 */
public class RussianDollEnvelopes {
	
	// Binary Search
	public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0 
        		|| envelopes[0] == null || envelopes[0].length != 2) {
        	return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
    		public int compare(int[] a, int[] b) {
    			if (a[0] == b[0])
    				return b[1] - a[1];
    			else
    				return a[0] - b[0];
    		}
    	});
    	int[] dp = new int[envelopes.length];
    	int len = 0;
    	for (int[] e: envelopes) {
    		int index = Arrays.binarySearch(dp, 0, len, e[1]);
    		if (index < 0) index = -(index + 1);
    		dp[index] = e[1];
    		if (index == len) len++;
    	}
    	return len;
    }
	
	// DP
	public static int maxEnvelopes2(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) return 0;
		Arrays.sort(envelopes, (int[] x, int[] y) -> x[0] - y[0]);
		int n = envelopes.length;
		int[] dp = new int[n];
		int res = 0;
		for (int i = 0; i < n; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (fit(envelopes[j], envelopes[i])) max = Math.max(max, dp[j]);
			}
			dp[i] = max + 1;
			res = Math.max(dp[i], res);
		}
		return res;
	}

	private static boolean fit(int[] a, int[] b) {
		return (a[0] < b[0] && a[1] < b[1]);
	}

	public static void main(String[] args) {
		int[][] t = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
		System.out.println(maxEnvelopes(t));
	}

}
