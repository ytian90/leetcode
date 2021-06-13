package company.lnkin;

/**
 * LC 516. Longest Palindromic Subsequence
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        Integer[][] memo = new Integer[s.length() + 1][s.length() + 1];
        return helper(s, 0, s.length() - 1, memo);
    }

    private int helper(String s, int start, int end, Integer[][] memo) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }
        if (start == end) {
            return 1;
        }
        if (start > end) {
            return 0;
        }
        int res = 0;
        if (s.charAt(start) == s.charAt(end)) {
            res = Math.max(res, 2 + helper(s, start + 1, end - 1, memo));
        } else {
            res = Math.max(res, helper(s, start + 1, end, memo));
            res = Math.max(res, helper(s, start, end - 1, memo));
        }
        return memo[start][end] = res;
    }

    public int longestPalindromeSubseq2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
    
}
/**
 * Without memorization, then time complexity would be O(2^n) like you say.
 * This follows from the fact that any recursive function's time complexity is O(branches^depth).
 *
 * However, because we are memorizing, we "prune" the recursive tree and do not recurse into/solve the same sub-problem twice.
 * You can prove this by drawing the recursive call tree without memoization, you will see that there will be MANY overlapping subproblems.
 * But because we memoize, in the worst case, we only need to solve all subproblems ONCE, of which there are an upper bound of n^2 total.
 *
 * O(n^2) where n is the length of the input string, for both the recursive memoization
 * (top-down) approach and iterative tabulation (bottom-up) approach.
 *
 * Informal proof:
 *
 * For the top-down memoization approach, we can see that worst case we need to fill in the entire
 * memoization array (for every value of i and j), which is size n * n. So that's O(n^2) worst-case.
 * Of course, we'll never fill in the values when i == j or i > j, but this doesn't matter because
 * the complexity still grows as a function of n*n.
 *
 * For the bottom-up approach, we can see that it contains two nested for-loops which both run as
 * a function of the length of the string (n), therefore the time complexity there is definitely O(n^2).
 */
