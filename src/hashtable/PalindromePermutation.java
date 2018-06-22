package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 266. Palindrome Permutation
 * @author yutian
 * @since Dec 27, 2015
 */
public class PalindromePermutation {
	
	public static boolean canPermutePalindrome(String s) {
        if (s == null) return true;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i : map.values()) {
            if (i % 2 != 0) count++;
            if (count > 1) return false;
        }
        return (count < 2) ? true: false;
    }

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("code"));
		System.out.println(canPermutePalindrome("aab"));
		System.out.println(canPermutePalindrome("carerac"));
        System.out.println(canPermutePalindrome("Tact Coa"));
	}

}
