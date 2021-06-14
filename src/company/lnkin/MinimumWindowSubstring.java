package company.lnkin;

/**
 * LC 76. Minimum Window Substring
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 * Explanation: The entire string s is the minimum window.
 * Example 3:
 *
 * Input: s = "a", t = "aa"
 * Output: ""
 * Explanation: Both 'a's from t must be included in the window.
 * Since the largest window of s only has one 'a', return empty string.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, minStart = 0, minLen = Integer.MAX_VALUE / 2, counter = t.length();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (map[currChar] > 0) {
                counter--;
            }
            map[currChar]--;
            while (counter == 0) {
                if (minLen > i - start + 1) {
                    minLen = i - start + 1;
                    minStart = start;
                }
                char startChar = s.charAt(start);
                map[startChar]++;
                if (map[startChar] > 0) counter++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE / 2 ? "" : s.substring(minStart, minStart + minLen);
    }

}
