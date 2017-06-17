package dynamicProgramming;
/**
 * Get the longest common substring from two strings
 * @author yutian
 * @since Jan 11, 2016
 */
public class LongestCommonSubstring {
	
	// Time O(N^2) Space O(NaNb)
	public static int longestCommonSubstring(String A, String B) {
		int m = A.length();
		int n = B.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			dp[0][i] = 0;
		}
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubstring("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com"));
	}

}
