package leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 140. Word Break II
 * @author yutian
 * @since Aug 23, 2015
 */
public class WordBreak2 {

	public List<String> wordBreak(String s, List<String> wordDict) {
		return helper(s, wordDict, new HashMap<>());
	}

	public List<String> helper(String s, List<String> dict, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		List<String> res = new ArrayList<>();
		if (s.length() == 0) {
			res.add("");
			return res;
		}
		for (String word : dict) {
			if (s.startsWith(word)) {
				List<String> subList = helper(s.substring(word.length()), dict, map);
				for (String sub : subList) {
					res.add(word + (sub.isEmpty() ? "" : " ") + sub);
				}
			}
		}
		map.put(s, res);
		return res;
	}

	public static void main(String[] args) {
		WordBreak2 t = new WordBreak2();
		List<String> dict = new ArrayList<>();
		dict.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		System.out.println(t.wordBreak("catsanddog", dict));
	}

	// Solution 1
	public List<String> wordBreak(String s, Set<String> wordDict) {
		int n = s.length();
		boolean[] d = new boolean[n + 1];
		d[0] = true;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				d[i] = d[j] && wordDict.contains(s.substring(j, i));
				if (d[i]) break;
			}
		}
		List<String> listSet = new ArrayList<>();
		if (d[n]) dfs(s, 0, wordDict, new StringBuilder(), listSet);
		return listSet;
	}

	// DFS
	private void dfs(String s, int j, Set<String> dict,
			StringBuilder str, List<String> listSet) {
		if (j == s.length()) {
			listSet.add(str.toString());
		} else {
			for (int i = j + 1; i <= s.length(); i++) {
				if (dict.contains(s.substring(j, i))) {
					int len = str.length();
					if (len != 0) str.append(" ");
					str.append(s.substring(j, i));
					dfs(s, i, dict, str, listSet);
					str.delete(len, str.length());
				}
			}
		}
	}

	// Solution 2
	public List<String> wordBreak2(String s, Set<String> dict) {
		// d[i] = true iff s[0..i-1] is breakable
		// d[i] = d[j] && s[j..i] j = 0..i - 1
		int n = s.length();
		boolean[] f = new boolean[n + 1];
		f[0] = true;
		
		// sub[i][j] = true iff s[j..i-1] in dict, i = 1..N, j = 0..i-1
		boolean[][] sub = new boolean[n + 1][n];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] == true && dict.contains(s.substring(j, i))) {
					f[i] = true;
					sub[i][j] = true;
				}
			}
		}
		List<String> set = new ArrayList<>();
		if (f[s.length()] == true) {
			findPath(s, sub, 0, new StringBuilder(), set);
		}
		return set;
	}

	private void findPath(String s, boolean[][] sub, int j,
			StringBuilder str, List<String> set) {
		if (j == s.length()) {
			set.add(str.toString());
		} else {
			for (int i = j + 1; i <= s.length(); i++) {
				if (sub[i][j] == true) {
					int len = str.length();
					if (str.length() != 0) str.append(" ");
					str.append(s.substring(j, i));
					findPath(s, sub, i, str, set);
					str.delete(len, str.length());
				}
			}
		}
	}
	
	// Solution 3
	public List<String> wordBreak3(String s, Set<String> dict) {
		int n = s.length();
		// DP: create a tab to check if a substring
		boolean[] f = new boolean[n + 1];
		f[0] = true;
		boolean[][] sub = new boolean[n + 1][n];
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] == true && dict.contains(s.substring(j, i))) {
					f[i] = true; // f[i] = true iff s[0..i-1] is breakable, f[i] = f[j] && s[j..i]
					sub[i][j] = true; // sub[i][j] = true iff s[j..i-1] \in dict
				}
			}
		}
		if (f[n] != true)
			return new ArrayList<String>(); // skip DFS if the leetcode.string is not breakable!!
		// DP: find all partitions
		Map<Integer, List<String>> map = new HashMap<>(); // map.maxPerformance(i) is all partitions of s[0, i - 1]
		for (int i = 1; i <= n; i++) {
			List<String> partition = new ArrayList<>(); // all partitions of s[0, i - 1]
			for (int j = 0; j < i; j++) {
				if (f[j] && sub[i][j]) { // s[0, j - 1] is breakable and s[j, i - 1] \ in dict
					if (j == 0) {
						StringBuilder str = new StringBuilder();
						str.append(s.substring(j, i));
						partition.add(str.toString());
					} else {
						for (String strPartition: map.get(j)) {
							StringBuilder str = new StringBuilder();
							str.append(strPartition);
							str.append(" ");
							str.append(s.substring(j, i));
							partition.add(str.toString());
						}
					}
				}
			}
			if (!partition.isEmpty()) map.put(i, partition);
		}
		if (map.containsKey(n)) return map.get(n);
		else return new ArrayList<String>();
	}
	
}
