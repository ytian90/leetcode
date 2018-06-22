package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

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

	private static void helper(TreeNode node) {
		TreeNode t = node.left;
		node.left = node.right;
		node.right = t;
		if (node.left != null) {
			helper(node.left);
		}
		if (node.right != null) {
			helper(node.right);
		}
	}
	
	// Solution 2: Iterative
	public static TreeNode invertTree2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		if (root == null) return null;
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			TreeNode t = curr.left;
			curr.left = curr.right;
			curr.right = t;
			if (curr.left != null) {
				q.add(curr.left);
			}
			if (curr.right != null) {
				q.add(curr.right);
			}
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
