package company.lnkin.mj;

import leetcode.binaryTree.TreeNode;

/**
 * LC 951. Flip Equivalent Binary Tree
 *
 * For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.
 *
 * A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.
 *
 * Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivelent or false otherwise.
 *
 * Example 1:
 *
 * Flipped Trees Diagram
 *               1
 *             /  \
 *            2    3
 *           / \  /
 *          4  5  6
 *            / \
 *           7   8
 *
 *               1
 *             /  \
 *            3     2
 *             \   / \
 *             6  4   5
 *                   / \
 *                  8   7
 *
 * Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
 * Output: true
 * Explanation: We flipped at nodes with values 1, 3, and 5.
 * Example 2:
 *
 * Input: root1 = [], root2 = []
 * Output: true
 * Example 3:
 *
 * Input: root1 = [], root2 = [1]
 * Output: false
 * Example 4:
 *
 * Input: root1 = [0,null,1], root2 = []
 * Output: false
 * Example 5:
 *
 * Input: root1 = [0,null,1], root2 = [0,1]
 * Output: true
 */
public class FlipEquivalentBinaryTree {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) || flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
    /**
     * Time: O(N ^ 2)
     * Space: O(N ^ 2)
     */

    public boolean flipEquiv2(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        if ((root1.left != null ? root1.left.val : -1) != (root2.left != null ? root2.left.val : -1)) {
            TreeNode t = root1.left;
            root1.left = root1.right;
            root1.right = t;
        }
        return flipEquiv2(root1.left, root2.left) && flipEquiv2(root1.right, root2.right);
    }
    /**
     * Time: O(N)
     * Space: O(N)
     */
}
