package company.uuba;

/**
 * LC 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prev = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prev) != 0) {
                prev = prev.substring(0, prev.length() - 1);
            }
        }
        return prev;
    }
    /**
     * Time: O(N)
     * Space: O(1)
     */
}
