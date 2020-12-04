package leetcode.binaryTree;

import java.util.HashMap;
import java.util.Stack;

/**
 * 298. Binary Tree Longest Consecutive Sequence
 * @author yutian
 * @since Jan 3, 2016
 */
public class BinaryTreeLongestConsecutiveSequence {
	// this method is easy to extend to follow up BTLCS2
	static int res = 0;

	public static int longestConsecutive(TreeNode root) {
		helper(root);
		return res;
	}

	public static int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int l = 1, r = 1;
		if (node.left != null) {
			int left = helper(node.left);
			if (node.val == node.left.val - 1) {
				l = left + 1;
			}
		}
		if (node.right != null) {
			int right = helper(node.right);
			if (node.val == node.right.val - 1) {
				r = right + 1;
			}
		}
		int max = Math.max(l, r);
		res = Math.max(res, max);
		return max;
	}

	// Solution 1: Recursion 
	private int len = 0;
	
	public int longestConsecutive1(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, root.val);
        return len;
    }

	private void helper(TreeNode root, int curr, int target) {
		if (root == null) return;
		if (root.val == target) curr++;
		else curr = 1;
		len = Math.max(curr, len);
		helper(root.left, curr, root.val + 1);
		helper(root.right, curr, root.val + 1);
	}
	
	// Solution 2: Iterative Stack + Hashmap
	public int longestConsecutive2(TreeNode root) {
		if (root == null) return 0;
		int max = 1;
		Stack<TreeNode> stack = new Stack<>();
		HashMap<TreeNode, Integer> map = new HashMap<>();
		stack.push(root);
		map.put(root, 1);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			int left = curr.left != null && curr.left.val - curr.val == 1 ? map.get(curr) + 1: 1;
			int right = curr.right != null && curr.right.val - curr.val == 1 ? map.get(curr) + 1: 1;
			max = Math.max(max, Math.max(left, right));
			if (curr.right != null) {
				stack.push(curr.right);
				map.put(curr.right, right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
				map.put(curr.left, left);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		BinaryTreeLongestConsecutiveSequence t = new BinaryTreeLongestConsecutiveSequence();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.right = n3; n3.left = n2; n3.right = n4; n4.right = n5;
		System.out.println(t.longestConsecutive(n1));
		
	}

}
