package hashtable;

import java.util.HashMap;

/**
 * Isomorphic Strings
 * @author yutian
 * @since Aug 3, 2015
 */
public class IsomorphicStrings {
	
	public static void main(String[] args) {
		String s1 = "egg", t1 = "add";
		System.out.println(isIsomorphic2(s1, t1));
	}
	
	// Solution 1 HashMap
	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (map.containsKey(a)) {
                if (b == map.get(a)) continue;
                else return false;
            }
            if (map.containsValue(b)) return false;
            map.put(a, b);
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
}
