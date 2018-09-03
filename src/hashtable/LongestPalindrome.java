package hashtable;

import java.util.HashSet;

/**
 * 409. Longest Palindrome
 * @author yutian
 *
 */
public class LongestPalindrome {
	
	public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (Character c : s.toCharArray()) {
        	if (set.contains(c)) {
        		set.remove(c);
        		count++;
        	} else {
        		set.add(c);
        	}
        }
        return (set.isEmpty()) ? count * 2 : count * 2 + 1;
    }

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abccccdd"));
	}

}
