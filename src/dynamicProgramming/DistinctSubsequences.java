package dynamicProgramming;
/**
 * 115. Distinct Subsequences
 * @author yutian
 * @since Nov 9, 2015
 */
public class DistinctSubsequences {

	public static int numDistinct(String s, String t) {
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		for (int j = 0; j <= s.length(); j++) {
			dp[0][j] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (t.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[t.length()][s.length()];
	}

	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
	}
	
	/* 2-d DP: Time ~O(ST), Space ~O(ST) */
	// d(i, j): distinct sequence in s[0..i-1] same as T[0..j-1], i = 0..S, j = 0..T
    // d(i, j) = d(i - 1, j) if s[i-1] != T[j-1]
    // d(i, j) = d(i - 1, j) + d(i - 1, j - 1) if s[i-1] == T[j-1]
	public int numDistinct1(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
        	dp[i][0] = 1;
        }
        for (int i = 1; i <= m; ++i) {
        	for (int j = 1; j <= Math.min(i, n); ++j) {
        		dp[i][j] = dp[i - 1][j] + ((s.charAt(i - 1) == t.charAt(j - 1)) ? dp[i - 1][j - 1] : 0);
        	}
        }
        return dp[m][n];
    }
	
	/* 1-d DP: Time ~O(ST), Space ~O(T) */
	// fill up table : j direction forward
	public int numDistinct2(String s, String t) {
		int m = s.length(), n = t.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= m; i++) {
			int prev = dp[0];
			for (int j = 1; j <= Math.min(i, n); j++) {
				int curr = dp[j];
				dp[j] += (s.charAt(i - 1) == t.charAt(j - 1)) ? prev : 0;
				prev = curr;
			}
		}
		return dp[n];
	}
	
	/* 1-d DP: Time ~O(ST), Space ~O(T) */
	// fill up table: j direction backward
	public int numDistinct3(String s, String t) {
		int m = s.length(), n = t.length();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= m; i++) {
			for (int j = Math.min(i, n); j >= 1; j--) {
				dp[j] += (s.charAt(i - 1) == t.charAt(j - 1)) ? dp[j - 1] : 0;
			}
		}
		return dp[n];
	}

}
