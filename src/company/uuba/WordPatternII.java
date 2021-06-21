package company.uuba;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LC 291. Word Pattern II
 *
 * Given a pattern and a string s, return true if s matches the pattern.
 *
 * A string s matches a pattern if there is some bijective mapping of single characters to strings such that if each character in pattern is replaced by the string it maps to, then the resulting string is s. A bijective mapping means that no two characters map to the same string, and no character maps to two different strings.
 *
 * Example 1:
 *
 * Input: pattern = "abab", s = "redblueredblue"
 * Output: true
 * Explanation: One possible mapping is as follows:
 * 'a' -> "red"
 * 'b' -> "blue"
 * Example 2:
 *
 * Input: pattern = "aaaa", s = "asdasdasdasd"
 * Output: true
 * Explanation: One possible mapping is as follows:
 * 'a' -> "asd"
 * Example 3:
 *
 * Input: pattern = "abab", s = "asdasdasdasd"
 * Output: true
 * Explanation: One possible mapping is as follows:
 * 'a' -> "a"
 * 'b' -> "sdasd"
 * Note that 'a' and 'b' cannot both map to "asd" since the mapping is a bijection.
 * Example 4:
 *
 * Input: pattern = "aabb", s = "xyzabcxzyabc"
 * Output: false
 */
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        return isMatch(s, 0, pattern, 0, map, visited);
    }

    private boolean isMatch(String s, int i, String pattern, int j, Map<Character, String> map, Set<String> visited) {
        if (i == s.length() && j == pattern.length()) {
            return true;
        }
        if (i == s.length() || j == pattern.length()) {
            return false;
        }
        char c = pattern.charAt(j);
        if (map.containsKey(c)) {
            String expect = map.get(c);
            if (!s.startsWith(expect, i)) {
                return false;
            }
            return isMatch(s, i + expect.length(), pattern, j + 1, map, visited);
        }
        for (int k = i; k < s.length(); k++) {
            String sub = s.substring(i, k + 1);
            if (visited.contains(sub)) {
                continue;
            }
            map.put(c, sub);
            visited.add(sub);
            if (isMatch(s, k + 1, pattern, j + 1, map, visited)) {
                return true;
            }
            map.remove(c);
            visited.remove(sub);
        }
        return false;
    }
    /**
     * Time: O(n ^ m) exponential, n is string length, m is pattern length
     * Space: O(n ^ m) not sure
     */
}
