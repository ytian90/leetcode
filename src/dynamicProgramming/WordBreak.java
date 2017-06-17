package dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * Word Break
 * @author yutian
 * @since Aug 23, 2015
 */
public class WordBreak {
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
		Set<String> d = new HashSet<>();
		d.add("leet"); d.add("code");
		System.out.println(wordBreak(s, d));
	}
	
}
