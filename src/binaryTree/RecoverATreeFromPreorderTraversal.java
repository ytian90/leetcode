package binaryTree;

import java.util.Stack;

/**
 * 1028. Recover a Tree From Preorder Traversal
 */
public class RecoverATreeFromPreorderTraversal {

    private static final char dash = '-';

    public static TreeNode recoverFromPreorder(String S) {
        int level, val;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < S.length(); ) {
            for (level = 0; S.charAt(i) == dash; i++) {
                level++;
            }
            for (val = 0; i < S.length() && S.charAt(i) != dash; i++) {
                val = 10 * val + (S.charAt(i) - '0');
            }
            while (stack.size() > level) {
                stack.pop();
            }
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(recoverFromPreorder("1-2--3---4-5--6---7"));
    }
}
