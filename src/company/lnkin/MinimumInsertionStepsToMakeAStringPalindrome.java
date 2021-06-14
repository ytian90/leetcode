package company.lnkin;

/**
 * LC 1312. Minimum Insertion Steps to Make a String Palindrome
 *
 * Given a string s. In one step you can insert any character at any index of the string.
 *
 * Return the minimum number of steps to make s palindrome.
 *
 * A Palindrome String is one that reads the same backward as well as forward.
 *
 * Example 1:
 *
 * Input: s = "zzazz"
 * Output: 0
 * Explanation: The string "zzazz" is already palindrome we don't need any insertions.
 * Example 2:
 *
 * Input: s = "mbadm"
 * Output: 2
 * Explanation: String can be "mbdadbm" or "mdbabdm".
 * Example 3:
 *
 * Input: s = "leetcode"
 * Output: 5
 * Explanation: Inserting 5 characters the string becomes "leetcodocteel".
 * Example 4:
 *
 * Input: s = "g"
 * Output: 0
 * Example 5:
 *
 * Input: s = "no"
 * Output: 1
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    // Recursion with memorization
    public int minInsertions(String s) {
        int n = s.length();
        Integer[][] memo = new Integer[n + 1][n + 1];
        return helper(s, 0, n - 1, memo);
    }

    private int helper(String s, int start, int end, Integer[][] memo) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        if (start >= end) {
            return 0;
        }
        int res = Integer.MAX_VALUE / 2;
        if (s.charAt(start) == s.charAt(end)) {
            res = Math.min(res, helper(s, start + 1, end - 1, memo));
        } else {
            res = Math.min(res, 1 + helper(s, start + 1, end, memo));
            res = Math.min(res, 1 + helper(s, start, end - 1, memo));
        }
        return memo[start][end] = res;
    }

    // Bottom-up DP solution
    public int minInsertions2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(1 + dp[i + 1][j], 1 + dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
