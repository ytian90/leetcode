package binaryTree;
/**
 * 543. Diameter of Binary Tree
 * @author ytian
 *
 */
public class DiameterofBinaryTree {

	public static int diameterOfBinaryTree(TreeNode root) {
		int[] res = new int[1];
		helper(root, res);
		return res[0];
	}

	private static int helper(TreeNode node, int[] res) {
		if (node == null) return 0;
		int left = helper(node.left, res);
		int right = helper(node.right, res);
		res[0] = Math.max(res[0], left + right);
		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		n0.left = n1; n0.right = n2;
		n1.left = n3; n1.right = n4;
		
		System.out.println(diameterOfBinaryTree(n0));
	}

}
