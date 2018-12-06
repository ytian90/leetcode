package binaryTree;

import java.util.Stack;

/**
 * 114. Flatten Binary Tree to Linked List
 * @author yutian
 * @since Aug 21, 2015
 */
public class FlattenBinaryTreeToLinkedList {
	// Solution 1 Recursion: Time ~ O(N), Space ~ O(logN) 
	public void flatten(TreeNode root) {
		if (root == null) return;
		// recursion
		flatten(root.left);
		flatten(root.right);
		if (root.left == null) return;
		// merge: root->left->right
		TreeNode p = root.left;
		while(p.right != null) p = p.right;
		p.right = root.right;
		root.right = root.left;
		root.left = null;
	}
	
	// Solution 2 Iteration (no Stack) Time ~ O(N), Space ~ O(1) 
	public void flatten2(TreeNode root) {
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left != null) {
				// connect the rightmost node in the left subtree to the right node
				if (curr.right != null) {
					TreeNode next = curr.left;
					while (next.right != null) next = next.right;
					next.right = curr.right;
				}
				// move left node to right
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}
	}
	
	// Solution 3 DFS discussion
	public void flatten3(TreeNode root) {
		if (root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode p = stack.pop();
			if (p.right != null) stack.push(p.right);
			if (p.left != null) stack.push(p.left);
			if (!stack.isEmpty()) p.right = stack.peek();
			p.left = null; // important
		}
	}
}
