package hashtable;

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
		List<Integer> indexes = new ArrayList<>();
		if (s == null || s.length() == 0 || words.length == 0) {
			return indexes;
		}
		Map<String, Integer> counts = new HashMap<>();
		for (String word : words) {
			counts.put(word, counts.getOrDefault(word, 0) + 1);
		}
		int n = s.length(), num = words.length, len = words[0].length();
		for (int i = 0; i < n - num * len + 1; i++) {
			Map<String, Integer> seen = new HashMap<>();
			int j = 0;
			while (j < num) {
				String word = s.substring(i + j * len, i + (j + 1) * len);
				if (counts.containsKey(word)) {
					seen.put(word, seen.getOrDefault(word, 0) + 1);
					if (seen.get(word) > counts.getOrDefault(word, 0)) {
						break;
					}
				} else {
					break;
				}
				j++;
			}
			if (j == num) {
				indexes.add(i);
			}
		}
		return indexes;
	}

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = new String[]{"foo", "bar"};
		List<Integer> l = findSubstring(s, words);
		for (int i : l) System.out.print(i + " ");
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
