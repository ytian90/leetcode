package string;
/**
 * 132. Palindrome Partitioning II
 * @author yutian
 * @since Aug 23, 2015
 */
public class PalindromePartitioning2 {

	public static int minCut(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int n = s.length();
		char[] c = s.toCharArray();
		boolean[][] isPalindrome = new boolean[n][n];
		int[] cut = new int[n];
		for (int j = 0; j < n; j++) {
			int min = j;
			for (int i = 0; i <= j; i++) {
				if (c[i] == c[j] && (i + 1 > j - 1 || isPalindrome[i + 1][j - 1])) {
					isPalindrome[i][j] = true;
					min = i == 0 ? 0 : Math.min(min, cut[i - 1] + 1);
				}
			}
			cut[j] = min;
		}
		return cut[n - 1];
	}

	public static void main(String[] args) {
		System.out.println(minCut("aab"));
		System.out.println(minCut("cdd"));
	}

	public int minCut2(String s) {
		int n = s.length();
		boolean[][] tab = new boolean[n][n];
		int[] min = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			min[i] = n - i - 1;
			for (int j = i; j < n; j++) {
				tab[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || tab[i + 1][j - 1]);
				if (tab[i][j]) min[i] = Math.min(min[i], j + 1 < n ? (1 + min[j + 1]) : 0);
			}
		}
		return min[0];
	}

}
