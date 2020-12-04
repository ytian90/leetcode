package leetcode.binaryTree;
/**
 * 543. Diameter of Binary Tree
 * @author ytian
 *
 */
public class DiameterofBinaryTree {

	private static int max = 0;

	public static int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		helper(root);
		return max;
	}

	private static int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = helper(node.left);
		int right = helper(node.right);
		max = Math.max(max, left + right);
		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		n0.left = new TreeNode(2);
		n0.right = new TreeNode(3);
		n0.left.left = new TreeNode(4);
		n0.left.right = new TreeNode(5);
		System.out.println(diameterOfBinaryTree(n0));
	}

}
