package company.lnkin.mj;

import leetcode.binaryTree.TreeNode;

/**
 * LC 156. Binary Tree Upside Down
 *
 * Given the root of a binary tree, turn the tree upside down and return the new root.
 *
 * You can turn a binary tree upside down with the following steps:
 *
 * The original left child becomes the new root.
 * The original root becomes the new right child.
 * The original right child becomes the new left child.
 *          X                 X               Y
 *         / \               /               / \
 *        Y   Z             Y - Z           Z   X
 *
 * The mentioned steps are done level by level, it is guaranteed that every node in the given tree has either 0 or 2 children.
 *
 * Example 1:
 *              1                 1              4
 *             / \               /              / \
 *            2   3             2 - 3          5   2
 *           / \               /                  / \
 *          4   5             4 - 5              3   1
 *
 * Input: root = [1,2,3,4,5]
 * Output: [4,5,2,null,null,3,1]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode node = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return node;
    }

    public TreeNode upsideDownBinaryTree_iterative(TreeNode root) {
        TreeNode curr = root, next = null, prev = null, temp = null;
        while (curr != null) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
