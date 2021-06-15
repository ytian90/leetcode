package company.lnkin.mj;

import leetcode.binaryTree.TreeNode;

/**
 * LC 104. Maximum Depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

}
