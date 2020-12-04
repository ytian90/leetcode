package leetcode.string;

import java.util.HashSet;

/**
 * Find all palindromes in a leetcode.string
 * @author yutian
 * @since Jan 28, 2016
 */
public class FindAllPalindromes {
	
	private static HashSet<String> result = new HashSet<>();
	
	public int find(String s) {
		int len = s.length();
		if (len < 2) {
			result.add(s);
			return 1;
		}
		for (int i = 0; i < len; i++) {
			expand(s, i, i);
			expand(s, i, i + 1);
		}
		return result.size();
	}

	private void expand(String s, int j, int k) {
		while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
//			if (j != k) { // if we don't want single char add this line
				result.add(s.substring(j, k + 1));
//			}
			j--; k++;
		}
	}

	public static void main(String[] args) {
		FindAllPalindromes t = new FindAllPalindromes();
		System.out.println(t.find("aabaa"));
		System.out.println(t.result);
		
	}

}
