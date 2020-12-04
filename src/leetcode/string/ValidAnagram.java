package leetcode.string;

import java.util.HashMap;

/**
 * Valid Anagram
 * @author yutian
 * @since Aug 1, 2015
 */
public class ValidAnagram {
	
	public static void main(String[] args) {
		String s1 = "anagram", t1 = "nagaram";
		String s2 = "rat", t2 = "car";
		System.out.println(isAnagram(s1, t1));
		System.out.println(isAnagram(s2, t2));
	}
	
	// Solution
	public static boolean isAnagram(String s, String t) {
		int[] d = new int[256];
        for (char c: s.toCharArray()) d[c]++;
        for (char c: t.toCharArray()) d[c]--;
        for (int i: d) if (i != 0) return false;
        return true;
	}
	
	// Solution 2 HashMap
	public static boolean isAnagram2(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] sCharArr = s.toCharArray();
		char[] tCharArr = t.toCharArray();
		for(Character c : sCharArr) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				int count = map.get(c);
				map.put(c, count + 1);
			}
		}
		for (Character c : tCharArr) {
			if (map.containsKey(c)) {
				int count = map.get(c);
				if (count != 1) {
					map.put(c, count - 1);
				} else {
					map.remove(c);
				}
			} else {
				map.put(c, 1);
			}
		}
		return map.isEmpty();
	}
}
