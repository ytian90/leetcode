package dynamicProgramming;
/**
 * 44. Wildcard Matching
 * @author yutian
 * @since Sep 2, 2015
 */
public class WildcardMatching {
	
	public boolean isMatch(String s, String p) {
		int i = 0, j = 0, start = -1, match = 0;
		while (i < s.length()) {
			// advance both pointers
			if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
				i++; j++;
			// * found, only advance pattern pointer
			} else if (j < p.length() && p.charAt(j) == '*') {
				start = j;
				match = i;
				j++;
			// last pattern pointer was *, advance string pointer
			} else if (start != -1) {
				j = start + 1;
				match++;
				i = match;
			// current pattern is not *, last pattern pointer is not *, characters do not match
			} else {
				return false;
			}
		}
		// check for the remaining characters in pattern
		while (j < p.length() && p.charAt(j) == '*') j++;
		return j == p.length();
	}

	public static void main(String[] args) {
		WildcardMatching t = new WildcardMatching();
		System.out.println(t.isMatch("aa", "a"));
		System.out.println(t.isMatch("aa", "aa"));
		System.out.println(t.isMatch("aaa", "aa"));
		System.out.println(t.isMatch("aa", "*"));
		System.out.println(t.isMatch("aa", "a*"));
		System.out.println(t.isMatch("ab", "?*"));
		System.out.println(t.isMatch("aab", "c*a*b"));
		System.out.println(t.isMatch("", "*"));
	}
	
	// Solution 1
	public boolean isMatch1(String s, String p) {
		int m = 0, n = 0, match = 0, startIdx = -1;
		while (m < s.length()) {
			// advance both pointers
			if (n < p.length() && (p.charAt(n) == '?' || s.charAt(m) == p.charAt(n))) {
				m++;
				n++;
			} else if (n < p.length() && p.charAt(n) == '*') {
				// found, only advancing p pointer
				startIdx = n;
				match = m;
				n++;
			} else if (startIdx != -1) {
				// last p pointer was *, advancing string pointer
				n = startIdx + 1;
				match++;
				m = match;
			}
			// current p pointer is not star, last p point was not * characters not match
			else return false;
		}
		
		// check for remaining characters in p
		while (n < p.length() && p.charAt(n) == '*') n++;
		return n == p.length();
	}
	
	// Solution 2
	public boolean isMatch2(String s, String p) {
		int m = s.length(), n = p.length();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (p.charAt(i) == '*') count++; // sort * in p
		}
		if (count == 0 && m != n) return false;
		else if (n - count > m) return false;
		
		boolean[] match = new boolean[m + 1];
		match[0] = true;
		for (int i = 0; i < n; i++) {
			if (p.charAt(i) == '*') {
				for (int j = 0; j < m; j++) {
					match[j + 1] = match[j] || match[j + 1];
				}
			} else {
				for (int j = m - 1; j >= 0; j--) {
					match[j + 1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && match[j];
				}
				match[0] = false;
			}
		}
		return match[m];
	}

}
