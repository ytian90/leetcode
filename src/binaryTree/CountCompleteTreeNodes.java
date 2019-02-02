package binaryTree;
/**
 * 222. Count Complete Tree Nodes
 * @author yutian
 * @since Aug 13, 2015
 */
public class CountCompleteTreeNodes {

	public static int countNodes(TreeNode root) {
		int h = height(root);
		if (h < 0) return 0;
		if (height(root.right) == h - 1) {
			return (1 << h) + countNodes(root.right);
		} else {
			return (1 << h - 1) + countNodes(root.left);
		}
	}

	public static int height (TreeNode node) {
		return node == null? -1 : 1 + height(node.left);
	}

	public static int countNodes1(TreeNode root) {
		int nodes = 0, h = height(root);
		while (root != null) {
			if (height(root.right) == h - 1) {
				nodes += 1 << h;
				root = root.right;
			} else {
				nodes += 1 << h - 1;
				root = root.left;
			}
			h--;
		}
		return nodes;
	}

	public static void main(String[] args) {

	}

	// Solution 1 time ~O(NlogN) Space ~O(1)
	public static int countNodes2(TreeNode root) {
		int leftHeight = 0, rightHeight = 0;
		TreeNode left = root, right = root;
		while (left != null) {
			left = left.left;
			leftHeight++;
		}
		while (right != null) {
			right = right.right;
			rightHeight++;
		}
		// if heights are same, counts = 2 ^ n - 1, instead of using Math.pow(2, n),
		// we use bit manipulation: 1 << n, which is faster
		if (leftHeight == rightHeight) return (1 << leftHeight) - 1;
		else return 1 + countNodes(root.left) + countNodes(root.right);
	}

}
