package dynamicProgramming;

/**
 * 516. Longest Palindromic Subsequence
 */
public class LongestPalindromicSubsequence {

    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("cbbd"));
    }

    public static int longestPalindromeSubseq2(String s) {
        return helper(s, 0, s.length() - 1, new Integer[s.length()][s.length()]);
    }

    public static int helper(String s, int i, int j, Integer[][] dp) {
        if (dp[i][j] != null) return dp[i][j];
        if (i > j) return 0;
        if (i == j) return 1;
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = helper(s, i + 1, j - 1, dp) + 2;
        } else {
            dp[i][j] = Math.max(helper(s, i + 1, j, dp), helper(s, i, j - 1, dp));
        }
        return dp[i][j];
    }


}
