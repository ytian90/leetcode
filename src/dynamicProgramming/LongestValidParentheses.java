package dynamicProgramming;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 * @author yutian
 * @since Aug 18, 2015
 */
public class LongestValidParentheses {
	
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Stack<Integer> stack = new Stack<>();
		int i = -1, max = 0;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '(') {
				stack.push(j);
			} else {
				if (stack.isEmpty()) i = j;
				else {
					stack.pop();
					if (stack.isEmpty())
						max = Math.max(max, j - i);
					else
						max = Math.max(max, j - stack.peek());
				}
			}
		}
		return max;
	}
	
	public static int longestValidParentheses3(String s) {
		if (s.length() <= 1) return 0;
		int max = 0;
		int[] dp = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
					max = Math.max(max, dp[i]);
				} else { // if s.charAt(i - 1) is ')', combine the previous length
					int t = i - dp[i - 1] - 1; // magic number
					if (t >= 0 && s.charAt(t) == '(') {
						dp[i] = dp[i - 1] + 2 + (t >= 1 ? dp[t - 1] : 0);
						max = Math.max(max, dp[i]);
					}
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("(()"));
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses("()"));
		System.out.println(longestValidParentheses("("));
		System.out.println(longestValidParentheses(")"));
		System.out.println(longestValidParentheses("()())"));
	}
	
	public static int longestValidParentheses2(String s) {
		// d(i): length of the longest valid parentheses starting from s[i], i = N - 1...0
		// d(i) = 0 if s[i] == ')'
		// d(i) = d(i+1) + 2 + d(i+1+d(i+1)+1) if s[i] == '(' and s[i+1+d(i+1)] == ')'
		int n = s.length();
		if (n < 2) return 0;
		int max = 0;
		int[] d = new int[n];
		d[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				int j = i + 1 + d[i + 1];
				if (j < n && s.charAt(j) == ')') {
					d[i] = d[i + 1] + 2;
					if (j + 1 < n)
						d[i] += d[j + 1];
				}
			}
			max = Math.max(max, d[i]);
		}
		return max;
	}
	
}
