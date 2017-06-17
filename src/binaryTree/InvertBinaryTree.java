package binaryTree;

import java.util.LinkedList;

/**
 * Invert Binary Tree
 * @author yutian
 * @since Aug 2, 2015
 */
public class InvertBinaryTree {
	
	// Solution 1: Recursive
	public static TreeNode invertTree(TreeNode root) {
		if (root != null) {
			helper(root);
		}
		return root;
	}

	private static void helper(TreeNode p) {
		TreeNode temp = p.left;
		p.left = p.right;
		p.right = temp;
		if (p.left != null) {
			helper(p.left);
		}
		if (p.right != null) {
			helper(p.right);
		}
	}
	
	// Solution 2: Iterative
	public static TreeNode invertTree2(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			if (p.left != null)
				queue.add(p.left);
			if (p.right != null)
				queue.add(p.right);
			
			TreeNode temp = p.left;
			p.left = p.right;
			p.right = temp;
		}
		return root;
	}
	
	/*
	 * 			4
	 * 		2		7
	 * 	   1 3     6 9
	 * to
	 * 			4
	 * 		7		2
	 * 	   9 6     3 1
	 */
	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(4);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(9);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		
//		printTree(n0);
		invertTree(n0);
		printTree(n0);
		
	}
	
	public static void printTree(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
		} else {
			return;
		}
		printTree(root.left);
		printTree(root.right);
	}
	
}
