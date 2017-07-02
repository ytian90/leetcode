package hashTable;

import java.util.HashMap;

/**
 * 266. Palindrome Permutation
 * @author yutian
 * @since Dec 27, 2015
 */
public class PalindromePermutation {
	
	public static boolean canPermutePalindrome(String s) {
        if (s == null) return true;
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (Character c: s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i: map.values()) {
            if (i % 2 != 0) count++;
        }
        return (count < 2) ? true : false;
    }

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("code"));
		System.out.println(canPermutePalindrome("aab"));
		System.out.println(canPermutePalindrome("carerac"));
	}

}
