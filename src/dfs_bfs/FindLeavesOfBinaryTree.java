package dfs_bfs;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 366. Find Leaves of Binary Tree
 * @author yutian
 * @since Jul 3, 2016
 */
public class FindLeavesOfBinaryTree {

	public static List<List<Integer>> findLeaves(binaryTree.TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		helper(root, res);
		return res;
	}

	private static int helper(binaryTree.TreeNode root, List<List<Integer>> res) {
		if (root == null) {
			return -1;
		}
		int height = 1 + Math.max(helper(root.left, res), helper(root.right, res));
		if (res.size() == height) {
			res.add(new ArrayList<>());
		}
		res.get(height).add(root.val);
		return height;
	}

	public static void main(String[] args) {
		binaryTree.TreeNode n0 = new binaryTree.TreeNode(1);
		n0.left = new binaryTree.TreeNode(2);
		n0.right = new binaryTree.TreeNode(3);
		n0.left.left = new binaryTree.TreeNode(4);
		n0.left.right = new TreeNode(5);

		System.out.println(findLeaves(n0));
	}
}
