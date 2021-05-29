package leetcode.dynamicProgramming;

/**
 * 727. Minimum Window Subsequence
 */
public class MinimumWindowSubsequence {

    // dp[i][j] stores the starting index of the substring where s1 has length i and s2 has length j
    public static String minWindow(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i + 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int start = 0, len = n + 1;
        for (int i = 1; i <= n; i++) {
            if (dp[i][m] != 0) {
                if (i - dp[i][m] + 1 < len) {
                    start = dp[i][m] - 1;
                    len = i - dp[i][m] + 1;
                }
            }
        }
        return len == n + 1 ? "" : s1.substring(start, start + len);
    }

    public static String minWindow2(String S, String T) {
        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j + 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        int start = 0, len = n + 1;
        for (int j = 1; j <= n; j++) {
            if (dp[m][j] != 0) {
                if (j - dp[m][j] + 1 < len) {
                    start = dp[m][j] - 1;
                    len = j - dp[m][j] + 1;
                }
            }
        }
        return len == n + 1 ? "" : S.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("abcdebdde", "bde"));
    }
}
