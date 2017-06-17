package binaryTree;
/**
 * 104. Maximum Depth of Binary Tree
 * @author yutian
 * @since Jul 26, 2015
 */
public class MaximumDepthOfBinaryTree {
	// Time ~O(N) Space ~O(logN)
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
