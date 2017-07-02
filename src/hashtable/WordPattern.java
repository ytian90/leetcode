package hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Word Pattern
 * @author yutian
 * @since Dec 25, 2015
 */
public class WordPattern {

	public static void main(String[] args) {
		System.out.println(wordPattern2("abba", "dog cat cat dog"));
		System.out.println(wordPattern2("abba", "dog dog dog dog"));
	}

	// Solution 1 time O(N^2) space O(N)
	public static boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null)
            return false;
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            String s = strs[i];
            if (map.containsKey(c)) {
                if (map.get(c).equals(s)) continue;
                else return false;
            } else if (map.containsValue(s)) { // O(n)
                return false;
            }
            map.put(c, s);
        }
        return true;
    }
	
	// Solution 2 time O(N) space O(2N)
	public static boolean wordPattern2(String pattern, String str) {
		if (pattern == null || str == null)
            return false;
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;
        Map<Character, String> cs = new HashMap<>();
        Map<String, Character> sc = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char c = pattern.charAt(i);
            String s = strs[i];
            if (cs.containsKey(c) && !cs.get(c).equals(s)) {
                return false;
            }
            if (sc.containsKey(s) && c != sc.get(s)) {
                return false;
            }
            cs.put(c, s);
            sc.put(s, c);
        }
        return true;
	}

}
