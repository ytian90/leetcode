package dynamicProgramming;
/**
 * 97. Interleaving String
 * @author yutian
 * @since Nov 8, 2015
 */
public class InterleavingString {

	public static boolean isInterleave(String s1, String s2, String s3) {
		char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
		int n = s1.length(), m = s2.length();
		if (n + m != s3.length()) return false;
		return helper(c1, c2, c3, 0, 0, 0, new boolean[n + 1][m + 1]);
	}

	public static boolean helper(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
		if (invalid[i][j]) return false;
		if (k == c3.length) return true;
		boolean valid =
				i < c1.length && c1[i] == c3[k] && helper(c1, c2, c3, i + 1, j, k + 1, invalid) ||
				j < c2.length && c2[j] == c3[k] && helper(c1, c2, c3, i, j + 1, k + 1, invalid);
		if (!valid) invalid[i][j] = true;
		return valid;
	}

	public static void main(String[] args) {
		System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}

	public static boolean isInterleave2(String s1, String s2, String s3) {
		int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
		if (n1 + n2 != n3) return false;
		boolean[][] match = new boolean[n1 + 1][n2 + 1];
		match[0][0] = true;
		// initialize the first row
		for (int i = 1; i <= n1; i++) {
			match[i][0] = match[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
		}
		// initialize the first column
		for (int j = 1; j <= n2; j++) {
			match[0][j] = match[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
		}
		
		// fill up match
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				match[i][j] = (match[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
						|| (match[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
			}
		}
		return match[n1][n2];
	}
}
