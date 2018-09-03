package dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 * @author yutian
 * @since Aug 23, 2015
 */
public class WordBreak {
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		Set<String> dict = new HashSet(wordDict);

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && dict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
	
	public static boolean wordBreak(String s, Set<String> wordDict) {
		// d[i]: s[0..i-1] is breakable
		// d(i) = d(j) && s[j, i], j = 0..i - 1
		// Time ~ O(N^2), Space ~ O(N)
		int n = s.length();
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] == true && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		List<String> d = new ArrayList<>();
		d.add("leet"); d.add("code");
		System.out.println(wordBreak(s, d));
	}
	
}
