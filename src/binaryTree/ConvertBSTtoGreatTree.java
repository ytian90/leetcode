package binaryTree;

import util.BTreePrinter;

/**
 * 538. Convert BST to Great Tree
 */
public class ConvertBSTtoGreatTree {

    public static TreeNode convertBST(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return root;
    }

    public static void helper(TreeNode node, int[] res) {
        if (node == null) return;
        helper(node.right, res);
        node.val += res[0];
        res[0] = node.val;
        helper(node.left, res);
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(5);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(13);

        n0.left = n1; n0.right = n2;
        BTreePrinter.printTreeNode(convertBST(n0));
    }
}
