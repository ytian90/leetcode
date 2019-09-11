package binaryTree;

import java.util.*;

/**
 * 94. Binary Tree Inorder Traversal
 * @author yutian
 * @since Aug 17, 2015
 */
public class BinaryTreeInorderTraversal {

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(root, res);
		return res;
	}

	public static void helper(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}
		helper(node.left, res);
		res.add(node.val);
		helper(node.right, res);

	}

	public static List<Integer> inorderTraversal_iterative(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;

		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			res.add(node.val);
			node = node.right;
		}
		return res;
	}
	
	public static void main(String[] args) {

		TreeNode n0 = new TreeNode(1);
		n0.right = new TreeNode(2);
		n0.right.left = new TreeNode(3);
		System.out.println(inorderTraversal_iterative(n0));

//		TreeNode n0 = new TreeNode(10);
//		TreeNode n1 = new TreeNode(5);
//		TreeNode n2 = new TreeNode(15);
//		TreeNode n3 = new TreeNode(3);
//		TreeNode n4 = new TreeNode(8);
//		TreeNode n5 = new TreeNode(12);
//
//		n0.left = n1; n0.right = n2;
//		n1.left = n3; n1.right = n4;
//		n2.left = n5;

//		TreeNode n0 = new TreeNode(10);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);

//		n1.left = n2; n2.left = n4; n2.right = n5;
//		n5.left = n6; n1.right = n3; n3.right = n7;
//		n7.left = n8;

		n1.right = n2; n2.left = n3;

		System.out.println(inorderTraversal2(n1));
		
	}
	
	// Solution 2: Morris Inorder Traversal, Space ~ O(1)
	public static List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		TreeNode curr = root;
		
		while (curr != null) {
			// if curr has left children
			if (curr.left != null) { 
				TreeNode prev = curr.left;
				while (prev.right != null && prev.right != curr) {
					// find the rightmost node in curr's left subtree
					prev = prev.right;
				}
				if (prev.right == null) { // set right to successor, and go to left
					prev.right = curr;
					curr = curr.left;
				} else { // visit and revert the change, and go to right
					prev.right = null;
					list.add(curr.val);
					curr = curr.right;
				}
			} else { // if curr doesn't have left child, go to right
				list.add(curr.val);
				curr = curr.right;
			}
		}
		return list;
	}
}
