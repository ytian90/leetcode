package leetcode.mj.linkedin;

/**
 * Question : 1
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 *
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 *
 * The node has an extra attribute *parent* which point to the father of itself. The root's parent is null.
 *
 *
 * Solution：
 * so do it like intersection of two linkedlist
 */


import leetcode.binaryTree.TreeNode;

/**
 * Question : 2
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Return null if LCA does not exist.
 *
 * node A or node B may not exist in tree.
 *
 *
 * Solution：
 * so node A and node B may not exist in tree, so we need to detect the existance firstly, then adopt next step
 */
public class LCA_modified {

    // binary tree
    public static TreeNode lowestCommonAncestorBT(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorBT(root.left, p, q);
        TreeNode right = lowestCommonAncestorBT(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    // binary search tree
    public static TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        if (root.val < Math.min(p.val, q.val)) return lowestCommonAncestorBST(root.right, p, q);
        if (root.val > Math.max(p.val, q.val)) return lowestCommonAncestorBST(root.left, p, q);
        return root;
    }
}
