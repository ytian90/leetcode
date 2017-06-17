package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Find Path in Tree
 * @author yutian
 * @since Dec 14, 2015
 */
public class FindPathInTree {
	
	public static ArrayList<TreeNode> findPath(TreeNode root, TreeNode x, TreeNode y){
    	TreeNode lca = lca(root,x,y);
    	ArrayList<TreeNode> l1 = new ArrayList<TreeNode>();
    	ArrayList<TreeNode> l2 = new ArrayList<TreeNode>();
    	addToPath(l1, lca, x);
    	addToPath(l2, lca, y);

    	for(TreeNode n : l2){
    		if (n != lca) {
    			l1.add(n);
    		}
    	}
    	return l1;
    }

	private static boolean addToPath(ArrayList<TreeNode> res, TreeNode root, TreeNode n) {
		if (root == null) return false;
		res.add(root);
		if (root == n || addToPath(res, root.left, n) || addToPath(res, root.right, n)) {
			return true;
		}
		res.remove(root);
		return false;
	}

	private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) return root;
		TreeNode left = lca(root.left, p, q);
		TreeNode right = lca(root.right, p, q);
		return left == null ? right : right == null ? left : root;		
	}
	
	/*
	 * 						2
	 * 				7				5
	 * 			2		6				9
	 * 				   5  11		   4
	 * 
	 * assume we want 2 to 11
	 */

	public static void main(String[] args) {
		
		TreeNode n0 = new TreeNode(2);
		TreeNode n1 = new TreeNode(7);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(9);
		TreeNode n6 = new TreeNode(5);
		TreeNode n7 = new TreeNode(11);
		TreeNode n8 = new TreeNode(4);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n4.left = n6;
		n4.right = n7;
		n5.left = n8;
		
		List<TreeNode> res = findPath(n0, n3, n8);
		for (TreeNode t : res) {
			System.out.println(t.val);
		}
		
	}
}
