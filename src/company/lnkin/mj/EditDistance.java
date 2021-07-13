package company.lnkin.mj;

/**
 * LC 72. Edit Distance
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        Integer[][] memo = new Integer[word1.length() + 1][word2.length() + 1];
        return helper(word1, 0, word2, 0, memo);
    }

    private int helper(String word1, int i, String word2, int j, Integer[][] memo) {
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE / 2;
        if (word1.charAt(i) == word2.charAt(j)) {
            res = helper(word1, i + 1, word2, j + 1, memo);
        } else {
            int add = helper(word1, i, word2, j + 1, memo);
            int delete = helper(word1, i + 1, word2, j, memo);
            int replace = helper(word1, i + 1, word2, j + 1, memo);
            res = 1 + Math.min(Math.min(add, delete), replace);
        }
        return memo[i][j] = res;
    }

    /**
     * Time: O(N ^ 2)
     * Space: O(N ^ 2)
     */

    public int minDistance_dp(String word1, String word2) {
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
