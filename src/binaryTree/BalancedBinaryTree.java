package binaryTree;
/**
 * 110. Balanced Binary Tree
 * @author yutian
 * @since Jul 27, 2015
 */
public class BalancedBinaryTree {
	// Solution 1: Brute force top-down recursion Time ~O(NlogN)
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		if (Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int depth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
	
	// Solution 2: Bottom-up recursion Time ~(N)
	public boolean isBalanced2(TreeNode root) {
		return maxDepth(root) != -1;
	}
	private int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int L = maxDepth(root.left); // also need depth method in solution 1
		if (L == -1) return -1;
		int R = maxDepth(root.right);
		if (R == -1) return -1;
		return (Math.abs(L - R) <= 1) ? Math.max(L, R) + 1 : -1;
	}
}
