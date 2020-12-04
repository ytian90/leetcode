package leetcode.binaryTree;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllToStack(root);
    }

    private void pushAllToStack(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode p = node;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    public int next() {
        if (stack.isEmpty()) {
            return -1;
        }
        TreeNode curr = stack.pop();
        if (curr.right != null) {
            pushAllToStack(curr.right);
        }
        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
