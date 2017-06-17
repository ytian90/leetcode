package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 320. Generalized Abbreviation
 * @author yutian
 * @since Dec 28, 2015
 */
public class GeneralizedAbbreviation {
	
	// Solution 1: Backtracking 
	public static List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		helper(res, word, 0, "", 0);
		return res;
	}

	private static void helper(List<String> res, String word, int pos, String curr, int count) {
		if (pos == word.length()) {
			if (count > 0) curr += count;
			res.add(curr);
		} else {
			helper(res, word, pos + 1, curr, count + 1);
			helper(res, word, pos + 1, curr + ((count > 0) ? count : "") + word.charAt(pos), 0);
		}
	}
	
	// Solution 2: bit manipulation
	public static List<String> generateAbbreviations2(String word) {
		List<String> result = new ArrayList<>();
		int n = word.length();
		for (int m = 0; m < (1 << n); m++) {
			int count = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= n; i++) {
				if (((1 << i) & m) > 0) {
					count++;
				} else {
					if (count != 0) {
						sb.append(count);
						count = 0;
					}
					if (i < n) sb.append(word.charAt(i));
				}
			}
			result.add(sb.toString());
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(generateAbbreviations("word"));
	}

}
