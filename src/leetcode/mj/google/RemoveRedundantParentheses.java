package leetcode.mj.google;

import java.util.Stack;

/**
 * - valid parentheses leetcode.string
 * - given a valid parentese leetcode.string, return the leetcode.string without redundant parentheses;
 * ((ab)) -> (ab)
 * (ab(x)) -> (ab(x)) (there is no redundant)
 * 一开始给了个算法接近面试官想要的,但是有点差别.
 * 后来在他提示下给出了他想要的解法.
 * 基本思路就是用个 stk 存所有的 ( 位置, 然后遇上 ) 之后, 检查当前 ) 的位置 和上一个 ) 的位置之差, 以及当前 ( 的位置和 上一个( 的位置之差,是不是都是 1,
 * 代表 (( )), 然后把 redundant 的() 标记成**, 最后输出 result removed *
 */
public class RemoveRedundantParentheses {
    public static String removeRedundantParentheses(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int prevRightParenPos = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (prevRightParenPos != -1) {
                    int prevLeftParenPos = -1;
                    if (stack.size() >= 2) {
                        int temp = stack.pop();
                        prevLeftParenPos = stack.peek();
                        stack.push(temp);
                    }
                    if (prevLeftParenPos != -1 && i - prevRightParenPos == 1 && stack.peek() - prevLeftParenPos == 1) {
                        int currLeft = stack.pop();
                        chars[currLeft] = '*';
                        chars[prevRightParenPos] = '*';
                    }
                }
                prevRightParenPos = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == '*') continue;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeRedundantParentheses("((ab))"));
        System.out.println(removeRedundantParentheses("(((ab)))"));
        System.out.println(removeRedundantParentheses("(((ab)c)d)"));
        System.out.println(removeRedundantParentheses("(((((ab))c)d))"));
    }
}
