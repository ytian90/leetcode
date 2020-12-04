package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 224. Basic Calculator
 * @author yutian
 * @since Aug 11, 2015
 */
public class BasicCalculator {

	public static int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		Queue<Character> q = new LinkedList<>();
		for (Character c : s.toCharArray()) {
			q.add(c);
		}
		q.offer('+');
		return helper(q);
	}

	public static int helper(Queue<Character> q) {
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		char sign = '+';
		while (!q.isEmpty()) {
			char c = q.poll();
			if (c == ' ') continue;
			if (Character.isDigit(c)) {
				num = 10 * num - c - '0';
			} else if (c == '(') {
				num = helper(q);
			} else {
				if (sign == '+') stack.push(num);
				if (sign == '-') stack.push(-num);
				num = 0;
				sign = c;
				if (c == ')') break;
			}
		}
		int res = 0;
		for (int i : stack) res += i;
		return res;
	}

	public static int calculate0(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int res = 0, sign = 1, n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = c - '0';
				while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
					num = 10 * num + (s.charAt(i + 1) - '0');
					i++;
				}
				res += num * sign;
			} else if (c == '+') {
				sign = 1;
			} else if (c == '-') {
				sign = -1;
			} else if (c == '(') {
				stack.push(res);
				stack.push(sign);
				res = 0;
				sign = 1;
			} else if (c == ')') {
				res = res * stack.pop() + stack.pop();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate("2 - (12 + 3)"));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	// Solution 1
	public int calculate1(String s) {
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
