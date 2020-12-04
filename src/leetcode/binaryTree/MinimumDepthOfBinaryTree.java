package leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 * @author yutian
 * @since Jul 26, 2015
 */
public class MinimumDepthOfBinaryTree {
	// Solution 1: Depth-first traversal
	// DFS: Time ~ O(N), Space ~ O(logN) 
	public static int minDepth(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null) return 1 + minDepth(root.right);
		if (root.right == null) return 1 + minDepth(root.left);
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}
	// Solution 2: Breadth-first traversal
	// BFS: Time ~ O(N), Space ~ O(logN) 
	public static int minDepth2(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode rightMost = root;
		int depth = 1;
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left == null && node.right == null) break;
			if (node.left != null) q.add(node.left);
			if (node.right != null) q.add(node.right);
			if (node == rightMost) {
				depth++;
				rightMost = (node.right != null) ? node.right : node.left;
			}
		}
		return depth;
	}
	
	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);

		n0.left = n1; n0.right = n2; n2.left = n3; n2.right = n4;

		System.out.println(minDepth2(n0));

	}
}
