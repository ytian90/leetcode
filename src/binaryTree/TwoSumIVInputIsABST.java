package binaryTree;

import java.util.HashSet;

/**
 * 653. Two Sum IV - Input is a BST
 * @author ytian
 *
 */
public class TwoSumIVInputIsABST {
	
	public static boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        HashSet<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }
	
	private static boolean helper(TreeNode root, int k, HashSet<Integer> set) {
		if (root == null) return false;
		if (set.contains(k - root.val)) return true;
		set.add(root.val);
		return helper(root.left, k, set) || helper(root.right, k, set);
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(5);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(7);
		n0.left = n1; n0.right = n2; n1.left = n3; n1.right = n4; n2.right = n5;
		System.out.println(findTarget(n0, 9));
		System.out.println(findTarget(n0, 28));
	}

}
