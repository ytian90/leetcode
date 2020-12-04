package leetcode.binaryTree;
/**
 * Find minimum value in a given range from BST
 * http://www.1point3acres.com/bbs/thread-167522-1-1.html
 * @author yutian
 * @since Jan 28, 2016
 */
public class FindMinValueInRangeFromBST {
	// Iterative
	public static int find(TreeNode root, int min, int max) {
		int minValue = Integer.MAX_VALUE;
		while (root != null) {
			if (root.val >= min && root.val <= max) {
				minValue = Math.min(minValue, root.val);
				root = root.left;
			} else if (root.val > max) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return minValue;
	}
	
	// Recursive
	public static int find2(TreeNode root, int min, int max) {
		int[] result = new int[]{Integer.MAX_VALUE};
		helper(root, min, max, result);
		return result[0];
	}

	private static void helper(TreeNode root, int min, int max, int[] result) {
		if (root == null) return;
		if (root.val > max) {
			helper(root.left, min, max, result);
		} else if (root.val < min) {
			helper(root.right, min, max, result);
		} else {
			result[0] = root.val;
			if (root.val == min) return;
			else helper(root.left, min, max, result);
		}
	}

	public static void main(String[] args) {

	}

}
