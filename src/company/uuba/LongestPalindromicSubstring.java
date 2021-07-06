package company.uuba;

/**
 * LC 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 */
public class LongestPalindromicSubstring {
    String res = "";

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                helper(s, i, i + 1);
            }
        }
        return res;
    }

    private void helper(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 1 > res.length()) {
            res = s.substring(i + 1, j);
        }
    }
    /**
     * Time: O(N ^ 2)
     * Space: O(1)
     */
}
