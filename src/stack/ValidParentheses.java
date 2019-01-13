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
	public static boolean isValid(String s) {
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
	
	public static boolean isValid1(String str) {
		Stack<Character> s = new Stack<>();
		for (char c : str.toCharArray()) {
			if (c == '(') {
				s.push(')');
			} else if (c == '{') {
				s.push('}');
			} else if (c == '[') {
				s.push(']');
			} else if (s.isEmpty() || s.pop() != c) {
				return false;
			}
		}
		return s.isEmpty();
	}
	
	public static void main(String[] args) {
		System.out.println(isValid1("()"));
		System.out.println(isValid1("()[]{}"));
		System.out.println(isValid1("(]"));
		System.out.println(isValid1("([)]"));
		System.out.println(isValid1("()({[]}{})"));
		System.out.println(isValid1("()({[]}{)"));
	}
	
	// a little slow due to replace() 
	public static boolean isValid2(String s) {
		int length;
		do { 
			length = s.length();
			s = s.replace("()", "").replace("{}", "").replace("[]", "");
		} while (length != s.length());
		return s.length() == 0;
	}
	
	// Follow incr space O(1) only one kind of ( )
	public static boolean isValid9(String s) {
		int ch = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') ch++;
			if (c == ')') ch--;
			if (ch < 0) return false;
		}
		return ch == 0;
	}
}
