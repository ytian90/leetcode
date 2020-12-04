package leetcode.hashtable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * @author yutian
 * @since Jan 22, 2016
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int prev = 0, res = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			while (map.size() > 2) {
				char prevChar = s.charAt(prev);
				map.put(prevChar, map.get(prevChar) - 1);
				if (map.get(prevChar) == 0) {
					map.remove(prevChar);
				}
				prev++;
			}
			res = Math.max(res, i - prev + 1);
		}
		return res;
	}


	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("a"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("aac"));
		System.out.println(lengthOfLongestSubstringTwoDistinct("abc"));
	}
	
	// HashMap
	public static int lengthOfLongestSubstringTwoDistinct1(String s) {
		if (s == null || s.length() < 1) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int prev = 0, max = 0;
        for (int i = 0; i < s.length(); ) {
        	if (map.size() <= 2) {
        		map.put(s.charAt(i), i);
        		i++;
        	}
        	if (map.size() > 2) {
        		int leftMost = Collections.min(map.values());
        		map.remove(s.charAt(leftMost));
        		prev = leftMost + 1;
        	}
        	max = Math.max(max, i - prev);
        }
        return max;
    }
	
	// two pointers
	public static int lengthOfLongestSubstringTwoDistinct2(String s) {
		// i, j to track the last indices of two characters
		// i is first, j is second
		if (s == null) return 0;
        if (s.length() < 3) return s.length();
        int i = 0, j = -1, max = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            if (j > -1 && s.charAt(k) != s.charAt(j)) {
                max = Math.max(max, k - i);
                i = j + 1;
            }
            j = k - 1;
        }
        return max > (s.length() - i) ? max: s.length() - i; // aac
	}


}
