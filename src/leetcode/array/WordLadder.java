package leetcode.array;

import java.util.*;

/**
 * 127. Word Ladder
 * @author yutian
 * @since Aug 22, 2015
 */
public class WordLadder {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		Set<String> reached = new HashSet<>();
		if (!dict.contains(endWord)) {
			return 0;
		}
		reached.add(beginWord);
		int res = 1, n = beginWord.length();

		while (!reached.contains(endWord)) {
			Set<String> next = new HashSet<>();
			for (String s : reached) {
				for (int i = 0; i < n; i++) {
					char[] chars = s.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						chars[i] = c;
						String newStr = new String(chars);
						if (dict.contains(newStr)) {
							next.add(newStr);
							dict.remove(newStr);
						}
					}
				}
			}
			res++;
			if (next.size() == 0) {
				return 0;
			}
			reached = next;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
	}

	public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String curr = q.remove();
				if (curr.equals(endWord)) return level + 1;
				for (int j = 0; j < curr.length(); j++) {
					char[] chars = curr.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						chars[j] = c;
						String newStr = new String(chars);
						if (!newStr.equals(curr) && dict.contains(newStr)) {
							q.add(newStr);
							dict.remove(newStr);
						}
					}
				}
			}
			level++;
		}
		return 0;
	}

	public static int ladderLength1(String start, String end, Set<String> dict) {
		// Use queue to do BFS
		Queue<String> q = new LinkedList<>();
		q.add(start);
		q.add(null);
		
		// Mark visited word
		Set<String> visited = new HashSet<String>();
		visited.add(start);
		
		int level = 1;
		
		while (!q.isEmpty()) {
			String str = q.poll();
			
			if (str != null) {
				// Modify str's each char
				for (int i = 0; i < str.length(); i++) {
					char[] arr = str.toCharArray();
					
					for (char c = 'a'; c <= 'z'; c++) {
						arr[i] = c;
						String word = new String(arr);
						// Found the end word
						if (word.equals(end)) return level + 1;
						// Put it to the queue
						if (dict.contains(word) && !visited.contains(word)) {
							q.add(word);
							visited.add(word);
						}
					}
				}
			} else {
				level++;
				if (!q.isEmpty()) {
					q.add(null);
				}
			}
		}
		
		return 0;
	}
	
	public static int ladderLength2(String start, String end, Set<String> dict) {
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		int len = 1;
		HashSet<String> visited = new HashSet<>();
		
		beginSet.add(start);
		endSet.add(end);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			// switch two beginSet and endSet
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}
			
			Set<String> set = new HashSet<>();
			for (String word : beginSet) {
				char[] chars = word.toCharArray();
				for (int i = 0; i < chars.length; i++) {
					for (char c = 'a'; c <= 'z'; c++) {
						char ori = chars[i];
						chars[i] = c;
						String target = new String(chars);
						if (endSet.contains(target)) {
							return len + 1;
						}
						if (!visited.contains(target) && dict.contains(target)) {
							set.add(target);
							visited.add(target);
						}
						chars[i] = ori;
					}
				}
			}
			beginSet = set;
			len++;
		}
		
		return 0;
	}
}
