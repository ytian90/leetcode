package dfs_bfs;

import binaryTree.TreeNode;
import util.BTreePrinter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 99. Recover Binary Search Tree
 * @author yutian
 * @since Nov 9, 2015
 */
public class RecoverBinarySearchTree {
	// method 1: iterative inorder traversal
	public static void recoverTree(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode x = null, y = null, prev = null;
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			root = stack.removeLast();
			if (prev != null && root.val < prev.val) {
				y = root;
				if (x == null) x = prev;
				else break;
			}
			prev = root;
			root = root.right;
		}
		swap(x, y);
	}

	private static void swap(TreeNode x, TreeNode y) {
		int val = x.val;
		x.val = y.val;
		y.val = val;
	}

	// method 2: recursive inorder traversal
	static TreeNode x = null, y = null, prev = null;

	public static void findTwoNodesToSwap(TreeNode node) {
		if (node == null) {
			return;
		}
		findTwoNodesToSwap(node.left);
		if (prev != null && prev.val > node.val) {
			y = node;
			if (x == null) x = prev;
			else return;
		}
		prev = node;
		findTwoNodesToSwap(node.right);
	}

	public static void recoverTree2(TreeNode root) {
		findTwoNodesToSwap(root);
		swap(x, y);
	}

	// method 3: morris inorder traversal
	public static void recoverTree3(TreeNode root) {
		TreeNode x = null, y = null, prev = null;
		while (root != null) {
			if (root.left != null) {
				prev = root.left;
				while (prev.right != null && prev.right != root) {
					prev = prev.right;
				}
				if (prev.right == null) {
					prev.right = root;
					root = root.left;
				} else {
					if (prev != null && prev.val > root.val) {
						y = root;
						if (x == null) x = prev;
					}
					prev = root;
					prev.right = null;
					root = root.right;
				}
			} else {
				if (prev != null && prev.val > root.val) {
					y = root;
					if (x == null) x = prev;
				}
				prev = root;
				root = root.right;
			}
		}
		swap(x, y);
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(3);
		node.left.right = new TreeNode(2);
		BTreePrinter.printTreeNode(node);
		recoverTree(node);
		System.out.println();
		BTreePrinter.printTreeNode(node);

		binaryTree.TreeNode node1 = new binaryTree.TreeNode(3);
		node1.left = new binaryTree.TreeNode(1);
		node1.right = new binaryTree.TreeNode(4);
		node1.right.left = new binaryTree.TreeNode(2);
		BTreePrinter.printTreeNode(node1);
		recoverTree(node1);
		System.out.println();
		BTreePrinter.printTreeNode(node1);
	}


	// method 1 : add in stack, check reverse sequence points and swap
	static Stack<TreeNode> stack = new Stack<>();

	public static void recoverTree11(TreeNode root) {
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

//	// method 2 : handle the max/min case inside inorder traversal
//	static TreeNode first;
//	static TreeNode second;
//	static TreeNode prev;
//
//	public static void recoverTree22(TreeNode root) {
//		inorder(root);
//		int t = first.val;
//		first.val = second.val;
//		second.val = t;
//	}
//
//	public static void inorder(TreeNode node) {
//		if (node == null) {
//			return;
//		}
//		inorder(node.left);
//		if (prev != null && (prev.val > node.val)) {
//			if (first == null) {
//				first = prev;
//			}
//			second = node;
//		}
//		prev = node;
//		inorder(node.right);
//	}
//
//	public static void main(String[] args) {
//		TreeNode n0 = new TreeNode(3);
//		n0.left = new TreeNode(1);
//		n0.right = new TreeNode(4);
//		n0.right.left = new TreeNode(2);
//
//		recoverTree(n0);
//
//		TreeNode n1 = new TreeNode(1);
//		n1.left = new TreeNode(3);
//		n1.left.right = new TreeNode(2);
//
//		recoverTree(n1);
//	}

}
