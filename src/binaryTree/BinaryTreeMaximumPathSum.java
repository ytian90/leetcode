package binaryTree;
/**
 * 124. Binary Tree Maximum Path Sum
 * @author yutian
 * @since Jul 27, 2015
 */
public class BinaryTreeMaximumPathSum {
	
	public static int maxPathSum(TreeNode root) {
		int[] max = new int[]{Integer.MIN_VALUE};
		helper(root, max); // easy to make mistake !!
		return max[0];
	}

	private static int helper(TreeNode p, int[] max) {
		if (p == null) return 0;
		int left = helper(p.left, max);
		int right = helper(p.right, max);
		max[0] = Math.max(p.val + left + right, max[0]);
		int res = p.val + Math.max(left, right);
		return res > 0 ? res : 0;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		n0.left = n1; n0.right = n2;
		System.out.println(maxPathSum(n0));

		TreeNode n3 = new TreeNode(-10);
		TreeNode n4 = new TreeNode(9);
		TreeNode n5 = new TreeNode(20);
		TreeNode n6 = new TreeNode(15);
		TreeNode n7 = new TreeNode(7);
		n3.left = n4; n3.right = n5; n5.left = n6; n5.right = n7;
		System.out.println(maxPathSum(n3));
	}
}
