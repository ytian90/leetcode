package leetcode.binaryTree;

import leetcode.util.BTreePrinter;

/**
 * 617. Merge Two Binary Tree
 * @author ytian
 *
 */
public class MergeTwoBinaryTrees {
	
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		if (t1 == null || t2 == null) {
			return t1 == null ? t2 : t1;
		}
		TreeNode root = new TreeNode(t1.val + t2.val);
		root.left = mergeTrees(t1.left, t2.left);
		root.right = mergeTrees(t1.right, t2.right);
		return root;
    }

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(5);
		n1.left = n2; n1.right = n3;
		n2.left = n4;
		
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(1);
		TreeNode n7 = new TreeNode(3);
		TreeNode n8 = new TreeNode(4);
		TreeNode n9 = new TreeNode(7);
		n5.left = n6; n5.right = n7;
		n6.right = n8;
		n7.right = n9;
		
		BTreePrinter.printTreeNode(mergeTrees(n1, n5));

	}

}
