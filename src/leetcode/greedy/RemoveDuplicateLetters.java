package leetcode.greedy;

import java.util.Stack;

/**
 * 316. Remove Duplicate Letters
 * @author yutian
 * @since Dec 14, 2015
 */
public class RemoveDuplicateLetters {

	public static String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		boolean[] visited = new boolean[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']--;
			if (visited[c - 'a']) {
				continue;
			}
			while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
				visited[stack.pop() - 'a'] = false;
			}
			stack.push(c);
			visited[c - 'a'] = true;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : stack) {
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters("bcabc"));
		System.out.println(removeDuplicateLetters("bcac"));
		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}

	public static String removeDuplicateLetters2(String s) {
		if (s.length() == 0) {
			return "";
		}
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos)) {
				pos = i;
			}
			if (--count[s.charAt(i) - 'a'] == 0) {
				break;
			}
		}
		return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll(s.charAt(pos) + "", ""));
	}



}
