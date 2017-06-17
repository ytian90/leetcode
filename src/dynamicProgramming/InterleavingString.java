package dynamicProgramming;
/**
 * Interleaving String
 * @author yutian
 * @since Nov 8, 2015
 */
public class InterleavingString {
	
	public boolean isInterleave(String s1, String s2, String s3) {
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

	public static void main(String[] args) {

	}

}
