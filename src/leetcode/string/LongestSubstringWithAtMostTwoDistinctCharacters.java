package leetcode.string;
/**
 * Longest Substring with At Most Two Distinct Characters
 * @author yutian
 * @since Jul 25, 2015
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
	
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		int i = 0, j = -1, maxLen = 0;
		for (int k = 1; k < s.length(); k++) {
			if (s.charAt(k) == s.charAt(k - 1)) continue;
			if (j >= 0 && s.charAt(j) != s.charAt(k)) {
				maxLen = Math.max(k - i, maxLen);
				i = j + 1;
			}
			j = k - 1;
		}
		return Math.max(s.length() - i, maxLen);
	}
	
	public int lengthOfLongestSubstringTwoDistinct2(String s) {
		int[] count = new int [256];
		int i = 0, numDistinct = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (count[s.charAt(j)] == 0) numDistinct++;
			count[s.charAt(j)]++;
			while (numDistinct > 2) {
				count[s.charAt(i)]--;
				if (count[s.charAt(i)] == 0) numDistinct--;
				i++;
			}
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String s = "eceba";
		System.out.println(lengthOfLongestSubstringTwoDistinct(s));
	}

}
