package leetcode.mj.airbnb;

import java.util.Stack;

/**
 * 5. Calculator
 * lc #224
 * lc #227
 */
public class Calculator {

    // 227 calculator II
    public static int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == n - 1) {
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(num * stack.pop());
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
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));

    }
}
