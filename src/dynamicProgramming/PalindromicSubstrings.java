package dynamicProgramming;
/**
 * 647. Palindromic Substrings
 * @author ytian
 *
 */
public class PalindromicSubstrings {
	
	static int count = 0;
	
	public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
        	helper(s, i, i);
        	helper(s, i, i + 1);
        }
        return count;
    }

	private static void helper(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			count++; i--; j++;
		}
	}

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
	}

}
