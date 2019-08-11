package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 * @author yutian
 * @since Apr 8, 2016
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<>();
		int prev = 0, res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
			while (map.size() > k) {
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
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
		System.out.println(lengthOfLongestSubstringKDistinct("abaccc", 2));
		System.out.println(lengthOfLongestSubstringKDistinct("abccbcab", 2));
	}

	// Method 1: Using Unicode string with hashMap
	public static int lengthOfLongestSubstringKDistinct0(String s, int k) {
		if (s == null || s.length() == 0 || k == 0)
			return 0;
		int n = s.length(), start = 0, res = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			while (map.size() > k) {
				char prev = s.charAt(start);
				map.put(prev, map.get(prev) - 1);
				if (map.get(prev) == 0) map.remove(prev);
				start++;
			}
			res = Math.max(res, i - start + 1);
		}
		return res;
	}
	
	// Method 2: Using sliding window O(N)
	public static int lengthOfLongestSubstringKDistinct1(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
        	if (count[s.charAt(j)]++ == 0) num++;
        	if (num > k) {
        		// left pointer move forward until some letter is out
        		while (--count[s.charAt(i++)] > 0);
        		num--;
        	}
        	res = Math.max(res, j - i + 1);
        }
        return res;
    }



}
