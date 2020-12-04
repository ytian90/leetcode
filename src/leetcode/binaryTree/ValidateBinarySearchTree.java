package leetcode.binaryTree;

import java.util.Stack;

/**
 * Validate Binary Search Tree
 * @author yutian
 * @since Jul 26, 2015
 */
public class ValidateBinarySearchTree {
	
	// Solution 3: Top-decr recursion (discussion)
	public static boolean isValidBTS(TreeNode root) {
		return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private static boolean helper(TreeNode node, long min, long max) {
		if (node == null) return true;
		if (node.val >= max || node.val <= min) return false;
		return helper(node.left, min, node.val) && helper(node.right, node.val, max);
	}

	// Iteration
	public static boolean isValidBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null, curr = root;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			if (prev != null && curr.val <= prev.val) {
				return false;
			}
			prev = curr;
			curr = curr.right;
		}
		return true;
	}
	
	// Solution 2: Top-decr recursion
	public static boolean isValidBST2(TreeNode root) {
		return valid(root, null, null);
	}

	private static boolean valid(TreeNode root, Integer min, Integer max) {
		if (root == null) return true;
		if ((min != null && root.val <= min) || (max != null && root.val >= max))
			return false;
		return valid(root.left, min, root.val) && valid(root.right, root.val, max);
	}
	
	// Solution 4: In-order traversal
	private static TreeNode prev;
	public static boolean isValidBST4(TreeNode root) {
		prev = null;
		return isMonotonicIncreasing(root);
	}

	private static boolean isMonotonicIncreasing(TreeNode p) {
		if (p == null) return true;
		if (isMonotonicIncreasing(p.left)) {
			if (prev != null && p.val <= prev.val)  return false;
			prev = p;
			return isMonotonicIncreasing(p.right);
		}
		return false;
	}
	

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(1);
		n0.left = n1;
		System.out.println(isValidBST2(n0));
		
		TreeNode n2 = new TreeNode(Integer.MIN_VALUE);
		TreeNode n3 = new TreeNode(Integer.MAX_VALUE);
		n2.right = n3;
		System.out.println(isValidBST2(n2));
		System.out.println(isValidBTS(n2));
	}
	
}
