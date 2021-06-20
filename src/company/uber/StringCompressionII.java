package company.uber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LC 1531. String Compression II
 *
 * Run-length encoding is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "aabccc" we replace "aa" by "a2" and replace "ccc" by "c3". Thus the compressed string becomes "a2bc3".
 *
 * Notice that in this problem, we are not adding '1' after single characters.
 *
 * Given a string s and an integer k. You need to delete at most k characters from s such that the run-length encoded version of s has minimum length.
 *
 * Find the minimum length of the run-length encoded version of s after deleting at most k characters.
 *
 * Example 1:
 *
 * Input: s = "aaabcccd", k = 2
 * Output: 4
 * Explanation: Compressing s without deleting anything will give us "a3bc3d" of length 6. Deleting any of the characters 'a' or 'c' would at most decrease the length of the compressed string to 5, for instance delete 2 'a' then we will have s = "abcccd" which compressed is abc3d. Therefore, the optimal way is to delete 'b' and 'd', then the compressed version of s will be "a3c3" of length 4.
 * Example 2:
 *
 * Input: s = "aabbaa", k = 2
 * Output: 2
 * Explanation: If we delete both 'b' characters, the resulting compressed string would be "a4" of length 2.
 * Example 3:
 *
 * Input: s = "aaaaaaaaaaa", k = 0
 * Output: 3
 * Explanation: Since k is zero, we cannot delete anything. The compressed string is "a11" of length 3.
 */
public class StringCompressionII {
    /**
     * Recursion with memo
     */
    Integer[][][][] dp;
    Set<Integer> addOneDigit = new HashSet<>(Arrays.asList(1, 9, 99));

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        this.dp = new Integer[n + 1][27][n + 1][k + 1];
        return dfs(s, 0, (char) ('a' + 26), 0, k);
    }

    private int dfs(String s, int start, char prev, int count, int k) {
        if (k < 0) {
            return Integer.MAX_VALUE;
        }
        if (start == s.length()) {
            return 0;
        }
        if (dp[start][prev - 'a'][count][k] != null) {
            return dp[start][prev- 'a'][count][k];
        }
        int res = 0;
        if (s.charAt(start) == prev) {
            res = dfs(s, start + 1, prev, count + 1, k) + (addOneDigit.contains(count) ? 1 : 0);
        } else {
            int keepNewChar = 1 + dfs(s, start + 1, s.charAt(start), 1, k);
            int deleteNewChar = dfs(s, start + 1, prev, count, k - 1);
            res = Math.min(keepNewChar, deleteNewChar);
        }
        return dp[start][prev - 'a'][count][k] = res;
    }
    /**
     * Time: O(N ^ 2 * K * 26)
     * Space: O(N ^ 2 * K * 26)
     */

    public int getLengthOfOptimalCompression_iterative(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j > 0) { // delete
                    dp[i][j] = dp[i - 1][j - 1];
                }
                int remove = 0, same = 0;
                for (int p = i; p > 0; p--) {
                    if (s.charAt(p - 1) == s.charAt(i - 1)) same++;
                    else if (++remove > j) break;
                    dp[i][j] = Math.min(dp[i][j], dp[p - 1][j - remove] + calculate(same));
                }
            }
        }
        return dp[n][k];
    }

    private int calculate(int len) {
        if (len == 0) return 0;
        else if (len == 1) return 1;
        else if (len < 10) return 2;
        else if (len < 100) return 3;
        return 4;
    }
    /**
     * We use dp[i][j] to denote the states, which is the best solution up until s[i] with at most j characters removed.
     *
     * For each character, we want to try all the solutions with removing at most j in [0, k] characters:
     *
     * Try to remove the current character if we can (j > 0): removing the current character is always easier.
     * We can transfer from the state of: dp[i - 1][j - 1]
     * Keep the current character in the final solution, and try to remove at most j different characters 
     * before the current character to form our chain. In the process of removal, we also count the number of 
     * characters same in our chain. So in every position p, we may transfer from a better state of
     * dp[p - 1][j - removed] + calcLen(same), which means to append our chain of length same, after the substring
     * of s.substring(0, p) with j - removed characters removed (since we have removed removed characters in order
     * to form our chain, we leave only j - removed for the previous substring).
     *
     * Time: O(K * N ^ 2)
     * Space: O(K * N)
     */
}
