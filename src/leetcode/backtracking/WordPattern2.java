package leetcode.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 291. Word Pattern II
 * @author yutian
 * @since Feb 15, 2016
 */
public class WordPattern2 {
	
	Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    
    public boolean wordPatternMatch(String pattern, String str) {
        return helper(pattern, 0, str, 0);
    }
    
    boolean helper(String pat, int m, String str, int n) {
        if (m == pat.length() && n == str.length()) return true;
        if (m == pat.length() || n == str.length()) return false;
        char c = pat.charAt(m);
        if (map.containsKey(c)) {
            String s = map.get(c);
            // check if we can use it to match str[i...i + s.length()]
            if (!str.startsWith(s, n))
                return false;
            // if it can match, continue to match the rest
            return helper(pat, m + 1, str, n + s.length());
        }
        // pattern character doesn't exist in the map
        for (int i = n; i < str.length(); i++) {
            String p = str.substring(n, i + 1);
            if (set.contains(p)) continue;
            map.put(c, p);
            set.add(p);
            if (helper(pat, m + 1, str, i + 1)) {
                return true;
            }
            map.remove(c);
            set.remove(p);
        }
        return false;
    }

	public static void main(String[] args) {
		WordPattern2 t = new WordPattern2();
		System.out.println(t.wordPatternMatch("abab", "redblueredblue"));
		System.out.println(t.wordPatternMatch("aaaa", "asdasdasdasd"));
		System.out.println(t.wordPatternMatch("aabb", "xyzabcxzyabc"));
	}

}
