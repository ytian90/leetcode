package leetcode.dfs_bfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 439. Ternary Expression Parser
 * @author ytian
 *
 */
public class TernaryExpressionParser {
	
	public static String parseTernary(String expression) {
		Deque<Character> stack = new LinkedList<>();
		for (int i = expression.length() - 1; i >= 0; i--) {
			char c = expression.charAt(i);
			if (!stack.isEmpty() && stack.peek() == '?') {
				stack.pop();
				char first = stack.pop();
				stack.pop();
				char second = stack.pop();
				if (c == 'T') stack.push(first);
				else stack.push(second);
			} else {
				stack.push(c);
			}
		}
		return String.valueOf(stack.peek());
    }

    public static String parseTernaryr(String expression) {
		while (expression.length() != 1) {
			int i = expression.lastIndexOf("?");
			char c;
			if (expression.charAt(i - 1) == 'T') {
				c = expression.charAt(i + 1);
			} else {
				c = expression.charAt(i + 3);
			}
			expression = expression.substring(0, i - 1) + c + expression.substring(i + 4);
		}
		return expression;
	}

	public static void main(String[] args) {
		System.out.println(parseTernary("T?2:3"));
		System.out.println(parseTernary("F?1:T?4:5"));
		System.out.println(parseTernaryr("T?T?F:5:3"));
	}

}
