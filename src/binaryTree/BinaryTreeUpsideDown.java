package binaryTree;
/**
 * Binary Tree Upside Down
 * @author yutian
 * @since Jul 27, 2015
 */
public class BinaryTreeUpsideDown {
	// Solution 1: Top decr approach
	public static TreeNode UpsideDownBinaryTree(TreeNode root) {
		TreeNode p = root, parent = null, parentRight = null;
		while (p != null) {
			TreeNode left = p.left;
			p.left = parentRight;
			parentRight = p.right;
			p.right = parent;
			parent = p;
			p = left;
		}
		return parent;
	}
	// Solution 2: Bottom incr approach
	public static TreeNode UpsideDownBinaryTree2(TreeNode root) {
		return helper(root, null);
	}
	private static TreeNode helper(TreeNode p, TreeNode parent) {
		if (p == null) return parent;
		TreeNode root = helper(p.left, p);
		p.left = (parent != null) ? parent.right: null;
		p.right = parent;
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		
		TreeNode result = UpsideDownBinaryTree(n0);
		print(result);
	}
	private static void print(TreeNode n) {
		if (n == null) return;
		System.out.print(n.val + " ");
		print(n.left);
		print(n.right);
	}
	
	
}
