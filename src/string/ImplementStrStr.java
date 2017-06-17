package string;
/**
 * 28. Implement strstr()
 * @author yutian
 * @since Jul 24, 2015
 */
public class ImplementStrStr {
	
	// Brute Time Complexity O(n^2)
	public static int strStr(String haystack, String needle) {
		for (int i = 0; ; i++) {
			for (int j = 0; ; j++) {
				if (j == needle.length()) return i; // match
				if (i + j == haystack.length()) return -1; // over the end
				if (needle.charAt(j) != haystack.charAt(j + i)) break; // check next i
			}
		}
	}
	
	// KMP Algorithm
	public static int strStr2(String haystack, String needle) {
		if (needle.length() == 0) return 0;
		if (haystack.length() == 0) return -1;
		int[] pattan = prefix_function(needle);
		int start = 0, i = 0, j = 0;
		while (i != haystack.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++; j++;
			} else {
				if (j == 0) {
					start++; i++;
				} else {
					start = start + j - pattan[j - 1];
					i = start + pattan[j - 1];
					j = pattan[j - 1];
				}
			}
			if (j == needle.length()) {
				return start;
			}
		}
		return -1;
	}

	private static int[] prefix_function(String s) {
		int[] result = new int[s.length()];
		for (int i = 1; i < result.length; i++) {
			if (s.charAt(i) == s.charAt(result[i - 1]))
				result[i] = result[i - 1] + 1;
		}
		return result;
		
	}

	public static void main(String[] args) {
		String h1 = "aaaba", n1 = "ba";
		String h2 = "mississippi", n2 = "issi";
		
		System.out.println(strStr(h1, n1));
//		System.out.println(strStr(h2, n2));
	}

}
