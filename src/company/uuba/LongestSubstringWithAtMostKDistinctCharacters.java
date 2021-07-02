package company.uuba;

/**
 * LC 340. Longest Substring with At Most K Distinct Characters
 *
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most k distinct characters.
 *
 * Example 1:
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 * Example 2:
 *
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[256];
        int start = 0, maxLen = 0, counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (map[currChar] == 0) {
                counter++;
            }
            map[currChar]++;
            while (counter > k) {
                maxLen = Math.max(maxLen, i - start);
                char startChar = s.charAt(start);
                map[startChar]--;
                if (map[startChar] == 0) {
                    counter--;
                }
                start++;
            }
        }
        return Math.max(maxLen, s.length() - start);
    }
    /**
     * Time: O(N)
     * Space: O(1)
     */
}
