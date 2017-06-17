package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal 2
 * @author yutian
 * @since Aug 10, 2015
 */
public class BinaryTreeLevelOrderTraversal2 {
	
	// Solution 1 Time ~ O(N), Space ~ O(N) 
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) return result;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size(); // get size of level first
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				list.add(node.val);
				if (node.left != null) q.add(node.left);
				if (node.right != null) q.add(node.right);
			}
			// inserts and reverses the list
			result.add(0, list);
		}
		return result;
	}
		
	// Solution 2 recursion Time ~ O(N), Space ~ O(N) 
	public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		helper(root, 0, result);
		return result;
	}
	private static void helper(TreeNode node, int i, List<List<Integer>> result) {
		if (node == null) return;
		if (result.size() == i) result.add(0, new ArrayList<Integer>()); // modification
		result.get(result.size() - 1 - i).add(node.val); // modification
		helper(node.left, i + 1, result);
		helper(node.right, i + 1, result);
	}
	

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(3);
		TreeNode n1 = new TreeNode(9);
		TreeNode n2 = new TreeNode(20);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(7);
		
		n0.left = n1;
		n0.right = n2;
		n2.left = n3;
		n2.right = n4;
		
		List<List<Integer>> result = levelOrderBottom2(n0);
		for (List<Integer> list: result) {
			System.out.println(list);
		}
	}
}
