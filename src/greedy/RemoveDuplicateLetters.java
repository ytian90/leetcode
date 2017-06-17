package greedy;

import java.util.Stack;

/**
 * Remove Duplicate Letters
 * @author yutian
 * @since Dec 14, 2015
 */
public class RemoveDuplicateLetters {
	
	public static String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) < s.charAt(pos)) pos = i;
        	if (--count[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + 
        		removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
	
	public static String removeDuplicateLetters2(String s) {
		if (s == null || s.length() == 0) return "";
		Stack<Character> stack = new Stack<>();
		int[] count = new int[26];
		boolean[] isExisted = new boolean[26];
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			count[ch[i] - 'a']++;
		}
		for (Character c: ch) {
			count[c - 'a']--;
			if (isExisted[c - 'a']) continue;
			while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] != 0) {
				isExisted[stack.pop() - 'a'] = false;
			}
			stack.push(c);
			isExisted[c - 'a'] = true;
		}
		StringBuffer sb = new StringBuffer();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters2("cbacdcbc"));
	}

}
