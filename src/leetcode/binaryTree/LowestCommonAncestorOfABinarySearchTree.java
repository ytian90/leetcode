package leetcode.binaryTree;
/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * @author yutian
 * @since Aug 1, 2015
 */
public class LowestCommonAncestorOfABinarySearchTree {
	
	// Iterative, O(1) space
	public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		// as long as both p and q are in the same subtree
		while ((root.val - (long)p.val) * (root.val - (long)q.val) > 0) { // in case of overflow
			root = p.val < root.val ? root.left : root.right;
		}
		return root;
	}

	// Solution 3 Time O(logN), Space O(logN)
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;
//		if (root == null || p == null || q == null) return null; // Both are fine.
		if (root.val < Math.min(p.val, q.val)) return lowestCommonAncestor(root.right, p, q);
		if (root.val > Math.max(p.val, q.val)) return lowestCommonAncestor(root.left, p, q);
		return root;
	}
	
	// Recursion
	public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
		return (root.val - p.val) * (root.val - q.val) < 1 ? root : 
			lowestCommonAncestor3(p.val < root.val ? root.left : root.right, p, q);
	}
	
	// Solution 2
	public static class Result {
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode n, boolean isAnc) {
			node = n;
			isAncestor = isAnc;
		}
	}
	
	Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return new Result(null, false);
		
		if (root == p && root == q)
			return new Result(root, true);
		
		Result rx = commonAncestorHelper(root.left, p, q);
		if (rx.isAncestor)
			return rx;
		
		Result ry = commonAncestorHelper(root.right, p, q);
		if (ry.isAncestor)
			return ry;
		
		if (rx.node != null && ry.node != null)
			return new Result(root, true); // This is the common ancestor
		else if (root == p || root == q) {
			boolean isAncestor = rx.node != null || ry.node != null ? true : false;
			return new Result(root, isAncestor);
		}
		else 
			return new Result(rx.node != null? rx.node : ry.node, false);
	}
	
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor)
        	return r.node;
        return null;
    }
	
	private static TreeNode makeTree() {
		TreeNode n0 = new TreeNode(6);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(0);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(9);
		TreeNode n7 = new TreeNode(3);
		TreeNode n8 = new TreeNode(5);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		n4.left = n7;
		n4.right = n8;
		
		return n0;
	}
	
	public static void main(String[] args){
		TreeNode root = makeTree();
		System.out.println(lowestCommonAncestor(root, root.left, root.left.right).val);
	}
}
