package binaryTree;

import java.util.ArrayList;

/**
 * Reverse Binary Tree
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=158721&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D5%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * @author yutian
 * @since Dec 14, 2015
 */
public class ReverseBinaryTree {

	/*
	 * original tree
	 * 			1
	 * 		2		3	
	 * 				  4
	 * 
	 * becomes
	 * 
	 * 		4
	 * 		  3		2
	 * 			 1
	 * head node is 4 and 2
	 * 
	 */
	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		
		n0.left = n1;
		n0.right = n2;
		n2.right = n3;
		
		ArrayList<TreeNode> result = reverse(n0);
		for (TreeNode n : result) {
			System.out.println(n.val);
		}
		
	}
	
	public static ArrayList<TreeNode> reverse(TreeNode root) {
		ArrayList<TreeNode> result = new ArrayList<>();
		helper(root, result);
		return result;
	}

	private static void helper(TreeNode root, ArrayList<TreeNode> result) {
		if (root.left == null && root.right == null) {
			result.add(root);
			return;
		}
		if (root.left != null) helper(root.left, result);
		if (root.right != null) helper(root.right, result);
	}
	
	

}
