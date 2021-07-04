package company.uuba;

import leetcode.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 * Example 1:
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int preorderIndex;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorderIndex = 0;
        this.map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int lo, int hi) {
        if (lo > hi) return null;
        int rootVal = preorder[preorderIndex++];
        TreeNode node = new TreeNode(rootVal);
        node.left = helper(preorder, lo, map.get(rootVal) - 1);
        node.right = helper(preorder, map.get(rootVal) + 1, hi);
        return node;
    }
    /**
     * Time: O(N)
     * Space: O(N)
     */
}
