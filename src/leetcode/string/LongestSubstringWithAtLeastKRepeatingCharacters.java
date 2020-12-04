package leetcode.string;

import java.util.Arrays;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 * @author yutian
 * @since Sep 5, 2016
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

	public static int longestSubstring(String s, int k) {
		if (s == null || s.length() == 0)
			return 0;
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		boolean flag = true;
		for (int i : count) {
			if (i > 0 && i < k) flag = false;
		}
		if (flag == true) return s.length();
		int res = 0, start = 0, curr = 0;
		while (curr < s.length()) {
			if (count[s.charAt(curr) - 'a'] < k) {
				res = Math.max(res, longestSubstring(s.substring(start, curr), k));
				start = curr + 1;
			}
			curr++;
		}
		res = Math.max(res, longestSubstring(s.substring(start), k));
		return res;
	}

	// 1. Iteration
	public static int longestSubstring1(String s, int k) {
        if (s == null || s.length() == 0 || s.length() < k) {
        	return 0;
        }
        if (k <= 1) {
        	return s.length();
        }
        int max = 0;
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
        	if (s.length() - i <= max) {
        		return max;
        	}
        	Arrays.fill(map, 0);
        	int count = 0, check = 0, end = i;
        	for (int j = i; j < s.length(); j++) {
        		char c = s.charAt(j);
        		if (map[c - 'a'] == 0) {
        			count++;
        		}
        		if (map[c - 'a'] < k) {
        			check++;
        		}
        		map[c - 'a'] += 1;
        		if (check >= count * k) {
        			end = j;
        		}
        	}
        	int localMax = i == end ? 0 : end - i + 1;
        	max = Math.max(max, localMax);
        }
        return max;
    }
	
	// 2. Recursion
	public static int longestSubstring2(String s, int k) {
		return helper(s, k);
	}
	
	private static int helper(String s, int k) {
		if (s.length() < k) {
			return 0;
		}
		int[] map = new int[26];
		int index = 0;
		int smallest = Integer.MAX_VALUE;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map[c - 'a']++;
		}
		for (int j = 0; j < map.length; j++) {
			if (map[j] != 0 && smallest > map[j]) {
				smallest = map[j];
				index = j;
			}
		}
		if (smallest >= k) {
			return s.length();
		}
		int max = 0;
		String[] array = s.split(Character.toString((char)('a' + index)));
		for (int i = 0; i < array.length; i++) {
			max = Math.max(max, helper(array[i], k));
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(longestSubstring("aaabb", 3));
//		System.out.println(longestSubstring2("ababbc", 2));

	}

}
