package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 199. Binary Tree Right Side View
 * @author yutian
 * @since Aug 24, 2015
 */
public class BinaryTreeRightSideView {
	// Solution 1: BFS Time ~O(N), Space ~O(N)
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if (i == size - 1) result.add(curr.val);
				if (curr.left != null) q.add(curr.left);
				if (curr.right != null) q.add(curr.right);
			}
		}
		return result;
	}
	
	// Solution 2 Recursion
	public List<Integer> rightSideView2(TreeNode root) {
		Map<Integer, Integer> map = new TreeMap<>();
		traverse(root, 0, map);
		return new ArrayList<>(map.values());
	}

	private void traverse(TreeNode root, int level, Map<Integer, Integer> map) {
		if (root == null) return;
		map.put(level, root.val);
		traverse(root.left, level + 1, map);
		traverse(root.right, level + 1, map);
	}
}
