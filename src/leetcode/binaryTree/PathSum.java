package leetcode.binaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 112. Path Sum
 * @author yutian
 * @since Aug 9, 2015
 */
public class PathSum {
	// Solution 1 Recursion Time ~O(N) Space ~O(logN)
	public static boolean hasPathSum(TreeNode root, int sum) {
		return helper(root, sum);
	}

	private static boolean helper(TreeNode node, int sum) {
		if (node == null) return false;
		if (node.left == null && node.right == null) {
			return node.val == sum;
		}
		return helper(node.left, sum - node.val) || helper(node.right, sum - node.val);
	}
	
	// Solution 2 Stack BFS Time ~O(N) Space ~O(2N)
	public static boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null) return false;
		Deque<TreeNode> stack = new LinkedList<>();
		Deque<Integer> sums = new LinkedList<>();
		stack.push(root);
		sums.push(sum);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			int val = sums.pop();
			if (curr.left == null && curr.right == null && curr.val == val)
				return true;
			if (curr.left != null) {
				stack.push(curr.left);
				sums.push(val - curr.val);
			}
			if (curr.right != null) {
				stack.push(curr.right);
				sums.push(val - curr.val);
			}
		}
		return false;
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
		
		n0.left = n1;
		n0.right = n2;
		n1.left = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n5.right = n8;
		
		System.out.println(hasPathSum2(n0, 22));
		
	}
	
}
