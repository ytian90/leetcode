package binaryTree;

import java.util.TreeSet;

/**
 * 530. Minimum Absolute Difference in BST
 * @author ytian
 *
 */
public class MinimumAbsoluteDifferenceInBST {

	public static int getMinimumDifference(TreeNode root) {
		int[] res = new int[]{Integer.MAX_VALUE, -1};
		helper(root, res);
		return res[0];
	}

	private static void helper(TreeNode node, int[] res) {
		if (node == null) return;
		helper(node.left, res);
		if (res[1] != -1) {
			res[0] = Math.min(res[0], node.val - res[1]);
		}
		res[1] = node.val;
		helper(node.right, res);
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(2);
		n0.right = n1; n1.left = n2;

		System.out.println(getMinimumDifference(n0));
	}

	// In-Order Traverse time O(N) space O(1)
	Integer min = Integer.MAX_VALUE;
	Integer prev = null;
	
	public int getMinimumDifferencee(TreeNode root) {
        if (root == null) return min;
        getMinimumDifferencee(root.left);
        if (prev != null) {
        	min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifferencee(root.right);
        return min;
    }
	
	// Pre-Order Traverse
	TreeSet<Integer> set = new TreeSet<>();
	Integer res = Integer.MAX_VALUE;

	public int getMinimumDifference2(TreeNode root) {
		if (root == null) return res;
		if (!set.isEmpty()) {
			if (set.floor(root.val) != null) {
				res = Math.min(res, root.val - set.floor(root.val));
			}
			if (set.ceiling(root.val) != null) {
				res = Math.min(res, set.ceiling(root.val) - root.val);
			}
		}
		set.add(root.val);
		getMinimumDifference2(root.left);
		getMinimumDifference2(root.right);
		return res;
	}

}
