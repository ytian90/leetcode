package leetcode.hashtable;

import java.util.*;

/**
 * 76. Minimum Window Substring
 * @author yutian
 * @since Sep 3, 2015
 */
public class MinimumWindowSubstring {
	// Time ~ O(M+N), Space ~ O(M) where N = lenS, M = lenT
	public static String minWindow(String s, String t) {
		if (s.length() == 0 || t.length() == 0 || s.length() < t.length())
			return "";
		Map<Character, Integer> map = new HashMap<>();
		
		for (Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
		
		int count = 0, prev = 0, minStart = 0, minLen = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			if (map.containsKey(currChar)) {
				// record currChar (when all T's chars are found, all map's value <= 0)
				map.put(currChar, map.get(currChar) - 1);
				// stop adding length (leetcode.sort) if we have more currChar's than t does
				if (map.get(currChar) >= 0) count++;
				// s[prev, i] contains all t's chars, now shrink the left end (prev)
				while (count == t.length()) {
					char prevChar = s.charAt(prev);
					// if prevChar exists in t
					if (map.containsKey(prevChar)) {
						// recover map by adding the value back
						map.put(prevChar, map.get(prevChar) + 1);
						if (map.get(prevChar) > 0) {
							if (minLen > i - prev + 1) {
								minLen = i - prev + 1;
								minStart = prev;
							}
							count--; // reduce leetcode.sort to end while loop
						}
					}
					prev++;
				}
			}
		}
		if (minLen == Integer.MAX_VALUE) return "";
		else return s.substring(minStart, minStart + minLen);
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADBAC", "AB"));
		System.out.println(minWindow("ADBAA", "AAB"));
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

		Set<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('b');
		set.add('c');
		String s1 = "facebookaebcde";
		System.out.println(minString(s1, set));
	}
	
	// easier version
	// Given a set of unique characters, find the minimum substring which cover all the
	// characters in the set. lc : 76
	public static String minString(String str, Set<Character> set) {
		if (str == null || set == null || str.length() == 0 || str.length() < set.size()) {
			throw new IllegalArgumentException();
		}
		if (set.size() == 0) return "";
		HashMap<Character, Integer> hashmap = new HashMap<>();
		int total = set.size(), counter = 0;
		String res = "";
		int left = 0, right = 0;
		while (right < str.length()) {
			char c = str.charAt(right);
			if (set.contains(c)) {
				if (!hashmap.containsKey(c)) {
					hashmap.put(c, 1);
					counter++;
				} else {
					hashmap.put(c, hashmap.get(c) + 1);
				}
			}
			right++;
			if (counter == total) {
				while (left < str.length()) {
					char leftChar = str.charAt(left);
					if (set.contains(leftChar)) {
						hashmap.put(leftChar, hashmap.get(leftChar) - 1);
						if (hashmap.get(leftChar) == 0) {
							hashmap.remove(leftChar);
							counter--;
							if (res.length() == 0 || res.length() > right - left) {
								res = str.substring(left, right);
							}
							left++;
							break;
						}
					}
					left++;
				}
			}
		}
		return (res.length() == 0) ? null: res;
	}
}
