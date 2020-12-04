package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 113. Path Sum II
 * @author yutian
 * @since Aug 9, 2015
 */
public class PathSum2 {
	// Solution 1 DFS: Time ~O(N), Space ~O(logN)
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		helper(root, sum, path, res);
		return res;
	}

	private static void helper(TreeNode node, int sum, List<Integer> path, List<List<Integer>> res) {
		if (node == null) return;
		path.add(node.val);
		if (node.left == null && node.right == null && node.val == sum) {
			res.add(new ArrayList<>(path));
		}
		helper(node.left, sum - node.val, path, res);
		helper(node.right, sum - node.val, path, res);
		path.remove(path.size() - 1);
	}
	
	// iterative
	public static List<List<Integer>> pathSum2(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		int total = 0;
		TreeNode curr = root, prev = null;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null) {
				stack.push(curr);
				path.add(curr.val);
				total += curr.val;
				curr = curr.left;
			}
			curr = stack.peek();
			if (curr.right != null && curr.right != prev) {
				curr = curr.right;
				continue;
			}
			if (curr.left == null && curr.right == null && total == sum) {
				result.add(new ArrayList<Integer>(path));
			}
			prev = curr;
			stack.pop();
			path.remove(path.size() - 1);
			total -= curr.val;
			curr = null;
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(5);
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(11);
		TreeNode n4 = new TreeNode(13);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(1);
		TreeNode n9 = new TreeNode(5);

		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n5.right = n8;
		n5.left = n9;

		System.out.println(pathSum(n0, 22));

	}
	
}
