package dynamicProgramming;

/**
 * Longest Common Subsequence
 * https://www.youtube.com/watch?v=NnD96abizww&index=2&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(char[] a, char[] b, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcdaf".toCharArray(),
                "acbcf".toCharArray(), 6, 5));
    }
}
