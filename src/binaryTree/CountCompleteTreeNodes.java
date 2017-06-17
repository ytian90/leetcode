package binaryTree;
/**
 * Count Complete Tree Nodes
 * @author yutian
 * @since Aug 13, 2015
 */
public class CountCompleteTreeNodes {
	// Solution 1 time ~O(NlogN) Space ~O(1)
	public int countNodes(TreeNode root) {
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
	// Solution 2
	public int height (TreeNode root) {
		return root == null? -1 : 1 + height(root.left);
	}
	public int countNodes2(TreeNode root) {
		int h = height(root);
		return h < 0? 0 : 
			height(root.right) == h - 1? (1 << h) + countNodes2(root.right)
										:(1 << h - 1) + countNodes2(root.left);
	}
}
