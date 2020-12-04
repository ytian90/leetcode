package leetcode.binaryTree;
/**
 * 110. Balanced Binary Tree
 * @author yutian
 * @since Jul 27, 2015
 */
public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		boolean[] isBalanced = {true};
		depth(root, isBalanced);
		return isBalanced[0];
	}

	private int depth(TreeNode node, boolean[] isBalanced) {
		if (node == null || !isBalanced[0]) return 0;
		int left = depth(node.left, isBalanced);
		int right = depth(node.right, isBalanced);
		if (Math.abs(left - right) > 1) {
			isBalanced[0] = false;
		}
		return 1 + Math.max(left, right);
	}

	// Solution 1: Brute force top-decr recursion Time ~O(NlogN)
	public boolean isBalancedd(TreeNode root) {
		if (root == null) return true;
		if (Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int depth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}
	
	// Solution 2: Bottom-incr recursion Time ~(N)
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
