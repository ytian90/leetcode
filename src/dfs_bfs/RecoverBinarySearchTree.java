package dfs_bfs;

import java.util.Stack;

/**
 * 99. Recover Binary Search Tree
 * @author yutian
 * @since Nov 9, 2015
 */
public class RecoverBinarySearchTree {

	// method 1 : add in stack, check reverse sequence points and swap
	static Stack<TreeNode> stack = new Stack<>();

	public static void recoverTree2(TreeNode root) {
		helper(root);
		TreeNode prev = stack.pop();
		TreeNode min = null, max = null;
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			if (curr.val > prev.val) {
				if (min == null) {
					min = prev;
				}
				max = curr;
			}
			prev = curr;
		}
		int t = min.val;
		min.val = max.val;
		max.val = t;
	}

	public static void helper(TreeNode node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			helper(node.left);
		}
		stack.push(node);
		if (node.right != null) {
			helper(node.right);
		}
	}

	// method 2 : handle the max/min case inside inorder traversal
	static TreeNode first;
	static TreeNode second;
	static TreeNode prev;

	public static void recoverTree(TreeNode root) {
		inorder(root);
		int t = first.val;
		first.val = second.val;
		second.val = t;
	}

	public static void inorder(TreeNode node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		if (prev != null && (prev.val > node.val)) {
			if (first == null) {
				first = prev;
			}
			second = node;
		}
		prev = node;
		inorder(node.right);
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(3);
		n0.left = new TreeNode(1);
		n0.right = new TreeNode(4);
		n0.right.left = new TreeNode(2);

		recoverTree(n0);

		TreeNode n1 = new TreeNode(1);
		n1.left = new TreeNode(3);
		n1.left.right = new TreeNode(2);

		recoverTree(n1);
	}

}
