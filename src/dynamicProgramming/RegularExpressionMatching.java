package dynamicProgramming;

import java.util.Arrays;

/**
 * Regular Expression Matching
 * @author yutian
 * @since Oct 12, 2015
 * 
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
	
	public static void main(String[] args) {
//		System.out.println(isMatch("aa", "a"));
//		System.out.println(isMatch("aa", "aa"));
//		System.out.println(isMatch("aaa", "aa"));
//		System.out.println(isMatch("aa", "a*")); // mat[i - 1][j]
//		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
	}
	
	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) return s.equals(p);
        int m = s.length(), n = p.length();
        if (m == 0 && n == 0) return true;
        boolean[][] mat = new boolean[m + 1][n + 1];
        mat[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') { // * is deletion
                mat[0][j] = mat[0][j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    mat[i][j] = mat[i - 1][j - 1]; // same as last match
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                    	// repetition || same(1) || deletion(0)
                        mat[i][j] = mat[i - 1][j] || mat[i][j - 1] || mat[i][j - 2];
                    } else { // char before "*" don't match
                        mat[i][j] = mat[i][j - 2]; // deletion
                    }
                }
            }
        }
        return mat[m][n];
	}
}
