package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 567. Permutation in String
 * @author ytian
 *
 */
public class PermutationinString {
	/*
	time: O(l1 + 26 * (l2 - l1))
	space: O(1)
	 */
	
	public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        
        int[] c = new int[26];
        for (int i = 0; i < len1; i++) {
        	c[s1.charAt(i) - 'a']++;
        	c[s2.charAt(i) - 'a']--;
        }
        if (helper(c)) return true;
        
        for (int i = len1; i < len2; i++) {
        	c[s2.charAt(i) - 'a']--;
        	c[s2.charAt(i - len1) - 'a']++;
        	if (helper(c)) return true;
        }
        return false;
    }

	private static boolean helper(int[] c) {
		for (int i = 0; i < c.length; i++) {
			if (c[i] != 0) return false;
		}
		return true;
	}

	// maxPerformance the locations of the substring
	// leetcode.cc189 page 70
	public static List<Integer> checkInclusion2(String s1, String s2) {
		List<Integer> res = new ArrayList<>();
		int len1 = s1.length(), len2 = s2.length();
		if (len1 > len2) return res;

		int[] c = new int[26];
		for (int i = 0; i < len1; i++) {
			c[s1.charAt(i) - 'a']++;
			c[s2.charAt(i) - 'a']--;
		}
		if (helper(c)) res.add(0);

		for (int i = len1; i < len2; i++) {
			c[s2.charAt(i) - 'a']--;
			c[s2.charAt(i - len1) - 'a']++;
			if (helper(c)) res.add(i - 2);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaoo"));
		System.out.println(checkInclusion2("abbc", "cbabadcbbabbcbabaabccbabc"));
	}

}
