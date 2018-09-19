package dfs_bfs;

import binaryTree.TreeNode;
import util.BTreePrinter;

/**
 * 897. Increasing Order Search Tree
 */
public class IncreasingOrderSearchTree {
    public static TreeNode increasingBST(TreeNode root) {
        return helper(root, null);
    }

    private static TreeNode helper(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = helper(root.left, root);
        root.left = null;
        root.right = helper(root.right, tail);
        return res;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(5);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(8);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(9);
        n0.left = n1; n0.right = n2;
        n1.left = n3; n1.right = n4;
        n2.right = n5;
        n3.left = n6; n5.left = n7; n5.right = n8;

        BTreePrinter.printTreeNode(increasingBST(n0));
    }
}
