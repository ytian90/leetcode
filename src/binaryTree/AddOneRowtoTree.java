package binaryTree;

import util.BTreePrinter;

/**
 * 623. Add One Row to Tree
 * @author ytian
 *
 */
public class AddOneRowtoTree {
	
	public static TreeNode addOneRow(TreeNode root, int v, int d) {
        return helper(root, v, d, 1, 0);
    }
	
	private static TreeNode helper(TreeNode node, int v, int d, int level, int dir) {
		if (node == null) return null;
		if (d == level) {
			TreeNode nn = new TreeNode(v);
			if (dir == 0) {
				nn.left = helper(node, v, d, level + 1, 0);
			} else {
				nn.right = helper(node, v, d, level + 1, 1);
			}
			return nn;
		}
		node.left = helper(node.left, v, d, level + 1, 0);
		node.right = helper(node.right, v, d, level + 1, 1);
		return node;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(6);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(5);
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;
		n3.left = n6;
		
		BTreePrinter.printTreeNode(addOneRow(n1, 1, 2));
		
		TreeNode n7 = new TreeNode(4);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(3);
		TreeNode n0 = new TreeNode(1);
		n7.left = n8; n8.left = n9; n8.right = n0;
		
		BTreePrinter.printTreeNode(addOneRow(n7, 1, 3));
		
	}

}
