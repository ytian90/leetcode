package string;
/**
 * 5. Longest Palindromic Substring
 * @author yutian
 * @since Jul 25, 2015
 */
public class LongestPalindromicSubstring {
	// Solution 1 Time ~O(N^2), Space ~O(1)
	public static String longestPalindrome(String s) {
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i+1);
			int len = Math.max(len1, len2);
			if (len > end - start) { // ??
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	private static int expandAroundCenter(String s, int L, int R) {
		while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
			L--;
			R++;
		}
		return R - L - 1;
	}
	
	// Solution 2
	private static int start, max;
	
	public static String longestPalindrome2(String s) {
		int len = s.length();
		if (len < 2) return s;
		for (int i = 0; i < len - 1; i++) {
			helper(s, i, i);
			helper(s, i, i + 1);
		}
		return s.substring(start, start + max);
	}

	private static void helper(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		i++; // at this time, i is out boundary
		if (j - i > max) {
            start = i;
            max = j - i;
        }
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abacdfgdcaba").toString());
		System.out.println(longestPalindrome2("bb").toString());
		System.out.println(longestPalindrome("a").toString());
		System.out.println(longestPalindrome("babad").toString());
	}

}
