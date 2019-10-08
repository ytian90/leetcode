package binaryTree;
/**
 * 285. Inorder Successor in BST
 * @author yutian
 * @since Jan 3, 2016
 */
public class InorderSuccessorInBST {
	/*
	let's take the successor for example, basically we always want to find p's closest node (in inorder traversal) and
	the node's value is larger than p's value, right? That node can either be p's parent or the smallest node in p' right branch.
	When the code runs into the else block, that means the current root is either p's parent or a node in p's right branch.
	If it's p's parent node, there are two scenarios: 1. p doesn't have right child, in this case, the recursion will
	eventually return null, so p's parent is the successor; 2. p has right child, then the recursion will return the
	smallest node in the right sub tree, and that will be the answer.
	If it's p's right child, there are two scenarios: 1. the right child has left sub tree, eventually the smallest
	node from the left sub tree will be the answer; 2. the right child has no left sub tree, the recursion will return
	null, then the right child (root) is our answer.
	 */
	public static TreeNode inorderSuccessor_iter(TreeNode root, TreeNode p) {
		TreeNode res = null;
		while (root != null) {
			if (p.val < root.val) {
				res = root;
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return res;
	}

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		return helper(root, p);
	}

	private static TreeNode helper(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}
		if (root.val <= p.val) {
			return helper(root.right, p);
		} else {
			TreeNode left = helper(root.left, p);
			return left == null ? root : left;
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
	public static TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
		if (root == null) return null;
        if (p.val < root.val) {
            TreeNode left = inorderSuccessor1(root.left, p);
            return (left != null) ? left : root;
        } else {
            return inorderSuccessor1(root.right, p);
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
}
