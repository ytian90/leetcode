package backtracking;

import java.util.Stack;

/**
 * 856. Score of Parentheses
 */
public class ScoreOfParentheses {

    public static int scoreOfParentheses(String S) {
        int res = 0, layer = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') layer++; else layer--;
            if (S.charAt(i) == '(' && S.charAt(i + 1) == ')') {
                res += 1 << (layer - 1);

            }
        }
        return res;
    }

    public static int scoreOfParenthesses(String S) {
        Stack<Integer> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else {
                int curr = 0;
                while (stack.peek() != -1) {
                    curr += stack.pop();
                }
                stack.pop();
                stack.push(curr == 0 ? 1 : 2 * curr);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("(())"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("(()(()))"));
    }
}
