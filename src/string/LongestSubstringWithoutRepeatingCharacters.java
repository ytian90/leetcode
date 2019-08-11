package string;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * @author yutian
 * @since Jul 25, 2015
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int start = 0, res = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c) && map.get(c) >= start) {
				start = map.get(c) + 1;
			}
			map.put(c, i);
			res = Math.max(res, i - start + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}


	// Solution 1 Time ~O(N)
	public static int lengthOfLongestSubstring1(String s) {
		boolean[] exist = new boolean[256];
		int start = 0, max = 0;
		for (int i = 0; i < s.length(); i++) {
			while (exist[s.charAt(i)])
				exist[s.charAt(start++)] = false;
			exist[s.charAt(i)] = true;
			max = Math.max(max, i - start + 1);
		}
		return max;
	}
	
	// Solution 2 Time ~O(N)
	public static int lengthOfLongestSubstring2(String s) {
		int[] map = new int[256];
		Arrays.fill(map, -1);
		int start = 0, max = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map[c] >= start) start = map[c] + 1;
			map[c] = i;
			max = Math.max(max, i - start + 1);
		}
		return max;
	}
	
	// Solution 3 Time ~O(N)
	public static int lengthOfLongestSubstring3(String s) {
		if (s == null || s.length() == 0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0, maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c) && map.get(c) >= start) {
				start = map.get(c) + 1;
			}
			map.put(c, i);
			maxLen = Math.max(maxLen, i - start + 1);
		}
		return maxLen;
	}

}
