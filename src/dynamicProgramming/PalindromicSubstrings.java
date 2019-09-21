package dynamicProgramming;
/**
 * 647. Palindromic Substrings
 * @author ytian
 *
 */
public class PalindromicSubstrings {

	public static int countSubstrings(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			count += helper(s, i, i);
			count += helper(s, i, i + 1);
		}
		return count;
	}

	private static int helper(String s, int i, int j) {
		int c = 0;
		while (i >= 0 && j < s.length() && (s.charAt(i) == s.charAt(j))) {
			i--;
			j++;
			c++;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
	}

}
