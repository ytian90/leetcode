package leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. Symmetric Tree
 * @author yutian
 * @since Aug 10, 2015
 */
public class SymmetricTree {
	// Solution 1: Recursion
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
	
	// Solution 2: Iteration
	public boolean isSymmetric2(TreeNode root) {
		if (root == null) return true;
		Queue<TreeNode> left = new LinkedList<>();
		Queue<TreeNode> right = new LinkedList<>();
		left.add(root.left);
		right.add(root.right);
		while(!left.isEmpty() && !right.isEmpty()) {
			TreeNode l = left.remove();
			TreeNode r = right.remove();
			if (l == null && r == null) continue;
			else if (l == null || r == null) return false;
			if (l.val != r.val) {
				return false;
			} else {
				left.add(l.left);
				left.add(l.right);
				right.add(r.right);
				right.add(r.left);
			}
		}
		return true;
	}
}
