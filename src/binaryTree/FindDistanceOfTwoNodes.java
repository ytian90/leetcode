package binaryTree;

/**
 * Find the distance between two nodes of a binary tree.
 * https://shawnlincoding.wordpress.com/page/2/
 * http://algorithms.tutorialhorizon.com/find-the-distance-between-two-nodes-of-a-binary-tree/
 * Distance(X, Y) = Distance(root, X) +Distance(root, Y) — 2*(Distance(root to LCA(X,Y)))
 * @author yutian
 * @since Feb 5, 2016
 */
public class FindDistanceOfTwoNodes {
	
	public int distance(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || p == null || q == null)
			throw new IllegalArgumentException();
		TreeNode lca = lca(root, p, q);
		return depth(root, p) + depth(root,q) - 2 * depth(root, lca);
	}
	
	private int depth(TreeNode root, TreeNode p) {
		return helper(root, p, 0);
	}
	
	private int helper(TreeNode root, TreeNode node, int depth) {
		if (root == null) return -1;
		if (root == node) return depth;
		int left = helper(root.left, node, depth + 1);
		if (left != -1) return left;
		return helper(root.right, node, depth + 1);
	}

	private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		return left == null ? right: right == null ? left : root;
	}

	public static void main(String[] args) {
		/*
		 * 					1
		 * 				2		3
		 * 			  4   5   6    7
		 * 						8
		 */
		TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        
        node3.left = node6;
        node3.right = node7;
        node6.right = node8;
        
        FindDistanceOfTwoNodes ins = new FindDistanceOfTwoNodes();
        System.out.println(ins.distance(root, node4, node5));
        System.out.println(ins.distance(root, node4, node6));
        System.out.println(ins.distance(root, node3, node4));
        System.out.println(ins.distance(root, node2, node4));
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode (int v) {
			val = v;
		}
	}

}
