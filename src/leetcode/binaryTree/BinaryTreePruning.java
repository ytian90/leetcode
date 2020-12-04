package leetcode.binaryTree;

import static leetcode.util.BTreePrinter.printTreeNode;

/**
 * 814. Binary Tree Pruning
 */
public class BinaryTreePruning {

    public static TreeNode pruneTree(TreeNode root) {
        return prune(root);
    }

    private static TreeNode prune(TreeNode node) {
        if (node == null) return null;
        node.left = prune(node.left);
        node.right = prune(node.right);
        /*
        if below is in front, below use case wouldn't be deleted
                    0
                   / \
                  0  0
         */
        if (node.val == 0 && node.left == null && node.right == null)
            return null;
        return node;
    }

    public static void main(String[] args) {
        TreeNode n0 = new TreeNode(1);
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(0);
        TreeNode n3 = new TreeNode(1);

        n0.right = n1; n1.left = n2; n1.right = n3;
        printTreeNode(pruneTree(n0));
    }
}
