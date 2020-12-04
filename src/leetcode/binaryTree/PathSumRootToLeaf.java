package leetcode.binaryTree;

import java.util.Stack;

/**
 * Path sum from root to leaf
 * 题目1：求二叉树所有从根开始到叶子的所有路径和。
 * 题目2：不能用递归，完成以上题目
 * @author yutian
 * @since Feb 5, 2016
 */
public class PathSumRootToLeaf {
	// time O(N) space O(1)
	public int pathSum(TreeNode root) {
		if (root == null) return 0;
		return helper(root, 0);
	}
	
	private int helper(TreeNode root, int prev) {
		if (root == null) return 0;
		if (root.left == null && root.right == null)
			return prev + root.val;
		return helper(root.left, prev + root.val) + helper(root.right, prev + root.val);
	}
	
	// time O(N) space O(2N)
	public int pathSum2(TreeNode root) {
		if (root == null) return 0;
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> sums = new Stack<>();
		stack.push(root);
		sums.push(0);
		int result = 0;
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			int sum = sums.pop();
			if (curr.left == null && curr.right == null) {
				result += curr.val + sum;
			}
			if (curr.right != null) {
				stack.push(curr.right);
				sums.push(sum + curr.val);
			}
			if (curr.left != null) {
				stack.push(curr.left);
				sums.push(sum + curr.val);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        System.out.println(new PathSumRootToLeaf().pathSum2(root));
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode (int val) {
			this.val = val;
		}
	}
}
