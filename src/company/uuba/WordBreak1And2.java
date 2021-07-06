package company.uuba;

import java.util.*;

/**
 * LC 139. Word Break
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 *
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 * Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * Output: false
 */
public class WordBreak1And2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        Set<String> dict = new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (dict.contains(sub) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    /**
     * Time: O(N ^ 3), 2 nested loops, and substring computation at each iteration.
     * Space: O(N)
     */


    /**
     * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
     *
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     * Output: ["cats and dog","cat sand dog"]
     * Example 2:
     *
     * Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
     * Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
     * Explanation: Note that you are allowed to reuse a dictionary word.
     * Example 3:
     *
     * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
     * Output: []
     */
    Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak2(String s, List<String> wordDict) {
        return helper(s, new HashSet<>(wordDict));
    }

    private List<String> helper(String s, Set<String> dict) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<>();
        if (dict.contains(s)) {
            res.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            if (dict.contains(left)) {
                for (String sub : helper(s.substring(i), dict)) {
                    res.add(left + " " + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
    /**
     * Time: O(2 ^ N)
     * Space: O(2 ^ N)
     */
}
