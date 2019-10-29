package binaryTree;
/**
 * 222. Count Complete Tree Nodes
 * @author yutian
 * @since Aug 13, 2015
 */
public class CountCompleteTreeNodes {

	public static int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	public static int countNode(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int l = height(root.left);
		int r = height(root.right);
		if (l == r) {
			return countNode(root.right) + (1 << l);
		}
		return countNode(root.left) + (1 << r);
	}

	private static int height(TreeNode node) {
		int h = 0;
		while (node != null) {
			h++;
			node = node.left;
		}
		return h;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		n0.left = new TreeNode(2);
		n0.right = new TreeNode(3);
		n0.left.left = new TreeNode(4);
		n0.left.right = new TreeNode(5);
		n0.right.left = new TreeNode(6);
		System.out.println(countNodes(n0));
	}

}
