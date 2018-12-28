package dynamicProgramming;

/**
 * 730. Count Different Palindromic Subsequences
 * https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/109507/Java-96ms-DP-Solution-with-Detailed-Explanation
 */
public class CountDifferentPalindromicSubsequences {

    public static int countPalindromicSubsequences(String S) {
        int n = S.length();
        int[][] dp = new int[n][n];
        char[] chars = S.toCharArray();
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int distance = 1; distance < n; distance++) {
            for (int i = 0; i < n - distance; i++) {
                int j = i + distance;
                if (chars[i] == chars[j]) {
                    int lo = i + 1, hi = j - 1;
                    while (lo <= hi && chars[lo] != chars[j])
                        lo++;
                    while (lo <= hi && chars[hi] != chars[j])
                        hi--;
                    if (lo > hi) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (lo == hi) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[lo + 1][hi - 1];
                    }
                } else {
                    // s.charAt(i) != s.charAt(j)
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequences("bccb"));
    }
}
