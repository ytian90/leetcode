package leetcode.string;

import java.util.HashMap;

/**
 * String String Permutation
 * implement function strstrp(String a, String b) returns index where any permutation of b
 * is a substring of a.
 * e.g. 
 * strstrp("hello", "ell") return 1
 * strstrp("hello", "lle") return 1
 * strstrp("hello", "wor") return -1
 * @author yutian
 * @since Feb 2, 2016
 */
public class StrStrPermutation {
	// time ~O(Na + Nb)
	public static boolean strstrp(String a, String b) {
		int n = a.length(), m = b.length();
		if (n == 0 || m == 0 || n < m) return false;
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c: b.toCharArray()) {
			map.put(c, (map.containsKey(c) ? map.get(c) + 1: 1));
		}
		int prev = 0, count = 0, below = 0;
		for (int i = 0; i < n; i++) {
			// longer than length of b delete one
			if (i - prev + 1 > m) {
				char prevChar = a.charAt(prev);
				if (map.containsKey(prevChar)) {
					map.put(prevChar, map.get(prevChar) + 1);
					if (map.get(prevChar) > 0) {
						count--;
					} else {
						below--;
					}
				}
				prev++;
			}
			// add a new one
			char currChar = a.charAt(i);
			if (map.containsKey(currChar)) {
				map.put(currChar, map.get(currChar) - 1);
				if (map.get(currChar) >= 0) {
					count++;
				} else {
					below++;
				}
				if (count == m && below == 0) return true;
			}
			
		}
		return false;
	}
	
	// ~time O(Na * 26)
	public static boolean strstrp2(String a, String b) {
		int n = a.length(), m = b.length();
		if (n == 0 || m == 0 || n < m) return false;
		int[] map = new int[26];
		for (char c: b.toCharArray()) {
			map[c - 'a']++;
		}
		for (int i = 0; i < n - m + 1; i++) {
			if (map[a.charAt(i) - 'a'] == 0) continue;
			int[] map2 = new int[26];
			for (int j = i; j < i + m; j++) {
				map2[a.charAt(j) - 'a']++;
			}
			if (compare(map, map2)) {
				return true;
			}
		}
		return false;
	}

	private static boolean compare(int[] m, int[] n) {
		for (int i = 0; i < m.length; i++) {
			if (m[i] != n[i]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(strstrp("hello", "ell"));
		System.out.println(strstrp("hello", "lle"));
		System.out.println(strstrp("hello", "wor"));
		System.out.println(strstrp("hello", "elo"));
		System.out.println(strstrp("hellohello", "llh"));
		System.out.println(strstrp("hellohello", "heol"));
		System.out.println(strstrp("hellohello", "oho"));
		System.out.println(strstrp("afdgzyxksldfm", "xyz"));
	}

}
