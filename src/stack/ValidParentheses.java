package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * @author yutian
 * @since Jul 30, 2015
 */
public class ValidParentheses {
	private static final Map<Character, Character> map = 
			new HashMap<Character, Character>() {{
				put('(', ')');
				put('{', '}');
				put('[', ']');
			}};
			
	// Solution 1 Stack
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				stack.push(c);
			} else if (stack.isEmpty() || map.get(stack.pop()) != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	public boolean isValid1(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(')');
			} else if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	// a little slow due to replace()
	public boolean isValid2(String s) {
		int length;
		do { 
			length = s.length();
			s = s.replace("()", "").replace("{}", "").replace("[]", "");
		} while (length != s.length());
		return s.length() == 0;
	}
	
	// Follow up space O(1) only one kind of ( )
	public boolean isValid9(String s) {
		int ch = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') ch++;
			if (c == ')') ch--;
			if (ch < 0) return false;
		}
		return ch == 0;
	}
}
