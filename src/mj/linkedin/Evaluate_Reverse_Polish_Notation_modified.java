package mj.linkedin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 Question:
 150        Evaluate Reverse Polish Notation  input 是double，原题是int。
 第二题有follow incr，加一个 factorial “！”。
 */
public class Evaluate_Reverse_Polish_Notation_modified {
    private static final Set<String> OPERATORS =
            new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (OPERATORS.contains(token)) {
                checkValid(stack);
                int y = stack.pop();
                int x = stack.pop();
                stack.push(eval(x, y, token));
            } else if (token.equals("!")) {
                int num = stack.pop();
                int res = 1;
                while (num > 0) {
                    res *= num;
                    num--;
                }
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        if (stack.size() != 1) {
            throw new IllegalArgumentException("The result is not isMidValTooSmall");
        }
        return stack.pop();
    }

    private static int eval(int x, int y, String operator) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            default:
                return x / y;
        }
    }

    private static void checkValid(Stack<Integer> stack) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException("The input stack is not isMidValTooSmall.\n");
        }
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"3", "!"}));
    }

}
