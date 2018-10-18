package stack;

import java.util.Stack;

/**
 * 921. Minimum Add to Make Parentheses Valid
 */
public class MinimumAddToMakeParenthesesValid {

    public static int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0)
            return 0;
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));
        System.out.println(minAddToMakeValid("((("));
        System.out.println(minAddToMakeValid("()"));
        System.out.println(minAddToMakeValid("()))(("));

    }
}
