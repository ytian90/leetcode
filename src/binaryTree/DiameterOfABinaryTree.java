package binaryTree;
/**
 * Diameter of a binary tree
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * @author yutian
 * @since Feb 11, 2016
 */
public class DiameterOfABinaryTree {
	// both method 1 and 2 need this!!
	TreeNode root;
	
	// Time Complexity: O(n^2)
	public int diameter(TreeNode root) {
		if (root == null) return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		
		// get the diameter of left and right subtrees
		int ld = diameter(root.left);
		int rd = diameter(root.right);
		
		// Return max of following three
		// 1) diameter of left subtree 2) diameter of right subtree
		// 3) height of left subtree + height of right subtree + 1
		return Math.max(lh + rh + 1, Math.max(ld, rd));
	}

	private int height(TreeNode node) {
		if (node == null) return 0;
		return (1 + Math.max(height(node.left), height(node.right)));
	}
	
	// optimized implementation: Time Complexity: O(n)
	class Height {
		int h;
	}
	
	public int diameterOpt(TreeNode root, Height height) {
		Height lh = new Height(), rh = new Height();
		if (root == null) {
			height.h = 0;
			return 0;
		}
		// get the heights of left and right subtrees in lh and rh and store
		// the returned values in ld and rd
		lh.h++; rh.h++;
		int ld = diameterOpt(root.left, lh);
		int rd = diameterOpt(root.right, rh);
		// height of current node is max of heights of left and right
		// subtrees plus 1
		height.h = Math.max(lh.h, rh.h) + 1;
		return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));
	}
	

	public static void main(String[] args) {
		DiameterOfABinaryTree tree = new DiameterOfABinaryTree();
		tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
 
        System.out.println("The diameter of given binary tree is : "
                           + tree.diameter(tree.root));
	}

}
