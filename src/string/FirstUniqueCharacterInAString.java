package string;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 387. First Unique Character in a String
 * @author yutian
 * @since Aug 29, 2016
 */
public class FirstUniqueCharacterInAString {
	
	public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        char[] c = s.toCharArray();
        int[] counter = new int[256];
        for (int i = 0; i < c.length; i++) {
        	counter[c[i]]++;
        }
        for (int i = 0; i < c.length; i++) {
        	if (counter[c[i]] == 1) return i;
        }
        return -1;
    }
	
	// LinkedHashMap 1 pass
	public static int firstUniqChar2(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				if (map.get(s.charAt(i)) != null) {
					map.remove(s.charAt(i));
				}
			} else {
				map.put(s.charAt(i), i);
				set.add(s.charAt(i));
			}
		}
		return map.size() == 0 ? -1 : map.entrySet().iterator().next().getValue();
	}
	
	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}

}
