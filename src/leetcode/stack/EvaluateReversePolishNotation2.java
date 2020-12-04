package leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation Solution 2
 * @author yutian
 * @since Jul 30, 2015
 */
public class EvaluateReversePolishNotation2 {
	interface Operator {
		int eval(int x, int y);
	}
	
	private static final Map<String, Operator> OPERATORS = new HashMap<String, Operator>() {{
		put("+", new Operator() {
			public int eval(int x, int y) { return x + y; }
		});
		put("-", new Operator() {
			public int eval(int x, int y) { return x - y; }
		});
		put("*", new Operator() {
			public int eval(int x, int y) { return x * y; }
		});
		put("/", new Operator() {
			public int eval(int x, int y) { return x / y; }
		});
	}};
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS.containsKey(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(OPERATORS.get(token).eval(x, y));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
}

