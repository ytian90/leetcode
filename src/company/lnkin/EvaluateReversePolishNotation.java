package company.lnkin;

import java.util.Stack;

/**
 * LC 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                int num = stack.pop() + stack.pop();
                stack.push(num);
            } else if ("-".equals(s)) {
                int num = - stack.pop() + stack.pop();
                stack.push(num);
            } else if ("*".equals(s)) {
                int num = stack.pop() * stack.pop();
                stack.push(num);
            } else if ("/".equals(s)) {
                int a = stack.pop(), b = stack.pop();
                int num = b / a;
                stack.push(num);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
