package leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * @author yutian
 * @since Aug 17, 2015
 */
public class BinaryTreePreorderTraversal {

	public static List<Integer> preorderTraversal(TreeNode root) {
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
		res.add(node.val);
		helper(node.left, res);
		helper(node.right, res);
	}

	public static List<Integer> preorderTraversal_iterative(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			res.add(curr.val);
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode n0 = new TreeNode(1);
		n0.right = new TreeNode(2);
		n0.right.left = new TreeNode(3);
		System.out.println(preorderTraversal(n0));
	}
	
	// root-left-right
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		
		while (curr != null) {
			list.add(curr.val);
			stack.push(curr);
			curr = curr.left;
		}
		
		while (!stack.isEmpty()) {
			curr = stack.pop();
			curr = curr.right;
			while (curr != null) {
				list.add(curr.val);
				stack.push(curr);
				curr = curr.left;
			}
		}
		return list;
	}
}
