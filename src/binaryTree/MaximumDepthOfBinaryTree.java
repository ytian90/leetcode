package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 * @author yutian
 * @since Jul 26, 2015
 */
public class MaximumDepthOfBinaryTree {
	// Time ~O(N) Space ~O(logN)
	public static int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static int maxDepth1(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int res = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(3);
		n0.left = new TreeNode(9);
		n0.right = new TreeNode(20);
		n0.right.left = new TreeNode(15);
		n0.right.right = new TreeNode(7);
		System.out.println(maxDepth(n0));
	}
}
