package stack;

import java.util.*;

/**
 * 772. Basic Calculator III
 */
public class BasicCalculator3 {

    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Queue<Character> q = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            q.offer(c);
        }
        q.offer('+');
        return helper(q);
    }

    private static int helper(Queue<Character> q) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        while (!q.isEmpty()) {
            char c = q.poll();
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            } else if (c == '(') {
                num = helper(q);
            } else {
                if (sign == '+') stack.push(num);
                else if (sign == '-') stack.push(-num);
                else if (sign == '*') stack.push(stack.pop() * num);
                else if (sign == '/') stack.push(stack.pop() / num);
                num = 0;
                sign = c;
                if (c == ')') break;
            }
        }
        int res = 0;
        for (int i : stack) res += i;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));
    }
}
