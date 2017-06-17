package dfs_bfs;
/**
 * Recover Binary Search Tree
 * @author yutian
 * @since Nov 9, 2015
 */
public class RecoverBinarySearchTree {
	
	/* Definition for a binary tree node */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	/* Morris Traversal */
	/* Time ~O(N), Space ~O(1) */
	public void recoverTree(TreeNode root) {
		TreeNode pre = null, first = null, second = null, temp = null;
		while (root != null) {
			if (root.left != null) {
				// connect threading for root
				temp = root.left;
				while (temp.right != null && temp.right != root) {
					temp = temp.right;
				}
				// the threading already exists
				if (temp.right != null) {
					if (pre != null && pre.val > root.val) {
						if (first == null) {
							first = pre;
							second = root;
						} else {
							second = root;
						}
					}
					pre = root;
					temp.right = null;
					root = root.right;
				} else {
					// construct the threading
					temp.right = root;
					root = root.left;
				}
			} else {
				if (pre != null && pre.val > root.val) {
					if (first == null) {
						first = pre;
						second = root;
					} else {
						second = root;
					}
				}
				pre = root;
				root = root.right;
			}
		}
		// swap two nodes values
		if (first != null && second != null) {
			int t = first.val;
			first.val = second.val;
			second.val = t;
		}
	}
	
	public static void main(String[] args) {

	}

}
