package stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * @author yutian
 * @since Jul 30, 2015
 */
public class EvaluateReversePolishNotation {
	private static final Set<String> OPERATORS = 
			new HashSet<>(Arrays.asList("+", "-", "*", "/"));
	
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token : tokens) {
			if (OPERATORS.contains(token)) {
				int y = stack.pop();
				int x = stack.pop();
				stack.push(eval(x, y, token));
			} else {
				stack.push(Integer.valueOf(token));
			}
		}
		return stack.pop();
	}

	private int eval(int x, int y, String operator) {
		switch (operator) {
		case "+":
			return x + y;
		case "-":
			return x - y;
		case "*":
			return x * y;
		default:
			return x / y;
		}
	}
}
