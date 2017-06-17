package binaryTree;
/**
 * 285. Inorder Successor in BST
 * @author yutian
 * @since Jan 3, 2016
 */
public class InorderSuccessorInBST {
	
	// Solution 1 only in balanced BST O(h) = O(logn), ~O(N)
	public static TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
        	if (p.val < root.val) {
        		succ = root;
        		root = root.left;
        	} else {
        		root = root.right;
        	}
        }
        return succ;
    }
	
	// Solution 2 :Successor Recursion
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) return null;
        if (p.val < root.val) {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        } else {
            return inorderSuccessor(root.right, p);
        }
	}
	
	// Predecessor Recursion
	public static TreeNode predecessor(TreeNode root, TreeNode p) {
		if (root == null) return null;
		if (root.val >= p.val) {
			return predecessor(root.left, p);
		} else {
			TreeNode right = predecessor(root.right, p);
			return (right != null) ? right: root;
		}
	}

	public static void main(String[] args) {
		/*
		 * 				10
		 * 			5		15
		 * 		  1   8   12   16
		 */
		TreeNode n0 = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(15);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(8);
		TreeNode n5 = new TreeNode(12);
		TreeNode n6 = new TreeNode(16);
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.left = n5;
		n2.right = n6;
		
		System.out.println(inorderSuccessor(n0, n2).val);
		
	}

}
