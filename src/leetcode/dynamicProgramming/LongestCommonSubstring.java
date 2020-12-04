package leetcode.dynamicProgramming;
/**
 * Get the longest common substring from two strings
 * https://www.youtube.com/watch?v=BysNXJHzCEs&index=16&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 * @author yutian
 * @since Jan 11, 2016
 */
public class LongestCommonSubstring {
	
	// Time O(N^2) Space O(NaNb)
	public static int longestCommonSubstring(String A, String B) {
		int n = A.length();
		int m = B.length();
		int[][] dp = new int[n + 1][m + 1];
		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubstring("abcdef", "zcdemf"));
	}

}
