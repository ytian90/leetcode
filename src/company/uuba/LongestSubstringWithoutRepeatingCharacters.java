package company.uuba;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 *
 * Input: s = ""
 * Output: 0
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && start <= map.get(c)) {
                start = map.get(c) + 1;
            }
            map.put(c, i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
    /**
     * Time: O(N)
     * Space: O(min(N, M)), N is the stize of the string, M is the size of charset.
     */
}
