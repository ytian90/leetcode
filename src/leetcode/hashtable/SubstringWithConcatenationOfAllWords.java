package leetcode.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 * @author yutian
 * @since Oct 25, 2015
 */
public class SubstringWithConcatenationOfAllWords {

	// time O(n * m), space O(m)
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return res;
		}
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		int size = words[0].length(), n = words.length;
		for (int i = 0; i < s.length() - n * size + 1; i++) {
			Map<String, Integer> seen = new HashMap<>();
			// j counts the number of current words
			int j = 0;
			while (j < n) {
				String word = s.substring(i + j * size, i + (j + 1) * size);
				if (map.containsKey(word)) {
					seen.put(word, seen.getOrDefault(word, 0) + 1);
					// if seen count is larger than expect, break
					if (seen.get(word) > map.getOrDefault(word, 0)) {
						break;
					}
				} else {
					// if word is not expect, break
					break;
				}
				j++;
			}
			if (j == n) {
				res.add(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
	}

	/*
	 * Build a map for words in L and its relative counts
	 */
	public static List<Integer> findSubstring2(String s, String[] words) {
		
		List<Integer> list = new ArrayList<>();
		int len = words[0].length();
		if (s.length() == 0 || len == 0 || s.length() < len * words.length)
			return list;
		
		Map<String, Integer> map = new HashMap<>();
		for (String w : words) {
			map.put(w, map.getOrDefault(w, 0) + 1);
		}
		
		for (int i = 0; i < len; i++) {
			int count = 0, prev = i;
			Map<String, Integer> cmap = new HashMap<>();
			for (int j = i; j <= s.length() - len; j += len) {
				String cw = s.substring(j, j + len); // current word
				if (!map.containsKey(cw)) {
					count = 0;
					prev = j + len;
					cmap.clear();
				} else {
					cmap.put(cw, cmap.getOrDefault(cw, 0) + 1);
					if (cmap.get(cw) <= map.get(cw)) count++;
					else {
						while (cmap.get(cw) > map.get(cw)) {
							String pw = s.substring(prev, prev + len); // previous word
							cmap.put(pw, cmap.get(pw) - 1);
							if (cmap.get(pw) < map.get(pw)) count --;
							prev += len;
						}
					}
					if (count == words.length) {
						list.add(prev);
						String pw = s.substring(prev, prev + len); // previous word
						cmap.put(pw, cmap.get(pw) - 1);
						count--;
						prev += len;
					}
				}
			}
		}
		return list;
	}
}
