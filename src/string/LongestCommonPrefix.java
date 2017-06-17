package string;

import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 * @author yutian
 * @since Aug 7, 2015
 */
public class LongestCommonPrefix {
	
	// Time ~O(N) Best
	public static String longestCommonPrefix3(String[] strs) {
		if (strs.length == 0) return "";
		String pre = strs[0];
		for (int i = 1; i < strs.length; i++) {
			if (pre.equals("")) return pre;
			while (strs[i].indexOf(pre) != 0)
				pre = pre.substring(0, pre.length() - 1);
		}
		return pre;
	}
		
	public static void main(String[] args) {
		String[] t1 = new String[]{"abcd", "ab", "abc"};
		System.out.println(longestCommonPrefix3(t1));
	}
	
	// Time ~O(N^2)
	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 1) return strs[0];
		
		// Compare each two adjacent pairs
		String prefix = "";
		int minPrefix = Integer.MAX_VALUE;
		for (int i = 1; i < strs.length; i++) {
			int maxPrefix = 0;
			// compare two adjacent pairs
			int m = strs[i - 1].length(), n = strs[i].length();
			for (int j = 0; j < Math.min(m, n); j++) {
				if (strs[i - 1].charAt(j) == strs[i].charAt(j)) {
					maxPrefix++;
				} else {
					break;
				}
			}
			if (maxPrefix < minPrefix) {
				minPrefix = maxPrefix;
				prefix = strs[i - 1].substring(0, minPrefix);
			}
		}
		return prefix;
	}
	
	// Time ~O(NlogN)
	public static String longestCommonPrefix2(String[] strs) {
		StringBuilder result = new StringBuilder();
		if (strs == null || strs.length == 0) return result.toString();
		Arrays.sort(strs);
		char[] a = strs[0].toCharArray();
		char[] b = strs[strs.length - 1].toCharArray();
		for (int i = 0; i < a.length; i++) {
			if (b.length > i && b[i] == a[i]) {
				result.append(b[i]);
			} else {
				return result.toString();
			}
		}
		return result.toString();
	}
	
	
}
