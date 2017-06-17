package string;
/**
 * Palindrome Partitioning II
 * @author yutian
 * @since Aug 23, 2015
 */
public class PalindromePartitioning2 {
	public int minCut(String s) {
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
	
	public static void main(String[] args) {
		PalindromePartitioning2 t = new PalindromePartitioning2();
		System.out.println(t.minCut("aab"));
	}
}
