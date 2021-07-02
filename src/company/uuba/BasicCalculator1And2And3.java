package company.uuba;

import java.util.*;

/**
 * LC 224. Basic Calculator
 * LC 227. Basic Calculator II
 * LC 772. Basic Calculator III
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, '+', '-', '*', '/' operators, and open '(' and closing parentheses ')'. The integer division should truncate toward zero.
 *
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 * Example 1:
 *
 * Input: s = "1+1"
 * Output: 2
 * Example 2:
 *
 * Input: s = "6-4/2"
 * Output: 4
 * Example 3:
 *
 * Input: s = "2*(5+5*2)/3+(6/2+8)"
 * Output: 21
 * Example 4:
 *
 * Input: s = "(2+6*3+5-(3*14/7+2)*5)+3"
 * Output: -12
 * Example 5:
 *
 * Input: s = "0"
 * Output: 0
 */
public class BasicCalculator1And2And3 {
    public static int calculate(String s) {
        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                q.add(c);
            }
        }
        q.add('+'); // put num inside
        return helper(q);
    }

    private static int helper(Queue<Character> q) {
        char prevOp = '+';
        int num = 0, sum = 0, prev = 0;
        while (!q.isEmpty()) {
            char c = q.poll();
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            } else if (c == '(') {
                num = helper(q);
            } else {
                if (prevOp == '+') {
                    sum += prev;
                    prev = num;
                } else if (prevOp == '-') {
                    sum += prev;
                    prev = -num;
                } else if (prevOp == '*') {
                    prev *= num;
                } else if (prevOp == '/') {
                    prev /= num;
                }
                if (c == ')') {
                    break;
                }
                prevOp = c;
                num = 0;
            }
        }
        return sum + prev;
    }

    public static void main(String[] args) {
        System.out.println(calculate("6-4/2"));
        System.out.println(calculate("2*(5+5*2)/3"));
    }

}
