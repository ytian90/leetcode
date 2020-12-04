package leetcode.string;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 227. Basic Calculator II
 * @author yutian
 * @since Aug 29, 2015
 */
public class BasicCalculator2 {
	
	// Solution 3: Stack very fast
	public static int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int num = 0, n = s.length();
		char sign = '+';
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = 10 * num + c - '0';
			}
			if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
				if (sign == '+') stack.push(num);
				if (sign == '-') stack.push(-num);
				if (sign == '*') stack.push(stack.pop() * num);
				if (sign == '/') stack.push(stack.pop() / num);
				sign = c;
				num = 0;
			}
		}
		int res = 0;
		for (int i : stack) res += i;
		return res;
	}

	public static void main(String[] args) {
		System.out.println(calculate("1+2*3"));
	}

	// Solution 1: One pass through the tokens
	public int calculate1(String s) {
		StringTokenizer tokens = new StringTokenizer('+' + s.replace(" ", "") + "+0", "+-*/", true);
		long total = 0, term = 0;
		while (tokens.hasMoreTokens()) {
			String op = tokens.nextToken();
			if ("+-".contains(op)) {
				total += term;
				term = (op.equals("+") ? 1 : -1) * Long.parseLong(tokens.nextToken());
			} else {
				long n = Long.parseLong(tokens.nextToken());
				if (op.equals("*")) {
					term *= n;
				} else {
					term /= n;
				}
			}
		}
		return (int)total;
	}
	
	// Solution 2: Split the splits
	public int calculate2(String s) {
		int total = 0;
	    for (String t : s.replace(" ", "").split("(?=[+-])")) {
	        int term = 1;
	        for (String u : ('*' + t).split("(?=[*/])")) {
	            int n = Integer.parseInt(u.substring(1));
	            term = u.startsWith("*") ? term * n : term / n;
	        }
	        total += term;
	    }
	    return total;
	}
	
	
}
