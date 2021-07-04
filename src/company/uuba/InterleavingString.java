package company.uuba;

/**
 * LC 97. Interleaving String
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 *
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 *
 * Example 1:
 *
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * Example 3:
 *
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), k = s3.length();
        if (n + m != k) return false;
        Boolean[][] memo = new Boolean[n + 1][m + 1];
        return helper(s1, 0, s2, 0, s3, 0, memo);
    }

    private boolean helper(String s1, int a, String s2, int b, String s3, int c, Boolean[][] memo) {
        if (a == s1.length()) {
            return s2.substring(b).equals(s3.substring(c));
        }
        if (b == s2.length()) {
            return s1.substring(a).equals(s3.substring(c));
        }
        if (memo[a][b] != null) {
            return memo[a][b];
        }
        boolean res = false;
        if (s1.charAt(a) == s3.charAt(c) && helper(s1, a + 1, s2, b, s3, c + 1, memo) ||
            s2.charAt(b) == s3.charAt(c) && helper(s1, a, s2, b + 1, s3, c + 1, memo)) {
            res = true;
        }
        return memo[a][b] = res;
    }
    /**
     * Time: O(N * M)
     * Space: O(N * M)
     */

    public boolean isInterleave_DP(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if (s3.length() != n + m) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                boolean oneEqualsThree = s1.charAt(i - 1) == s3.charAt(i + j - 1);
                boolean twoEqualsThree = s2.charAt(j - 1) == s3.charAt(i + j - 1);
                if (oneEqualsThree && twoEqualsThree) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (oneEqualsThree) {
                    dp[i][j] = dp[i - 1][j];
                } else if (twoEqualsThree) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
    /**
     * Time: O(N * M)
     * Space: O(N * M)
     */
}
