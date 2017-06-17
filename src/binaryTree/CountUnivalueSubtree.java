package binaryTree;
/**
 * 250. Count Univalue Subtrees
 * @author yutian
 * @since Dec 30, 2015
 */
public class CountUnivalueSubtree {
    
	private int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		postOrder(root);
		return count;
	}

	private boolean postOrder(TreeNode root) {
		if (root == null) return true;
		boolean left = postOrder(root.left);
		boolean right = postOrder(root.right);
		if (left && right) {
			if (root.left != null && root.left.val != root.val) return false;
			if (root.right != null && root.right.val != root.val) return false;
			count++;
			return true;
		}
		return false;
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
		CountUnivalueSubtree t = new CountUnivalueSubtree();
		System.out.println(t.countUnivalSubtrees(n0));
	}

}
