package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 224. Basic Calculator
 * @author yutian
 * @since Aug 11, 2015
 */
public class BasicCalculator {
	// Solution 1
	public int calculate(String s) {
		// ignore parentheses to calculate
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(1);
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = c - '0';
				int j = i + 1;
				while (j < s.length() && Character.isDigit(s.charAt(j))) {
					num = num * 10 + s.charAt(j) - '0';
					j++;
				}
				i = j - 1;
				res += stack.pop() * num;
			} else if (c == '+' || c == '(') {
				stack.push(stack.peek());
			} else if (c == '-') {
				stack.push(-1 * stack.peek());
			} else if (c == ')') {
				stack.pop();
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		BasicCalculator t = new BasicCalculator();
		System.out.println(t.calculate("1 + 1"));
		System.out.println(t.calculate("2 - (12 + 3)"));
	}
	
	// Solution 2
	public int calculate2(String s) {
		Deque<Integer> stack = new LinkedList<>();
		int rs = 0;
		int sign = 1;
		stack.push(1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') continue;
			else if (s.charAt(i) == '(') {
				stack.push(stack.peekFirst() * sign);
				sign = 1;
			}
			else if (s.charAt(i) == ')') stack.pop();
			else if (s.charAt(i) == '+') sign = 1;
			else if (s.charAt(i) == '-') sign = -1;
			else {
				int temp = s.charAt(i) - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
					temp = temp * 10 + s.charAt(++i) - '0';
				rs += sign * stack.peekFirst() * temp;
			}
		}
		return rs;
	}
}
