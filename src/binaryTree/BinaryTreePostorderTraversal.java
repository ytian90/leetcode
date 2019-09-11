package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 * @author yutian
 * @since Aug 17, 2015
 */
public class BinaryTreePostorderTraversal {

	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		helper(root, res);
		return res;
	}

	public static void helper(TreeNode node, List<Integer> res) {
		if (node == null) {
			return;
		}
		helper(node.left, res);
		helper(node.right, res);
		res.add(node.val);
	}

	public static List<Integer> postorderTraversal_iterative(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			res.add(0, curr.val);
			if (curr.left != null) {
				stack.push(curr.left);
			}
			if (curr.right != null) {
				stack.push(curr.right);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		n0.right = new TreeNode(2);
		n0.right.left = new TreeNode(3);
		System.out.println(postorderTraversal(n0));
	}
}
