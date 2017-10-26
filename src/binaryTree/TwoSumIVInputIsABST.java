package binaryTree;

import java.util.HashSet;

/**
 * 653. Two Sum IV - Input is a BST
 * @author ytian
 *
 */
public class TwoSumIVInputIsABST {
	
	public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        HashSet<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }
	
	private boolean helper(TreeNode root, int k, HashSet<Integer> set) {
		if (root == null) return false;
		if (set.contains(k - root.val)) return true;
		set.add(root.val);
		return helper(root.left, k, set) || helper(root.right, k, set);
	}

	public static void main(String[] args) {

	}

}
