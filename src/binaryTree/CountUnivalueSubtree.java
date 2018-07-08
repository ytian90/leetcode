package binaryTree;
/**
 * 250. Count Univalue Subtrees
 * @author yutian
 * @since Dec 30, 2015
 */
public class CountUnivalueSubtree {
    
	public static int countUnivalSubtrees(TreeNode root) {
		if (root == null) return 0;
		int[] res = new int[1];
		helper(root, res, root.val);
		return res[0];
	}

	private static boolean helper(TreeNode node, int[] res, int val) {
		if (node == null) return true;
		boolean l = helper(node.left, res, node.val);
		boolean r = helper(node.right, res, node.val);
		if (l && r) {
			res[0]++;
		}
		return l && r && val == node.val;
	}

	public static void main(String[] args) {
		/*
		 * 			5
		 * 		1		5
		 * 	  5   5       5
		 * 
		 */
		TreeNode n0 = new TreeNode(5);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(5);
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		System.out.println(countUnivalSubtrees(n0));
	}

}
