package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 129. Sum Root to Leaf Numbers
 * @author yutian
 * @since Aug 23, 2015
 */
public class SumRootToLeafNumbers {
	
	// DFS recursion
	public static int sumNumbers(TreeNode root) {
		return helper(root, 0);
	}

	private static int helper(TreeNode node, int sum) {
		if (node == null) return 0;
		sum = 10 * sum + node.val;
		if (node.left == null && node.right == null) return sum;
		return helper(node.left, sum) + helper(node.right, sum);
	}
	
	// BFS iterative
	public int sumNumbers2(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> nums = new LinkedList<>();
		int result = 0;
		q.add(root);
		nums.add(0);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int num = nums.poll();
			num = num * 10 + node.val;
			if (node.left == null && node.right == null) {
				result += num;
				continue;
			}
			if (node.left != null) {
				q.add(node.left);
				nums.add(num);
			}
			if (node.right != null) {
				q.add(node.right);
				nums.add(num);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		n0.left = n1; n0.right = n2;
		System.out.println(sumNumbers(n0));
	}
}
