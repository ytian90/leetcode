package leetcode.binaryTree;

import leetcode.util.BTreePrinter;

/**
 * 669. Trim a Binary Search Tree
 * @author ytian
 *
 */
public class TrimABinarySearchTree {
	
	public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(2);
		
		n0.left = n1; n0.right = n2;
		BTreePrinter.printTreeNode(trimBST(n0, 1, 2));
	}

}
