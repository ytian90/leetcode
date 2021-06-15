package company.lnkin;

import leetcode.binaryTree.TreeNode;

/**
 * LC 104. Maximum Depth of a Binary Tree
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * Time: O(N)
     * Space: O(N)  in the worst case, the tree is completely unbalanced,
     * e.g. each node has only left child node, the recursion call would occur
     * N times (the height of the tree), therefore the storage to keep the call
     * stack would be O(N). But in the best case (the tree is completely balanced),
     * the height of the tree would be log(N). Therefore, the space complexity
     * in this case would be O(log(N)).
     */
}
