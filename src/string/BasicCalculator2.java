package string;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Basic Calculator II
 * @author yutian
 * @since Aug 29, 2015
 */
public class BasicCalculator2 {
	
	// Solution 3: Stack very fast
	public static int calculate(String s) {
		int len = s.length();
		if (s == null || len == 0) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == len - 1) {
				if (sign == '-') stack.push(-num);
				if (sign == '+') stack.push(num);
				if (sign == '*') stack.push(stack.pop() * num);
				if (sign == '/') stack.push(stack.pop() / num);
				sign = s.charAt(i);
				num = 0;
			}
		}
		int result = 0;
		for (int i : stack) result += i;
		return result;
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
