package binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 545. Boundary of Binary Tree
 * @author ytian
 *
 */
public class BoundaryOfBinaryTree {
	
	List<Integer> nodes = new ArrayList<>(1000);
	
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return nodes;
        nodes.add(root.val);
        left(root.left);
        leaves(root.left);
        leaves(root.right);
        right(root.right);
        return nodes;
    }
	
	private void left(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) return;
		nodes.add(root.val);
		if (root.left == null) left(root.right);
		else left(root.left);
	}

	private void right(TreeNode root) {
		if (root == null || (root.right == null && root.left == null)) return;
		if (root.right == null) right(root.left);
		else right(root.right);
		nodes.add(root.val);
	}

	private void leaves(TreeNode root) {
		if (root == null) return;
		if (root.left == null && root.right == null) {
			nodes.add(root.val);
			return;
		}
		leaves(root.left);
		leaves(root.right);
	}

	
	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		
		n0.right = n1; n1.left = n2; n1.right = n3;
		
		BoundaryOfBinaryTree t = new BoundaryOfBinaryTree();
		System.out.println(t.boundaryOfBinaryTree(n0));
		
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(4);
		TreeNode n8 = new TreeNode(5);
		TreeNode n9 = new TreeNode(6);
		TreeNode n10 = new TreeNode(7);
		TreeNode n11 = new TreeNode(8);
		TreeNode n12 = new TreeNode(9);
		TreeNode n13 = new TreeNode(10);
		
		n4.left = n5; n4.right = n6; n5.left = n7; n5.right = n8;
		n8.left = n10; n8.right = n11; n6.left = n9; n9.left = n12; n9.right = n13;
		
		BoundaryOfBinaryTree tt = new BoundaryOfBinaryTree();
		System.out.println(tt.boundaryOfBinaryTree(n4));
		
	}

}
