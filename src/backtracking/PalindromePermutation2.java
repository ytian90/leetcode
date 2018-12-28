package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 267. Palindrome Permutation 2
 * @author yutian
 * @since Jan 16, 2016
 */
public class PalindromePermutation2 {

	public static List<String> generatePalindromes3(String s) {
		int odd = 0;
		String mid = "";
		List<String> res = new ArrayList<>();
		List<Character> list = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int value : map.values()) {
			if (value % 2 != 0) odd++;
		}
		if (odd > 1) return res;
		for (Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int val = entry.getValue();
			if (val % 2 != 0) mid += key;
			for (int i = 0; i < val / 2; i++)
				list.add(key);
		}
		helper(list, mid, new boolean[list.size()], new StringBuilder(), res);
		return res;
	}

	public static void helper(List<Character> list, String mid, boolean[] visited, StringBuilder sb, List<String> res) {
		if (sb.length() == list.size()) {
			res.add(sb.toString() + mid + sb.reverse().toString());
			sb.reverse();
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && list.get(i - 1) == list.get(i) && !visited[i - 1]) continue;
			if (!visited[i]) {
				visited[i] = true;
				sb.append(list.get(i));
				helper(list, mid, visited, sb, res);
				visited[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	public static void main(String[] args) {
//		System.out.println(generatePalindromes("aabb"));
//		System.out.println(generatePalindromes("abc"));
		System.out.println(generatePalindromes3("aaaaa"));
	}
	
	public static List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        // build character count map and count odds
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	map.put(c, map.containsKey(c) ? map.get(c) + 1: 1);
        	odd += map.get(c) % 2 != 0 ? 1: -1;
        }
        // can't form any palindromic string
        if (odd > 1) return res;
        // add half count of each character to list
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
        	char key = entry.getKey();
        	int val = entry.getValue();
        	if (val % 2 != 0) mid += key;
        	for (int i = 0; i < val / 2; i++) list.add(key);
        }
        // generate all the permutations
        getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);
        return res;
    }

	private static void getPerm(List<Character> list, String mid, boolean[] used,
			StringBuilder sb, List<String> result) {
		if (sb.length() == list.size()) {
			// form the palindromic string
			result.add(sb.toString() + mid + sb.reverse().toString());
			sb.reverse();
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			// avoid duplication
			if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
			if (!used[i]) {
				used[i] = true;
				sb.append(list.get(i));
				// recursion
				getPerm(list, mid, used, sb, result);
				// backtracking
				used[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

}
