package company.uuba;

/**
 * LC 91. Decode Ways
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * Given a string s containing only digits, return the number of ways to decode it.
 *
 * The answer is guaranteed to fit in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: s = "12"
 * Output: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * Example 2:
 *
 * Input: s = "226"
 * Output: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * Example 3:
 *
 * Input: s = "0"
 * Output: 0
 * Explanation: There is no character that is mapped to a number starting with 0.
 * The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
 * Hence, there are no valid ways to decode this since all digits need to be mapped.
 * Example 4:
 *
 * Input: s = "06"
 * Output: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 */
public class DecodeWays {
    /**
     * Recursion with memo
     * Time: O(N)
     * Space: O(N)
     */
    public int numDecodings(String s) {
        int n = s.length();
        Integer[] memo = new Integer[n];
        return s.isEmpty() ? 0 : helper(s, 0, memo);
    }

    private int helper(String s, int pos, Integer[] memo) {
        int n = s.length();
        if (n == pos) return 1;
        if (s.charAt(pos) == '0') return 0;
        if (memo[pos] != null) return memo[pos];
        int res = helper(s, pos + 1, memo);
        if (pos < n - 1 && (s.charAt(pos) == '1' || s.charAt(pos) == '2' && s.charAt(pos + 1) <= '6')) {
            res += helper(s, pos + 2, memo);
        }
        return memo[pos] = res;
    }

    /**
     * Bottom-up DP with 1-D array
     * Time: O(N)
     * Space: O(N)
     */
    public int numDecodings_DP_1DArray(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            char first = s.charAt(i - 1);
            char second = s.charAt(i - 2);
            if (first >= '1' && first <= '9') {
                dp[i] += dp[i - 1];
            }
            if (second == '1' || second == '2' && first < '7') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    /**
     * Bottom-up DP with constant space
     * Time: O(N)
     * Space: O(1)
     */
    public int numDecodings_DP_ConstantSpace(String s) {
        int n = s.length(), dp1 = 1, dp2 = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = s.charAt(i) == '0' ? 0 : dp1;
            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                curr += dp2;
            }
            dp2 = dp1;
            dp1 = curr;
        }
        return dp1;
    }
}
