package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 783. Minimum Distance Between BST Nodes
 */
public class MinimumDistanceBetweenBSTNodes {

    public static int minDiffInBST(TreeNode root) {
        Integer[] res = {Integer.MAX_VALUE, null};
        helper(root, res);
        return res[0];
    }

    private static void helper(TreeNode node, Integer[] res) {
        if (node == null) return;
        helper(node.left, res);
        if (res[1] != null) res[0] = Math.min(res[0], node.val - res[1]);
        res[1] = node.val;
        helper(node.right, res);
    }

    public static int minDiffInBSTs(TreeNode root) {
        int res = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode curr = root;
        Integer prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null) res = Math.min(res, curr.val - prev);
            prev = curr.val;
            curr = curr.right;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);

        n0.left = n1; n0.right = n2; n1.left = n3; n1.right = n4;
        System.out.println(minDiffInBST(n0));
    }

}
