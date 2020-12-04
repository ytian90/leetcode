package leetcode.binaryTree;
/**
 * 124. Binary Tree Maximum Path Sum
 * @author yutian
 * @since Jul 27, 2015
 */
public class BinaryTreeMaximumPathSum {

	public static int maxPathSum(TreeNode root) {
		int[] max = new int[]{Integer.MIN_VALUE};
		helper(root, max);
		return max[0];
	}

	private static int helper(TreeNode node, int[] max) {
		if (node == null) return 0;
		int left = helper(node.left, max);
		int right = helper(node.right, max);
		max[0] = Math.max(max[0], node.val + left + right);
		int res = node.val + Math.max(left, right);
		return res > 0 ? res : 0;
	}

	public static int maxPathSum1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int[] res = new int[1];
		res[0] = Integer.MIN_VALUE;
		dfs(root, res);
		return res[0];
	}

	private static int dfs(TreeNode node, int[] res) {
		if (node == null) {
			return 0;
		}
		int left = Math.max(0, dfs(node.left, res));
		int right = Math.max(0, dfs(node.right, res));
		res[0] = Math.max(res[0], left + right + node.val);
		return Math.max(left, right) + node.val;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		n0.left = new TreeNode(2);
		n0.right = new TreeNode(3);
		System.out.println(maxPathSum(n0));

		TreeNode n1 = new TreeNode(-10);
		n1.left = new TreeNode(9);
		n1.right = new TreeNode(20);
		n1.right.left = new TreeNode(15);
		n1.right.right = new TreeNode(7);
		System.out.println(maxPathSum(n1));

		TreeNode n2 = new TreeNode(-2);
		n2.left = new TreeNode(1);
		System.out.println(maxPathSum(n2));

		TreeNode n3 = new TreeNode(-3);
		System.out.println(maxPathSum(n3));

		TreeNode n4 = new TreeNode(-2);
		n4.left = new TreeNode(-1);
		System.out.println(maxPathSum(n4));
	}
}
