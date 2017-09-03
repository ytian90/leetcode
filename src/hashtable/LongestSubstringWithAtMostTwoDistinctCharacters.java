package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * @author yutian
 * @since Jan 22, 2016
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	
	// HashMap
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() < 1) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int prev = 0, max = 0;
        for (int i = 0; i < s.length(); ) {
        	if (map.size() <= 2) {
        		map.put(s.charAt(i), i);
        		i++;
        	}
        	if (map.size() > 2) {
        		int leftMost = s.length();
        		for (int k: map.values()) {
        			leftMost = Math.min(leftMost, k);
        		}
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
        int i = 0, j = -1, maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            if (j > -1 && s.charAt(k) != s.charAt(j)) {
                maxLen = Math.max(maxLen, k - i);
                i = j + 1;
            }
            j = k - 1;
        }
        return maxLen > (s.length() - i) ? maxLen: s.length() - i;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct2("eceba"));
		System.out.println(lengthOfLongestSubstringTwoDistinct2("a"));
		System.out.println(lengthOfLongestSubstringTwoDistinct2("aac"));
		System.out.println(lengthOfLongestSubstringTwoDistinct2("abc"));
	}

}
