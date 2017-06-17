package binaryTree;

import java.util.TreeSet;

/**
 * 530. Minimum Absolute Difference in BST
 * @author ytian
 *
 */
public class MinimumAbsoluteDifferenceInBST {
	
	// In-Order Traverse time O(N) space O(1)
	Integer min = Integer.MAX_VALUE;
	Integer prev = null;
	
	public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        getMinimumDifference(root.left);
        if (prev != null) {
        	min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
