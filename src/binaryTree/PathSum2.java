package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Path Sum II
 * @author yutian
 * @since Aug 9, 2015
 */
public class PathSum2 {
	// Solution 1 DFS: Time ~O(N), Space ~O(logN)
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		helper(root, sum, result, path);
		return result;
	}

	private void helper(TreeNode root, int sum,
			List<List<Integer>> result, ArrayList<Integer> path) {
		if (root == null) return;
		path.add(root.val);
		if (root.left == null && root.right == null && root.val == sum) {
		    result.add(new ArrayList<Integer>(path));
		}
		helper(root.left, sum - root.val, result, path);
		helper(root.right, sum - root.val, result, path);
		path.remove(path.size() - 1);
	}
	
	// iterative
	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
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
	
}
