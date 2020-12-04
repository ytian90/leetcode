package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * @author yutian
 * @since Aug 10, 2015
 */
public class BinaryTreeLevelOrderTraversal {
	// Solution 1 BFS Time ~ O(N), Space ~ O(N) 
	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null) return res;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size(); // maxPerformance size of level first
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				list.add(curr.val);
				if (curr.left != null) q.add(curr.left);
				if (curr.right != null) q.add(curr.right);
			}
			// inserts the list
			res.add(list);
		}
		return res;
    }
	
	// Solution 2: DFS Time ~ O(N), Space ~ O(N)
	private static List<List<Integer>> res = new ArrayList<>();
	
	public static List<List<Integer>> levelOrder2(TreeNode root) {
		helper(root, 0);
		return res;
	}

	private static void helper(TreeNode node, int i) {
		if (node == null) return;
		if (res.size() == i) res.add(new ArrayList<Integer>());
		res.get(i).add(node.val);
		helper(node.left, i + 1);
		helper(node.right, i + 1);
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
		
		List<List<Integer>> res = levelOrder(n0);
		for (List<Integer> list: res) {
			System.out.println(list);
		}
		
	}

}
