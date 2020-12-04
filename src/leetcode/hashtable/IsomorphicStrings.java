package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Isomorphic Strings
 * @author yutian
 * @since Aug 3, 2015
 */
public class IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (map.containsKey(a)) {
                if (map.get(a) != b) {
                    return false;
                }
            } else {
                if (map.containsValue(b)) {
                    return false;
                }
                map.put(a, b);
            }
        }
        return true;
    }
	// Solution 2
	public static boolean isIsomorphic2(String s, String t) {
		char[] ss = new char[256];
        char[] tt = new char[256];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (ss[a] == 0 && tt[b] == 0) {
                ss[a] = b;
                tt[b] = a;
            }
            if (ss[a] != b || tt[b] != a) return false;
        }
        return true;
	}

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
        System.out.println(isIsomorphic("paper", "title")); // true
        System.out.println(isIsomorphic("ab", "aa")); // false
    }

    public static boolean isIsomorphic3(String s, String t) {
        int[] map = new int[512];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] != map[t.charAt(i) + 256]) {
                return false;
            }
            map[s.charAt(i)] = i + 1;
            map[t.charAt(i) + 256] = i + 1;
        }
        return true;
    }
}
