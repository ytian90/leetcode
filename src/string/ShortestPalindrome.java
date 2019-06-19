package string;
/**
 * 214. Shortest Palindrome
 * @author yutian
 * @since Dec 6, 2015
 */
public class ShortestPalindrome {

	// time O(N^2)
	public static String shortestPalindrome(String s) {
		if (s.length() < 2) return s;
		int end = helper(s);
		return new StringBuilder(s.substring(end + 1)).reverse() + s;
	}

	private static int helper(String s) {
		for (int i = s.length() - 1; i > 0; i--) {
			if (isPalindrome(s, i))
				return i;
		}
		return 0;
	}

	public static boolean isPalindrome(String s, int j) {
		if (s == null || s.length() == 0)
			return true;
		int i = 0;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(shortestPalindrome("abcd"));
		System.out.println(shortestPalindrome("abcda"));
		System.out.println(shortestPalindrome("aacecaaa"));
	}

	/*
	 * Method: Recursion
	 */
	public static String shortestPalindrome1(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
        	if (s.charAt(i) == s.charAt(j)) j++;
        }
        if (j == s.length()) {
        	return s;
        }
        String suffix = s.substring(j);
        return new StringBuilder(suffix).reverse().toString() + 
        		shortestPalindrome(s.substring(0, j)) + suffix;
    }
	
	public static String shortestPalindrome2(String s) {
		String temp = s + "#" + new StringBuilder(s).reverse().toString();
		int[] table = getTable(temp);
		
		// maxPerformance the maximum palindrome part in s starts from 0
		return new StringBuilder(s.substring(table[table.length - 1])).reverse().toString() + s;
	}

	private static int[] getTable(String s) {
		// maxPerformance lookup table
		int[] table = new int[s.length()];
		
		// pointer that points to matched char in prefix part
		int index = 0;
		// skip index 0, we will not match a string with itself
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(index) == s.charAt(i)) {
				// we can extend match in prefix and postfix
				table[i] = table[i - 1] + 1;
				index++;
			} else {
				// matched failed, try to match a shorter substring
				// by assigning index to table[i - 1], we will shorten the match string
				// length, and jump to the prefix part that we used to match postfix
				// ended at i - 1
				index = table[i - 1];
				
				while (index > 0 && s.charAt(index) != s.charAt(i)) {
					// we will try to shorten the match string length until we revert
					// to the beginning of match (index 1)
					index = table[index - 1];
				}
				
				// when we are here may either found a match char or we reach the boundary
				// and still no luck, so we need check char match
				if (s.charAt(index) == s.charAt(i)) {
					// if match, then extend one char
					index++;
				}
				table[i] = index;
			}
		}
		return table;
		
	}

}
